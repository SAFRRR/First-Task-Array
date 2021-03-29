package com.safr.array.service.impl;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;
import com.safr.array.service.SearchService;
import com.safr.array.service.SortService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSortService {
    CustomArray customArray;
    CustomArray expectedArray;
    SortService sortService;


    @BeforeClass
    public void setUp(){
        sortService = new SortServiceImpl();
        customArray = new CustomArray(new int[]{42,76,-12,7,4,-1,0,-23});
        expectedArray = new CustomArray(new int[]{-23, -12, -1, 0, 4, 7, 42, 76});
    }

    @Test
    public void checkShakerSort() throws ArrayException {
        sortService.shakerSort(customArray);
        Assert.assertEquals(customArray, expectedArray);
    }
    @Test
    public void checkMergeSort() throws ArrayException {
        sortService.mergeSort(customArray);
        Assert.assertEquals(customArray, expectedArray);
    }
    @Test
    public void checkQuickSort() throws ArrayException {
        sortService.quickSort(customArray);
        Assert.assertEquals(customArray, expectedArray);
    }
}