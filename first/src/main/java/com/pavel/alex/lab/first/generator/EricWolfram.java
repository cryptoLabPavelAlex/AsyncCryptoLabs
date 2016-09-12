package com.pavel.alex.lab.first.generator;

import java.util.Random;


public class EricWolfram implements Generator {

    private long r;

    private long firstState;

    public EricWolfram() {
        Random random = new Random();
        firstState = random.nextLong();
        r = firstState;
    }

    @Override
    public long generateNext() {
        r = (r << 1) ^ (r^(r>>>1));
        return r % 2;
    }

    @Override
    public Type getType() {
        return Type.BIT;
    }
}
