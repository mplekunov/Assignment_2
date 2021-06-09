/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex27.Base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    @DisplayName("First Name is less than 2 characters")
    void validateInput_FirstName_Less_Than_Two_Characters() {
        assertEquals(InputFlags.INCORRECT_FORMAT,
                new Validation("H", "The Prince", "12345", "AA-1234").validateInput().getValue1());
    }

    @Test
    @DisplayName("First Name is empty")
    void validateInput_FirstName_Is_Empty() {
        assertEquals(InputFlags.INCORRECT_FORMAT,
                new Validation("", "The Prince", "12345", "AA-1234").validateInput().getValue1());
    }

    @Test
    @DisplayName("Last Name is less than 2 characters")
    void validateInput_LastName_Less_Than_Two_Characters() {
        assertEquals(InputFlags.INCORRECT_FORMAT,
                new Validation("Henry", "T", "12345", "AA-1234").validateInput().getValue1());
    }

    @Test
    @DisplayName("Last Name is empty")
    void validateInput_LastName_Is_Empty() {
        assertEquals(InputFlags.INCORRECT_FORMAT,
                new Validation("Henry", "", "12345", "AA-1234").validateInput().getValue1());
    }

    @Test
    @DisplayName("ZIP code isn't numeric")
    void validateInput_ZIP_Is_Not_Numeric() {
        assertEquals(InputFlags.INCORRECT_FORMAT,
                new Validation("Henry", "The Prince", "ISLOSER", "AA-1234").validateInput().getValue1());
    }

    @Test
    @DisplayName("ID format is incorrect")
    void validateInput_ID_Has_Incorrect_Format() {
        assertEquals(InputFlags.INCORRECT_FORMAT,
                new Validation("Henry", "The Prince", "12345", "Is-lose").validateInput().getValue1());

        assertEquals(InputFlags.INCORRECT_FORMAT,
                new Validation("Henry", "The Prince", "12345", "12-1234").validateInput().getValue1());

        assertEquals(InputFlags.INCORRECT_FORMAT,
                new Validation("Henry", "The Prince", "12345", "121234").validateInput().getValue1());

        assertEquals(InputFlags.INCORRECT_FORMAT,
                new Validation("Henry", "The Prince", "12345", "AA-12345").validateInput().getValue1());

        assertEquals(InputFlags.INCORRECT_FORMAT,
                new Validation("Henry", "The Prince", "12345", "IsLoser").validateInput().getValue1());
    }

    @Test
    @DisplayName("All input is correct")
    void validateInput_All_Input_Is_Correct() {
        assertEquals(InputFlags.CORRECT_FORMAT,
                new Validation("Henry", "The Prince", "12345", "AA-1234").validateInput().getValue1());
    }
}