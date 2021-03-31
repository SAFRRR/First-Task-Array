package com.safr.array.service;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;

public interface SortService {
    void shakerSort(CustomArray customArray)throws ArrayException;
    void mergeSort(CustomArray customArray)throws ArrayException;
    void quickSort(CustomArray customArray)throws ArrayException;
}
