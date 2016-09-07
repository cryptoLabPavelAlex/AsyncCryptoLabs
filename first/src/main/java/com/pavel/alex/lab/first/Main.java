package com.pavel.alex.lab.first;

import com.pavel.alex.lab.first.generator.GeffeGen;
import com.pavel.alex.lab.first.generator.Generator;

/**
 * Created by pyshankov on 07.09.2016.
 */
public class Main {
    public static void main(String[] args) {

        long l1Px = 0b1000000000000000000000001010011l;
        long l2Px = 0b10000000000000000000000000001001l;
        long l3Px = 0b100000000000000000000000010101111l;


        Generator p1 = new GeffeGen.LFSR(l1Px,17451593);
        Generator p2 = new GeffeGen.LFSR(l2Px,22162887);
        Generator p3 = new GeffeGen.LFSR(l3Px,101019995);

        GeffeGen geffeGen = new GeffeGen(p1,p2,p3);

        for (int i = 0 ; i < 1000 ; i++){
            System.out.print(geffeGen.generateNext());
        }
    }
}
