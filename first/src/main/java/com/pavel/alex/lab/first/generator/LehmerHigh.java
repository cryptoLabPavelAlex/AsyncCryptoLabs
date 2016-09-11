package com.pavel.alex.lab.first.generator;

/**
 * Created by pyshankov on 10.09.2016.
 */
public class LehmerHigh extends AbstractLehmer {
    @Override
    public long generateNext() {
        curState=(a*curState+c) % m;
        int n = Long.numberOfLeadingZeros(curState) +1;
        int length = 64 - n;
//        System.out.println(Long.toBinaryString(curState));
//        System.out.println(Long.toBinaryString(curState >>> (length - 7) ));
        return  (length<8) ? curState : curState >>> (length - 7);

    }
}
