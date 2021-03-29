package com.safr.array.service;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;

public interface SortService {
    public void shakerSort(CustomArray customArray)throws ArrayException;
    public void mergeSort(CustomArray customArray)throws ArrayException;
    public void quickSort(CustomArray customArray)throws ArrayException;
}
