package com.pavel.alex.lab.first.generator;

import java.util.Random;

/**
 * Created by pyshankov on 11.09.2016.
 */
public class EricWolfram implements Generator {

    private long r;

    private long firstState;

    public EricWolfram() {
        Random random = new Random();
        firstState = random.nextLong();
        r = firstState;
    }

    @Override
    public long getFirstState() {
        return 0;
    }

    @Override
    public Object getCurrentState() {
        return null;
    }

    @Override
    public long generateNext() {
        r = (r << 1) ^ (r^(r>>>1));
        return r % 2;
    }
}
