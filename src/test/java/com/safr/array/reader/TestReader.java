package com.safr.array.reader;

import com.safr.array.creator.CustomArrayCreator;
import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;
import com.safr.array.exception.ParserException;
import com.safr.array.exception.ReaderException;
import com.safr.array.parser.ArrayParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

public class TestReader {
    ArrayReader arrayReader;
    ClassLoader loader;

    @BeforeClass
    public void setUp(){
        loader = TestReader.class.getClassLoader();
        arrayReader = new ArrayReader();
    }

    @Test (expectedExceptions = ReaderException.class)
    public void testEmptyFile() throws ReaderException {
        URL resource = loader.getResource("input/empty.txt");
        String path = new File(resource.getFile()).getAbsolutePath();
        String readString = arrayReader.readFromFile(path);
    }

    @Test
    public void testCorrectFile() throws ArrayException, ReaderException, ParserException {
        CustomArrayCreator creator = new CustomArrayCreator();
        CustomArray actual = creator.createCustomArray(new int[]{12, 42, -2, 24, -11, 0, 48, 6});
        URL resource = loader.getResource("input/correct.txt");
        String path = new File(resource.getFile()).getAbsolutePath();
        String readString = arrayReader.readFromFile(path);
        ArrayParser parser = new ArrayParser();
        int [] parsedArray = parser.parseString(readString);
        CustomArray expected = creator.createCustomArray(parsedArray);
        Assert.assertEquals(actual, expected);
    }

    @Test (expectedExceptions = ParserException.class)
    public void testIncorrectFile() throws ReaderException, ParserException {
        URL resource = loader.getResource("input/incorrect.txt");
        String path = new File(resource.getFile()).getAbsolutePath();
        String readString = arrayReader.readFromFile(path);
        ArrayParser parser = new ArrayParser();
        parser.parseString(readString);
    }

    @Test
    public void testMixFile() throws ArrayException, ReaderException, ParserException {
        CustomArrayCreator creator = new CustomArrayCreator();
        CustomArray actual = creator.createCustomArray(new int[]{12, 42, -2, 24, -11, 0, 48, 6});
        URL resource = loader.getResource("input/mix.txt");
        String path = new File(resource.getFile()).getAbsolutePath();
        String readString = arrayReader.readFromFile(path);
        ArrayParser parser = new ArrayParser();
        int [] parsedArray = parser.parseString(readString);
        CustomArray expected = creator.createCustomArray(parsedArray);
        Assert.assertEquals(actual, expected);
    }
}