package com.safr.array.service.impl;

import com.safr.array.entity.CustomArray;
import com.safr.array.service.ReadService;
import com.safr.array.service.SearchService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TestReadService {
    ReadService readService;

    @BeforeClass
    public void setUp(){
       readService = new ReadFileImpl();
    }

    @Test
    public void testEmptyFile()throws FileNotFoundException {
        CustomArray actual = null;
        CustomArray expected = readService.readFromFile("src/test/input/empty.txt");
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testCorrectFile() throws FileNotFoundException {
        CustomArray actual = new CustomArray(new int[]{12, 42, -2, 24, -11, 0, 48, 6});
        CustomArray expected = readService.readFromFile("src/test/input/correct.txt");
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testIncorrectFile() throws FileNotFoundException {
        CustomArray actual = null;
        CustomArray expected = readService.readFromFile("src/test/input/incorrect.txt");
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testReadFirstNotValidString() throws FileNotFoundException {
        CustomArray actual = new CustomArray(new int[]{12, 42, -2, 24, -11, 0, 48, 6});
        CustomArray expected = readService.readFromFile("src/test/input/mix.txt");
        Assert.assertEquals(actual, expected);
    }
}
