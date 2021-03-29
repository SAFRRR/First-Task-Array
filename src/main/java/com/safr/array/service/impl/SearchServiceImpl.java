package com.safr.array.service.impl;

import com.safr.array.entity.CustomArray;
import com.safr.array.exception.ArrayException;
import com.safr.array.service.SearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchServiceImpl implements SearchService {
    private final static Logger logger = LogManager.getLogger();
    public int findMinValue(CustomArray array) throws ArrayException {
        int min = array.get(0);
        for (int i = 1; i < array.size(); i++){
            if(array.get(i) < min){
                min = array.get(i);
            }
        }
        logger.info("Min element - " + min);
        return min;
    }

    public int findMaxValue(CustomArray array) throws ArrayException {
        int max = array.get(0);
        for (int i = 1; i < array.size(); i++){
            if(array.get(i) > max){
                max = array.get(i);
            }
        }
        logger.info("Max element - " + max);
        return max;
    }

    public int findSum(CustomArray array)throws ArrayException{
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        logger.info("Sum of the elements - " + sum);
        return sum;
    }

    public double findAverageValue(CustomArray array)throws ArrayException{
        double averageValue = (double) findSum(array)/array.size();
        logger.info("Average value - " + averageValue);
        return averageValue;
    }

    public int findNegativeNumbersAmount(CustomArray array)throws ArrayException{
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < 0) {
                count++;
            }
        }
        logger.info("Amount of negative elements - " + count);
        return count;
    }

    public int findPositiveNumbersAmount(CustomArray array)throws ArrayException{
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > 0) {
                count++;
            }
        }
        logger.info("Amount of positive elements - " + count);
        return count;
    }
    public void  replaceValues(CustomArray array, int src, int dest) throws ArrayException{
        for (int i = 0; i < array.size(); i++){
            if(array.get(i) == src){
                array.set(i, dest);
            }
        }
        logger.info("New array is : " + array);
    }

}
