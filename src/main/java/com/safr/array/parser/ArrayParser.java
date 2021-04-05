package com.safr.array.parser;

import com.safr.array.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String SPACE = "\\s+";

    public int [] parseString(String parseString) throws ParserException {
        if (parseString == null) {
            logger.error("String for parsing is null");
            throw new ParserException("String for parsing is nul");
        }
        String [] stringArray = parseString.split(SPACE);
        int [] resultArray = new int[stringArray.length];
        for(int i = 0; i < stringArray.length; i++){
            resultArray[i] = Integer.parseInt(stringArray[i]);
        }
        return resultArray;
    }
}
