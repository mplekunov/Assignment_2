package ex38.Base;

import java.util.List;
import java.util.stream.Collectors;

public final class CollectionManagement {
    private CollectionManagement() {}

    public static List<Double> findEvenNumber(List<Double> numbers) {
        return numbers.stream().filter(o -> o % 2 == 0).collect(Collectors.toList());
    }
}