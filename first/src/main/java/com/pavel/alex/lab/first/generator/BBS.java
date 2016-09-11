package com.pavel.alex.lab.first.generator;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by pyshankov on 11.09.2016.
 */
public class BBS implements Generator {

    private BigInteger p;

    private BigInteger q;

    private BigInteger n;

    private BigInteger r;

    public BBS() {
        Random random = new Random();
        String pHex = "CD5BBB96D30086EC484EBA3D7F9CAEB07";
        String qHex = "425D2B9BFDB25B9CF6C416CC6E37B59C1F";
        p = new BigInteger(pHex, 16);
        q = new BigInteger(qHex, 16);
        n = p.multiply(q);
        r = new BigInteger(String.valueOf(random.nextLong()));
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
        r = r.shiftLeft(1).mod(n);
        return r.mod(BigInteger.valueOf(2)).longValue();
    }
}
