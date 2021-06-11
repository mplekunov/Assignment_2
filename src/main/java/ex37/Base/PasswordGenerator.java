/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex37.Base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PasswordGenerator {
    private final static List<Character> specialCharacters = List.of('!', '?', '#', '$', '%', '^', '&' , '*');
    private final static int LETTER_STARTING_INDEX = 97;
    private final static int LETTER_ENDING_INDEX = 122;
    private final static int LETTER_LENGTH_OFFSET = 3;
    private final static int NUMBER_STARTING_INDEX = 48;
    private final static int NUMBER_ENDING_INDEX = 57;

    private int numberQTY;
    private int letterQTY;
    private final int specialCharQTY;
    private final int length;

    public PasswordGenerator(int numberQTY, int specialCharQTY, int length) {
        this.length = length;
        this.numberQTY = numberQTY;
        this.specialCharQTY = specialCharQTY;
        this.letterQTY = numberQTY + specialCharQTY;
    }

    public Password generatePassword() {
        List<Character> specialCharacters = new ArrayList<>();
        generateNumberStream(specialCharQTY, 0, PasswordGenerator.specialCharacters.size())
                .forEach(o -> specialCharacters.add(PasswordGenerator.specialCharacters.get(o)));

        List<Character> numbers = generateCharacters(numberQTY, NUMBER_STARTING_INDEX, NUMBER_ENDING_INDEX);

        List<Character> letters = generateCharacters(ThreadLocalRandom.current()
                .nextInt(letterQTY, (length - (numberQTY + specialCharQTY)) + LETTER_LENGTH_OFFSET), LETTER_STARTING_INDEX, LETTER_ENDING_INDEX);

        List<Character> password = Stream.of(specialCharacters, numbers, letters).flatMap(Collection::stream).collect(Collectors.toList());
        Collections.shuffle(password);

        return new Password(password.stream().map(String::valueOf).collect(Collectors.joining()));
    }

    private List<Character> generateCharacters(int size, int starting_index, int ending_index) {
        List<Character> characters = new ArrayList<>();
        generateNumberStream(size, starting_index, ending_index).forEach(o -> characters.add((char)o));
        return characters;
    }

    private IntStream generateNumberStream(int size, int starting_index, int ending_index) {
        return ThreadLocalRandom.current().ints(size, starting_index, ending_index);
    }


}
