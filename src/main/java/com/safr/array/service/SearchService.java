package com.safr.array.service;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;

public interface SearchService {
    int findMinValue(CustomArray array) throws ArrayException;
    int findMaxValue(CustomArray array)throws ArrayException;
    double findAverageValue(CustomArray array)throws ArrayException;
    int findSum(CustomArray array)throws ArrayException;
    int findNegativeNumbersAmount(CustomArray array)throws ArrayException;
    int findPositiveNumbersAmount(CustomArray array)throws ArrayException;
    void replaceValues(CustomArray array, int src, int dest) throws ArrayException;
}
