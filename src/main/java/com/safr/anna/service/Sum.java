package com.safr.anna.service;

public class Sum {
    public static int getSum(int [] array){
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum;
    }
}
