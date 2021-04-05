package com.safr.array.creator;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;

public class CustomArrayCreator {
    public CustomArray createCustomArray(int[] array) throws ArrayException {
        CustomArray customArray = new CustomArray(array.length);
        for (int i = 0; i < array.length; i++){
            customArray.setElement(i, array[i]);
        }
        return customArray;
    }
}
