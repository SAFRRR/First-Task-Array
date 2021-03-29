package com.safr.array.service.impl;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;
import com.safr.array.service.SortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SortServiceImpl implements SortService {

    private final static Logger logger = LogManager.getLogger();
    public void shakerSort(CustomArray customArray) throws ArrayException {
        int left = 0;
        int temp = 0;
        int right = customArray.size() - 1;
        while (left <= right) {
            for (int i = right; i > left; --i) {
                if (customArray.get(i - 1) > customArray.get(i)) {
                    temp = customArray.get(i);
                    customArray.set(i, customArray.get(i - 1));
                    customArray.set(i - 1, temp);
                }
            }
            ++left;
            for (int i = left; i < right; ++i) {
                if (customArray.get(i) > customArray.get(i + 1)) {
                    temp = customArray.get(i);
                    customArray.set(i, customArray.get(i + 1));
                    customArray.set(i + 1, temp);
                }
            }
            --right;
        }
        logger.info("Sorted array : " + customArray);
    }

    public  void merge(CustomArray array, CustomArray buffer, int left, int right) throws ArrayException {
        if (left < right) {
            int middle = (left + right) / 2;
            merge(array, buffer, left, middle);
            merge(array, buffer, middle + 1, right);

            int k = left;
            for (int i = left, j = middle + 1; i <= middle || j <= right; ) {
                if (j > right || (i <= middle && array.get(i) < array.get(j))) {
                    buffer.set(k, array.get(i));
                    ++i;
                } else {
                    buffer.set(k, array.get(j));
                    ++j;
                }
                ++k;
            }
            for (int i = left; i <= right; ++i) {
                array.set(i, buffer.get(i));
            }
        }
    }
    public void mergeSort(CustomArray customArray) throws ArrayException {
        CustomArray buffer = new CustomArray(customArray.size());
        merge(customArray, buffer, 0, customArray.size()-1);
        logger.info("Sorted array : " + customArray);
    }
    int partition(CustomArray array, int left, int right) throws ArrayException {
        int tempRight = array.get(right);
        int tempLeft = left;
        int temp = 0;
        for (int i = left; i < right; ++i) {
            if (array.get(i) <= tempRight) {
                temp = array.get(i);
                array.set(i, array.get(tempLeft));
                array.set(tempLeft, temp);
                ++tempLeft;
            }
        }
        temp = array.get(tempLeft);
        array.set(tempLeft, array.get(right));
        array.set(right, temp);
        return tempLeft;
    }

    void quickSortImpl(CustomArray array, int left, int right) throws ArrayException {
        if (left < right) {
            int temp = partition(array, left, right);
            quickSortImpl(array, left, temp - 1);
            quickSortImpl(array, temp + 1, right);
        }
    }
    public void quickSort(CustomArray customArray) throws ArrayException {
        quickSortImpl(customArray, 0, customArray.size() - 1);
        logger.info("Sorted array : " + customArray);
    }
}
