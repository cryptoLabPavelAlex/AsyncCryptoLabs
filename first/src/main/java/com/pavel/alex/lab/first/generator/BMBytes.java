package com.pavel.alex.lab.first.generator;


import java.math.BigInteger;

public class BMBytes extends BM {

    public BMBytes() {
        super();
    }

    @Override
    public long generateNext() {
        T = a.modPow(T,p);
        BigInteger k1 = T.multiply(BigInteger.valueOf(256)).divide(p.subtract(BigInteger.valueOf(1)));
        BigInteger k2 = (T.multiply(BigInteger.valueOf(256)).divide(p.subtract(BigInteger.valueOf(1)))).subtract(BigInteger.valueOf(1));

        return Long.valueOf(String.valueOf(k1));  //How to find k
    }

    @Override
    public Type getType() {
        return Type.BYTE;
    }

}
