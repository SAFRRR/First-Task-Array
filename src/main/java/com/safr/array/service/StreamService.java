package com.safr.array.service;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;

public interface StreamService {
    int findMinValueStream(CustomArray customArray) throws ArrayException;
    int findMaxValueStream(CustomArray customArray) throws ArrayException;
    int findSumStream(CustomArray customArray) throws ArrayException;
    double findAverageValueStream(CustomArray customArray)throws ArrayException;
    int findPositiveNumbersAmountStream(CustomArray customArray)throws ArrayException;
    int findNegativeNumbersAmountStream(CustomArray customArray)throws ArrayException;
    CustomArray replaceValuesStream(CustomArray customArray, int src, int dest) throws ArrayException;

}
