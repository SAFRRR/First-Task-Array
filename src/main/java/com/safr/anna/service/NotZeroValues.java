package com.safr.anna.service;

public class NotZeroValues {


    public static int getPositiveNumbers(int [] array){
        int count = 0;
        for (int i : array) {
            if (i > 0) {
                count++;
            }
        }
        return count;
    }
    public static int getNegativeNumbers(int [] array){
        int count = 0;
        for (int i : array){
            if(i< 0){
                count++;
            }
        }
        return count;
    }
}
