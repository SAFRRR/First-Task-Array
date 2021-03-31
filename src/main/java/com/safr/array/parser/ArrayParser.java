package com.safr.array.parser;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;

public class ArrayParser {
    public CustomArray parse(String line) throws ArrayException {
        String [] stringArray = line.split(" ");
        CustomArray customArray = new CustomArray(stringArray.length);
        for(int i = 0; i < stringArray.length; i++){
            customArray.setElement(i, Integer.parseInt(stringArray[i]));
        }
        return customArray;
    }
}