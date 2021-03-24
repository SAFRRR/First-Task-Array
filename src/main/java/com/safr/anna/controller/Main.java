package com.safr.anna.controller;

import com.safr.anna.entity.RandomArray;
import com.safr.anna.entity.ReplacementValues;
import com.safr.anna.service.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class Main {
    static final Logger LOG = LogManager.getLogger();
    public static void main(String[] args) {
        var array = new RandomArray().getArray();
       var replacement = new ReplacementValues();
       int src = replacement.getSrc();
       int dest = replacement.getDest();

        LOG.log(Level.INFO, "This program generate random array and executes operations." +
                "\n Array length - " + array.length +
                "\n Array :" + Arrays.toString(array) +
                "\n 1 - min element - " + MinMax.getMinValue(array)+
                "\n 2 - max element - " + MinMax.getMaxValue(array)+
                "\n 3 - replace " + src + " with " + dest + " : "+ Arrays.toString(Replacement.replace(array, src, dest)) +
                "\n 4 - average of the elements - " + AverageValue.getAverageValue(array)+
                "\n 5 - sum of the elements - " + Sum.getSum(array)+
                "\n 6 - number of negative elements - " + NotZeroValues.getNegativeNumbers(array)+
                "\n 7 - number of positive elements - " + NotZeroValues.getPositiveNumbers(array));
    }
}
