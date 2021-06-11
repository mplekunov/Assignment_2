package ex38.Base;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Double> evenNumbers = CollectionManagement.findEvenNumber(fillNumberCollection());
        printEvenNumbers(evenNumbers);
    }

    public static List<Double> fillNumberCollection() {
        System.out.print("Enter a list of numbers, separated by spaces: ");
        String input = Input.readString(System.in);

        return Arrays.stream(input.split(" ")).map(Double::valueOf).collect(Collectors.toList());
    }

    public static void printEvenNumbers(List<Double> numbers) {
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.print("The even numbers are " + numbers.stream()
                .map(df::format).collect(Collectors.joining(" ")));
    }
}
