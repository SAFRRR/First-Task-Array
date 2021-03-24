package com.safr.anna.entity;


import java.util.Random;

public class ReplacementValues {
    private final int src;
    private final int dest;
    final int BOUND = 50;

    public ReplacementValues(){
        Random random = new Random();
        this.src = random.nextInt(BOUND);
        this.dest = random.nextInt(BOUND);
    }

    public int getDest() {
        return dest;
    }

    public int getSrc() {
        return src;
    }
}
