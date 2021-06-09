/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex31.Base;

public class KarvonenCalculator {
    private int age;
    private int restingHR;

    public KarvonenCalculator(int age, int restingHR) {
        this.age = age;
        this.restingHR = restingHR;
    }

    public int calculateHeartRate(int intensity) {
        return (int)Math.round((((220 - age) - restingHR) * intensity/100.0) + restingHR);
    }

    public void printHeartRateTable(int initialIntensity, int finalIntensity, int incrementBy) {
        System.out.printf("\nResting Pules: %d\tAge: %d\n", restingHR, age);
        System.out.println("Intensity   | Rate\n" +
                           "------------|--------");
        for (int i = initialIntensity; i <= finalIntensity; i+= incrementBy) {
            System.out.printf("%2d%%         | %3d bpm\n", i, calculateHeartRate(i));
        }
    }

}
