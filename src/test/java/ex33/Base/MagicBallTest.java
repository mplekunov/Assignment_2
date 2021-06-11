package ex33.Base;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MagicBallTest {

    @Test
    void getAnswer_Returns_() {
        List<String> answerCollection = new java.util.ArrayList<>(List.of("Yes.", "No.", "Maybe.", "Ask again later."));

        Exception exception = null;

        try {
            while (!answerCollection.isEmpty())
                answerCollection.remove(MagicBall.getAnswer());
        } catch (IndexOutOfBoundsException ioob) {
            exception = ioob;
        }

        assertNull(exception);
    }
}