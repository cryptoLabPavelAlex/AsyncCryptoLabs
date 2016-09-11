package com.pavel.alex.lab.first;


import com.pavel.alex.lab.first.generator.*;

/**
 * Created by pyshankov on 07.09.2016.
 */
public class Main {
    public static void main(String[] args) {



                Generator generator = new BM();
                long t = System.currentTimeMillis();
                for (long i = 0 ; i < 1000; i++)
                    System.out.println(generator.generateNext());
                System.out.println(System.currentTimeMillis()-t);



//            Generator ericWolfram = new EricWolfram();
//
//            for (long i = 0 ; i < 1000; i++)
//            System.out.println(ericWolfram.generateNext());
//
//
//
//            Generator generator = new L20();
//            for (long i = 0 ; i < 1000; i++)
//                System.out.println(generator.generateNext());

//        long t = System.currentTimeMillis();
//        for (long i = 0 ; i < 10000000000l; i++)
//        Long.numberOfLeadingZeros(33434344);
//        System.out.println(System.currentTimeMillis()-t);



//        Generator lehmerLow = new LehmerHigh();
//        for (int i = 0 ; i< 3; i++)
//            System.out.println(Long.toBinaryString(lehmerLow.generateNext()));





//        long l1Px = 0b1000000000000000000000001010011l;
//        long l2Px = 0b10000000000000000000000000001001l;
//        long l3Px = 0b100000000000000000000000010101111l;
//
//
//        Generator p1 = new GeffeGen.LFSR(l1Px,17451593);
//        Generator p2 = new GeffeGen.LFSR(l2Px,22162887);
//        Generator p3 = new GeffeGen.LFSR(l3Px,101019995);
//
//        GeffeGen geffeGen = new GeffeGen(p1,p2,p3);
//
//        for (int i = 0 ; i < 1000 ; i++){
//            System.out.print(geffeGen.generateNext());
//        }
    }
}
