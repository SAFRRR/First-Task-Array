package com.safr.array.reader;

import com.safr.array.entity.CustomArray;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TestArrayReader {
    ArrayReader arrayReader;

    @BeforeClass
    public void setUp(){
        arrayReader = new ArrayReader();
    }

    @Test
    public void testEmptyFile()throws FileNotFoundException {
        CustomArray actual = null;
        CustomArray expected = arrayReader.readFromFile("src/main/resources/input/empty.txt");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCorrectFile() throws FileNotFoundException {
        CustomArray actual = new CustomArray(new int[]{12, 42, -2, 24, -11, 0, 48, 6});
        CustomArray expected = arrayReader.readFromFile("src/main/resources/input/correct.txt");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testIncorrectFile() throws FileNotFoundException {
        CustomArray actual = null;
        CustomArray expected = arrayReader.readFromFile("src/main/resources/input/incorrect.txt");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testMixFile() throws FileNotFoundException {
        CustomArray actual = new CustomArray(new int[]{12, 42, -2, 24, -11, 0, 48, 6});
        CustomArray expected = arrayReader.readFromFile("src/main/resources/input/mix.txt");
        Assert.assertEquals(actual, expected);
    }
}
