package com.safr.array.entity;

import com.safr.array.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class CustomArray {

    private final static Logger logger = LogManager.getLogger();
    private int [] array;

    public CustomArray(){}

    public CustomArray(int [] array){
        this.array = array;
    }

    public CustomArray(int size) throws ArrayException {
        if(size < 1){
            logger.error("Incorrect array size");
            throw new ArrayException("Incorrect array size");
        }
        this.array = new int[size];
    }

    public int get(int index) throws ArrayException {
        if (index < 0 || index >= array.length){
            logger.error("Index out of bounds");
            throw new ArrayException("Index out of bounds");
        }
        return array[index];
    }

    public void set(int index, int value) throws ArrayException {
        if (index < 0 || index >= array.length){
            logger.error("Index out of bounds");
            throw new ArrayException("Index out of bounds");
        }
        array[index] = value;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        CustomArray temp = (CustomArray) obj;
        return Arrays.equals(array, temp.array);
    }

    @Override
    public int hashCode(){
        return Arrays.hashCode(array);
    }

    @Override
    public String toString(){
        return "CustomArray" + Arrays.toString(array);
    }

    public int size(){
        return array.length;
    }
}
