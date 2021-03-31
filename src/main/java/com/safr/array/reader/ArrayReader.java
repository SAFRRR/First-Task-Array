package com.safr.array.reader;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;
import com.safr.array.parser.ArrayParser;
import com.safr.array.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArrayReader {
    private final static Logger logger = LogManager.getLogger();

    public CustomArray readFromFile(String path) {
        CustomArray resultArray = null;
        String line;
        ArrayValidator arrayValidator = new ArrayValidator();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((line = bufferedReader.readLine()) != null) {
                if (arrayValidator.validate(line)){
                    ArrayParser arrayParser = new ArrayParser();
                    resultArray = arrayParser.parse(line);
                    logger.info("File read successfully");
                }else{
                    logger.error("File contains incorrect data");
                }
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found");
        } catch (IOException e) {
            logger.error("IOException  occurred while reading the file");
        } catch (ArrayException e) {
            logger.error("Array exception occurred while reading the file");
        }
        return resultArray;
    }
}
