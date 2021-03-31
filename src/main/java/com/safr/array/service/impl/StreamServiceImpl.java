package com.safr.array.service.impl;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;
import com.safr.array.service.StreamService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class StreamServiceImpl implements StreamService {

    public int findMinValueStream(CustomArray customArray) throws ArrayException {
        return Arrays.stream(customArray.getArray())
                .min()
                .orElseThrow(ArrayException::new);
    }

    public int findMaxValueStream(CustomArray customArray) throws ArrayException {
        return Arrays.stream(customArray.getArray())
                .max()
                .orElseThrow(ArrayException::new);
    }

    public int findSumStream(CustomArray customArray) throws ArrayException {
        return Arrays.stream(customArray.getArray())
                .sum();
    }

    public double findAverageValueStream(CustomArray customArray)throws ArrayException{
        return Arrays.stream(customArray.getArray())
                .average()
                .orElseThrow(ArrayException::new);
    }

    public int findPositiveNumbersAmountStream(CustomArray customArray)throws ArrayException{
        return (int) Arrays.stream(customArray.getArray())
                .filter(element -> element > 0)
                .count();
    }
    public int findNegativeNumbersAmountStream(CustomArray customArray)throws ArrayException{
        return (int) Arrays.stream(customArray.getArray())
                .filter(element -> element < 0)
                .count();
    }

    public CustomArray  replaceValuesStream(CustomArray customArray, int src, int dest) throws ArrayException{
         return new CustomArray(
                Arrays.stream(customArray.getArray())
                        .map(element -> element == src ? dest : element)
                        .toArray());
    }
}
