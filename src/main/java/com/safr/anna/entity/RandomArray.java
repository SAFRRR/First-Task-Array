package com.safr.anna.entity;

import java.util.Random;

public class RandomArray {
    final int BOUND = 50;
    final int MAX = 100;
    private final int [] array;

    public RandomArray(){
        Random random = new Random();
        int length = random.nextInt(BOUND);
        this.array = new int[length];
        for (int i = 0; i < this.array.length;i++){
            this.array[i] = random.nextInt(MAX)-BOUND;
        }
    }

    public int [] getArray(){return array;}

}
