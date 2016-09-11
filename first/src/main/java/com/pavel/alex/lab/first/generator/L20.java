package com.pavel.alex.lab.first.generator;

import java.util.Random;

/**
 * Created by pyshankov on 10.09.2016.
 */
public class L20 implements Generator {

    public Generator lfsr;

    public L20() {
        Random random = new Random();
        long l1Px = 0b00010100010000000001l;
        long randomInitState = random.nextLong() % ((long) Math.pow(2,20)-1);
        lfsr = new Generator.LFSR(l1Px,randomInitState);
    }

    @Override
    public long generateNext() {
        return lfsr.generateNext();
    }

    @Override
    public Type getType() {
        return lfsr.getType();
    }
}
