package com.pavel.alex.lab.first.generator;

/**
 * Created by pyshankov on 08.09.2016.
 */
public class GeffeGen implements Generator {

    private Generator l1;
    private Generator l2;
    private Generator l3;
    public GeffeGen(Generator l1, Generator l2, Generator l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    @Override
    public long getFirstState() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getCurrentState() {
        throw new UnsupportedOperationException();
    }

    @Override
    public long generateNext() {
        long x = l1.generateNext();
        long y = l2.generateNext();
        long s = l3.generateNext();
        return (s & x) ^ (s ^ 1) & y ;
    }
}
