package com.safr.anna.service;

public class Replacement {

    public static int [] replace(int [] array, int src, int dest){
        for (int i = 0;i < array.length;i++){
            if(array[i] == src){
                array[i] = dest;
            }
        }
        return array;
    }
}
