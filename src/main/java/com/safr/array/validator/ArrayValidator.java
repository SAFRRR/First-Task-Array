package com.safr.array.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.regex.Pattern;

public class ArrayValidator {
    private static final Logger logger = LogManager.getLogger();
    private static final String REG_EXP = "^-?\\d+(\\s(-?\\d+))*$";

    public boolean validate(String validationString){
        boolean result;
        if (validationString == null){
            logger.error("String for validation is null");
            result = false;
        }
        result = Pattern.matches(REG_EXP, validationString);
        return result;
    }
}


