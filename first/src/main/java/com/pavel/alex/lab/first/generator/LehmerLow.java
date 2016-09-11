package com.pavel.alex.lab.first.generator;

/**
 * Created by pyshankov on 10.09.2016.
 */
public class LehmerLow extends AbstractLehmer {
    @Override
    public long generateNext() {
        curState=(a*curState+c) % m;
//        System.out.println(Long.toBinaryString(curState));
//        System.out.println(Long.toBinaryString(curState&0b11111111));
        return curState & 0b11111111;
    }
}
