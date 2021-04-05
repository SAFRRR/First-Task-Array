package com.safr.array.main;

import com.safr.array.creator.CustomArrayCreator;
import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;
import com.safr.array.exception.ParserException;
import com.safr.array.exception.ReaderException;
import com.safr.array.parser.ArrayParser;
import com.safr.array.reader.ArrayReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        CustomArrayCreator creator = new CustomArrayCreator();
        ArrayReader reader = new ArrayReader();
        ArrayParser parser = new ArrayParser();
        ClassLoader loader = Main.class.getClassLoader();
        URL resource = loader.getResource("input/correct.txt");
        String path = new File(resource.getFile()).getAbsolutePath();
        logger.info("File path: " + path);
        try {
            String readString = reader.readFromFile(path);
            int [] parsedArray = parser.parseString(readString);
            CustomArray customArray = creator.createCustomArray(parsedArray);
            logger.info("Created array: " + customArray.toString());
        } catch (ReaderException e) {
            logger.error("Reader exception occurred while reading the file");
        }catch (ArrayException e){
            logger.error("Reader exception occurred while parsing string");
        } catch (ParserException e) {
            logger.error("Parser exception occurred while parsing string");
        }
    }
}

