package com.safr.array.service;

import com.safr.array.entity.CustomArray;

public interface ReadService {
    public CustomArray readFromFile(String path);
}
