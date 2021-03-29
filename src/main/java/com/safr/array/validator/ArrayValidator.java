package com.safr.array.validator;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;
import com.safr.array.exception.ValidationException;

import java.util.regex.Pattern;

public class ArrayValidator {
    private final static Pattern pattern = Pattern.compile("^([-+])?[0-9]*$");

    public static CustomArray validate(String line) throws ValidationException, ArrayException {
        CustomArray customArray = new CustomArray(line.split(" ").length);

        for (int i = 0; i < line.split(" ").length; i++) {
            if (pattern.matcher(line.split(" ")[i].trim()).find()) {
                customArray.set(i, Integer.parseInt(line.split(" ")[i]));
            } else {
                throw new ValidationException("Incorrect input");
            }
        }
        return customArray;
    }
}
