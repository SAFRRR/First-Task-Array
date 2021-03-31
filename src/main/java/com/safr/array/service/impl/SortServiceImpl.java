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
                if (customArray.getElement(i - 1) > customArray.getElement(i)) {
                    temp = customArray.getElement(i);
                    customArray.setElement(i, customArray.getElement(i - 1));
                    customArray.setElement(i - 1, temp);
                }
            }
            ++left;
            for (int i = left; i < right; ++i) {
                if (customArray.getElement(i) > customArray.getElement(i + 1)) {
                    temp = customArray.getElement(i);
                    customArray.setElement(i, customArray.getElement(i + 1));
                    customArray.setElement(i + 1, temp);
                }
            }
            --right;
        }
        logger.info("Shaker sort: sorted array : " + customArray);
    }

    public  void merge(CustomArray array, CustomArray buffer, int left, int right) throws ArrayException {
        if (left < right) {
            int middle = (left + right) / 2;
            merge(array, buffer, left, middle);
            merge(array, buffer, middle + 1, right);
            int k = left;
            for (int i = left, j = middle + 1; i <= middle || j <= right; ) {
                if (j > right || (i <= middle && array.getElement(i) < array.getElement(j))) {
                    buffer.setElement(k, array.getElement(i));
                    ++i;
                } else {
                    buffer.setElement(k, array.getElement(j));
                    ++j;
                }
                ++k;
            }
            for (int i = left; i <= right; ++i) {
                array.setElement(i, buffer.getElement(i));
            }
        }
    }

    public void mergeSort(CustomArray customArray) throws ArrayException {
        CustomArray buffer = new CustomArray(customArray.size());
        merge(customArray, buffer, 0, customArray.size()-1);
        logger.info("Merge sort: sorted array : " + customArray);
    }

    int partition(CustomArray array, int left, int right) throws ArrayException {
        int tempRight = array.getElement(right);
        int tempLeft = left;
        int temp = 0;
        for (int i = left; i < right; ++i) {
            if (array.getElement(i) <= tempRight) {
                temp = array.getElement(i);
                array.setElement(i, array.getElement(tempLeft));
                array.setElement(tempLeft, temp);
                ++tempLeft;
            }
        }
        temp = array.getElement(tempLeft);
        array.setElement(tempLeft, array.getElement(right));
        array.setElement(right, temp);
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
        logger.info("Quick sort: sorted array : " + customArray);
    }
}
