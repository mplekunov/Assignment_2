/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex27.Base;

import org.javatuples.Pair;

public class Validation {
    private final String firstName;
    private final String lastName;
    private final String zipCode;
    private final String id;


    public Validation(String firstName, String lastName, String zipCode, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.id = id;
    }

    public Pair<String, InputFlags> validateInput() {
        String result = "";
        InputFlags inputFlag;

        inputFlag = isNameCorrect(firstName);
        if (inputFlag == InputFlags.EMPTY)
            result = result.concat("The first name must be filled in.\n");
        else if (inputFlag == InputFlags.LESS_THAN_TWO_CHAR_LONG)
            result = result.concat("\"").concat(firstName).concat("\" is not a valid first name. It is too short.\n");

        inputFlag = isNameCorrect(lastName);
        if (inputFlag == InputFlags.EMPTY)
            result = result.concat("The last name must be filled in.\n");
        else if (inputFlag == InputFlags.LESS_THAN_TWO_CHAR_LONG)
            result  = result.concat("\"").concat(lastName).concat("\" is not a valid last name. It is too short.\n");

        inputFlag = isZipCodeCorrect();
        if (inputFlag == InputFlags.ZIP_CODE_INCORRECT_FORMAT)
            result = result.concat("The ZIP code must be numeric.\n");

        inputFlag = isIdCorrect();
        if (inputFlag == InputFlags.ID_INCORRECT_FORMAT)
            result = result.concat(id).concat(" is not a valid ID.\n");

        if (result.isEmpty()) {
            result = result.concat("There were no errors found.\n");
            inputFlag = InputFlags.CORRECT_FORMAT;
        }
        else
            inputFlag = InputFlags.INCORRECT_FORMAT;

        return new Pair<>(result, inputFlag);
    }

    private InputFlags isNameCorrect(String name) {

        if (name.length() < 2) {
            if (name.length() == 0)
                return InputFlags.EMPTY;
            return InputFlags.LESS_THAN_TWO_CHAR_LONG;
        }

        return InputFlags.CORRECT_FORMAT;
    }

    private InputFlags isZipCodeCorrect() {
        return zipCode.matches("^[0-9]{5}$") ? InputFlags.CORRECT_FORMAT : InputFlags.ZIP_CODE_INCORRECT_FORMAT;
    }

    private InputFlags isIdCorrect() {
        return id.matches("^[a-zA-Z]{2}[-][0-9]{4}$") ? InputFlags.CORRECT_FORMAT : InputFlags.ID_INCORRECT_FORMAT;
    }
}
