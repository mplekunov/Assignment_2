/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex28.Base;

import java.util.List;

public final class TotalCalculator {
    private TotalCalculator(){ }

    public static double calculateTotal(List<Double> numbers) {
        var wrapper = new Object() {double total = 0;};

        numbers.forEach(o -> wrapper.total += o);

        return wrapper.total;
    }
}
