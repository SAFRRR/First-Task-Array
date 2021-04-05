package com.safr.array.reader;

import com.safr.array.exception.ReaderException;
import com.safr.array.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArrayReader {
    private static final Logger logger = LogManager.getLogger();

    public String readFromFile(String filePath) throws ReaderException {
        if (filePath == null) {
            logger.error("File path is null");
            throw new ReaderException("File path is null");
        }
        File file = new File(filePath);
        if (!file.isFile()) {
            logger.error("Incorrect file path");
            throw new ReaderException("Incorrect file path");
        }
        if (file.length() == 0) {
            logger.error("File is empty");
            throw new ReaderException("File is empty");
        }
        ArrayValidator validator = new ArrayValidator();
        String resultString = null;
        Path path = Paths.get(filePath);
        try (var lines = Files.lines(path)) {
            resultString = lines
                    .filter(validator::validate)
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            logger.error("IOException  occurred while reading the file");
            throw new ReaderException("IOException  occurred while reading the file");
        }
        return resultString;
    }
}

