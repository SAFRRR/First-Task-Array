package com.safr.array.service;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;

public interface SearchService {
    public int findMinValue(CustomArray array) throws ArrayException;
    public int findMaxValue(CustomArray array)throws ArrayException;
    public double findAverageValue(CustomArray array)throws ArrayException;
    public int findSum(CustomArray array)throws ArrayException;
    public int findNegativeNumbersAmount(CustomArray array)throws ArrayException;
    public int findPositiveNumbersAmount(CustomArray array)throws ArrayException;
    public void replaceValues(CustomArray array, int src, int dest) throws ArrayException;
}
