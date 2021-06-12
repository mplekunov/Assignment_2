package ex38.Base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionManagementTest {

    @Test
    @DisplayName("findEvenNumber differentiate between even and odd numbers")
    void findEvenNumber_Returns_Evens() {
        ArrayList<Double> numbers = new ArrayList<>(List.of(1.0,2.0,3.0,4.0,5.0));
        ArrayList<Double> even = new ArrayList<>(List.of(2.0,4.0));

        assertEquals(CollectionManagement.findEvenNumber(numbers), even);
    }
}