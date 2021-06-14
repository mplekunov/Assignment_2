/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex38.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class CollectionManagement {
    private CollectionManagement() {}

    public static List<Double> findEvenNumber(List<Double> numbers) {
        List<Double> temp = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0)
                temp.add(numbers.get(i));
        }
        return temp;
        //return numbers.stream().filter(o -> o % 2 == 0).collect(Collectors.toList());
    }
}
