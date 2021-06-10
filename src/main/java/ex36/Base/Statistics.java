/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex36.Base;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
    private final ArrayList<Double> numbers;

    public Statistics() {
        numbers = new ArrayList<>();
    }

    public Statistics(List<Double> numbers) {
        this();
        this.numbers.addAll(numbers);
    }

    public double getAverage() {
        var wrapper = new Object() {double sum = 0;};
        numbers.forEach(o -> wrapper.sum += o);

        return wrapper.sum / numbers.size();
    }

    public double getMin() {
       return numbers.stream().min(Double::compare).orElseThrow();
    }

    public double getMax() {
        return numbers.stream().max(Double::compare).orElseThrow();
    }

    public double getStandardDeviation() {
        var wrapper = new Object() {double value = 0;};

        double mean = getAverage();

        numbers.forEach(o -> wrapper.value += Math.pow(o - mean, 2));

        return Math.sqrt(wrapper.value / numbers.size());
    }

    public ArrayList<Double> getNumbers() {
        return numbers;
    }
}

