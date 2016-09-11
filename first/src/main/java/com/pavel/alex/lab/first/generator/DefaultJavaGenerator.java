package com.pavel.alex.lab.first.generator;

import java.util.Random;

/**
 * Created by pyshankov on 11.09.2016.
 */
public class DefaultJavaGenerator implements Generator {

    private Random random;

    public DefaultJavaGenerator() {
        random = new Random();
    }


    @Override
    public long generateNext() {
        return ((random.nextLong() % 256)+256)%256;
    }

    @Override
    public Type getType() {
        return Type.BYTE;
    }
}
