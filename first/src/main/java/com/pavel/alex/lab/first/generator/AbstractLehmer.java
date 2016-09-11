package com.pavel.alex.lab.first.generator;

/**
 * Created by pyshankov on 10.09.2016.
 */
public abstract class AbstractLehmer implements Generator {

    protected long curState;

    protected long a;

    protected long m;

    protected long c;

    public AbstractLehmer() {
        m = (long) Math.pow(2,32);
        c = 119;
        a = (long) Math.pow(2,16)+1;
        curState=0;
    }

    @Override
    public long getFirstState() {
        return c;
    }

    @Override
    public Object getCurrentState() {
        return curState;
    }

}