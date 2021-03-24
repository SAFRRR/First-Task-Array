package com.safr.anna.service;

public class MinMax {
    public static int getMaxValue(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }
    public static int getMinValue(int[] array){
        int min = array[0];
        for (int i = 1; i < array.length; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
}
