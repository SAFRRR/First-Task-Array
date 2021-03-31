package com.safr.array.service.impl;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;
import com.safr.array.service.SearchService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSearchService {
    CustomArray customArray;
    SearchService searchService;

    @BeforeClass
    public void setUp(){
        searchService = new SearchServiceImpl();
        customArray = new CustomArray(new int[]{4,76,-1,7,4,-1,0,-23});
    }

    @Test(expectedExceptions = ArrayException.class)
    public void initialization() throws ArrayException {
         new CustomArray(-1);
    }

    @Test
    public void checkSize(){
        Assert.assertEquals(customArray.size(), 4);
    }

    @Test
    public void getElement() throws ArrayException {
        Assert.assertEquals(customArray.getElement(0), 1);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void outOfBundles() throws ArrayException {
        customArray.getElement(-2);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void set() throws ArrayException {
        customArray.setElement(-2, 4);
    }

    @Test
    public void setCorrectValue() throws ArrayException {
        customArray.setElement(2, 4);
        Assert.assertEquals(customArray.getElement(2), 4);
    }

    @Test
    public void checkMinValue() throws ArrayException {
        Assert.assertEquals(searchService.findMinValue(customArray), -23);
    }
    @Test
    public void checkMaxValue() throws ArrayException {
        Assert.assertEquals(searchService.findMaxValue(customArray), 76);
    }

    @Test
    public void checkAverageValue() throws ArrayException {
        Assert.assertEquals(searchService.findAverageValue(customArray), 8.25);
    }

    @Test
    public void checkSum() throws ArrayException {
        Assert.assertEquals(searchService.findSum(customArray), 66);
    }

    @Test
    public void checkNegativeValues() throws ArrayException {
        Assert.assertEquals(searchService.findNegativeNumbersAmount(customArray), 3);
    }

    @Test
    public void checkPositiveValues() throws ArrayException {
        Assert.assertEquals(searchService.findPositiveNumbersAmount(customArray), 4);
    }

    @Test
    public void checkReplace() throws ArrayException {
        searchService.replaceValues(customArray, -1,0);
        Assert.assertEquals(customArray.getElement(2), 0);
    }
}
