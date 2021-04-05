package com.safr.array.service.impl;

import com.safr.array.creator.CustomArrayCreator;
import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;
import com.safr.array.service.SortService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSortService {
    CustomArray customArray;
    CustomArray expectedArray;
    CustomArray incorrectArray;
    SortService sortService;

    @BeforeClass
    public void setUp() throws ArrayException {
        sortService = new SortServiceImpl();
        CustomArrayCreator creator = new CustomArrayCreator();
        customArray = creator.createCustomArray(new int[]{42,76,-12,7,4,-1,0,-23});
        expectedArray = creator.createCustomArray(new int[]{-23, -12, -1, 0, 4, 7, 42, 76});
        incorrectArray = creator.createCustomArray(new int[]{-2, -2, -10, 6, 4, 7, 42, 76});
    }

    @Test
    public void checkShakerSort() throws ArrayException {
        sortService.shakerSort(customArray);
        Assert.assertEquals(customArray, expectedArray);
    }

    @Test
    public void checkIncorrectShakerSort() throws ArrayException {
        sortService.shakerSort(customArray);
        Assert.assertNotEquals(customArray, incorrectArray);
    }

    @Test
    public void checkMergeSort() throws ArrayException {
        sortService.mergeSort(customArray);
        Assert.assertEquals(customArray, expectedArray);
    }

    @Test
    public void checkIncorrectMergeSort() throws ArrayException {
        sortService.mergeSort(customArray);
        Assert.assertNotEquals(customArray, incorrectArray);
    }

    @Test
    public void checkQuickSort() throws ArrayException {
        sortService.quickSort(customArray);
        Assert.assertEquals(customArray, expectedArray);
    }

    @Test
    public void checkIncorrectQuickSort() throws ArrayException {
        sortService.quickSort(customArray);
        Assert.assertNotEquals(customArray, incorrectArray);
    }
}