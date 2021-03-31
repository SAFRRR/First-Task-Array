package com.safr.array.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayValidator {

    public boolean validate(String line){
        String regExp = "^([-])?\\d+(\\s(([-])?\\d+))*$";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(line.trim());
        return matcher.find();
    }
}