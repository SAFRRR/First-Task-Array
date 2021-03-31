package com.safr.array.service.impl;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;
import com.safr.array.service.StreamService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestStreamService {
    CustomArray customArray;
    StreamService streamService;

    @BeforeClass
    public void setUp(){
        streamService = new StreamServiceImpl();
        customArray = new CustomArray(new int[]{4,76,-1,7,4,-1,0,-23});
    }

    @Test
    public void checkMinValue() throws ArrayException {
        Assert.assertEquals(streamService.findMinValueStream(customArray), -23);
    }

    @Test
    public void checkMaxValue() throws ArrayException {
        Assert.assertEquals(streamService.findMaxValueStream(customArray), 76);
    }

    @Test
    public void checkAverageValue() throws ArrayException {
        Assert.assertEquals(streamService.findAverageValueStream(customArray), 8.25);
    }

    @Test
    public void checkSum() throws ArrayException {
        Assert.assertEquals(streamService.findSumStream(customArray), 66);
    }

    @Test
    public void checkNegativeValues() throws ArrayException {
        Assert.assertEquals(streamService.findNegativeNumbersAmountStream(customArray), 3);
    }

    @Test
    public void checkPositiveValues() throws ArrayException {
        Assert.assertEquals(streamService.findPositiveNumbersAmountStream(customArray), 4);
    }

    @Test
    public void checkReplace() throws ArrayException {
        CustomArray array = streamService.replaceValuesStream(customArray, -1,0);
        Assert.assertEquals(array.getElement(2), 0);
    }
}
