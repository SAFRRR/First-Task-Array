package com.safr.array.service.impl;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;
import com.safr.array.exception.ValidationException;
import com.safr.array.service.ReadService;
import com.safr.array.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileImpl implements ReadService {
    private final static Logger logger = LogManager.getLogger();

    public CustomArray readFromFile(String path) {
        CustomArray resultArray = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                try{
                    resultArray =  ArrayValidator.validate(line);
                    logger.info("string " + line + " is read");
                    return resultArray;
                } catch (ValidationException e) {
                    resultArray = null;
                    line = bufferedReader.readLine();
                    logger.error("Incorrect input");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayException e) {
            e.printStackTrace();
        }
        return resultArray;
    }
}

