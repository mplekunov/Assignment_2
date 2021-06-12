/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex32.Base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

class NumberGuesserTest {

    @ParameterizedTest
    @ValueSource(ints = {10, 100, 1000})
    @DisplayName("startGame should return number within provided range")
    void startGame_Returns_Number_In_The_Bounds(int maxNum) {
        int num = NumberGuesser.getRandomNumber(1, maxNum);
        assertTrue(num <= maxNum);
    }
}