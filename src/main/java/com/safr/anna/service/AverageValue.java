package com.safr.anna.service;

public class AverageValue {
    public static double getAverageValue(int [] array){
        int averageValue = 0;
        for (int j : array) {
            averageValue += j;
        }
        averageValue /= array.length;
        return averageValue;
    }
}
