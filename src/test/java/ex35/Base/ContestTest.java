package ex35.Base;

import ex34.Base.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ContestTest {
    private final static ContestDatabase database = new ContestDatabase();

    public ContestTest() {
        database.addContestants(List.of(
                new Contestant("Prince"),
                new Contestant("Henry"),
                new Contestant("Did"),
                new Contestant("Nothing"),
                new Contestant("Wrong")));
    }

    @ParameterizedTest
    @MethodSource("getDatabase")
    @DisplayName("Database finds contestant by Contestant object")
    void findContestant_By_Object(Contestant contestant) {
        Exception exception = null;
        try {
            database.findContestant(contestant);
        } catch (NoSuchElementException nse) {
            exception = nse;
        }

        assertNull(exception);
    }

    @Test
    @DisplayName("Database finds contestant by Contestant object")
    void findContestant_By_Index() {
        Exception exception = null;
        for (int index = 0; index < database.getContestantDBSize(); index++) {
            try {
                database.findContestant(index);
            } catch (NoSuchElementException nse) {
                exception = nse;
            }
        }

        assertNull(exception);
    }

    @Test
    @DisplayName("drawWinner returns Contestant that is in database")
    void drawWinner() {
        Exception exception = null;
        try {
            database.findContestant(Contest.drawWinner(database));
        } catch (NoSuchElementException nse) {
            exception = nse;
        }

        assertNull(exception);
    }

    @ParameterizedTest
    @MethodSource("getDatabase")
    @DisplayName("Database removes Contestant")
    void removeContestantTest(Contestant contestant) {
        assertTrue(database.removeContestant(contestant));
    }

    static Stream<Contestant> getDatabase() {
        return Stream.of(new Contestant("Prince"), new Contestant("Henry"));
    }
}