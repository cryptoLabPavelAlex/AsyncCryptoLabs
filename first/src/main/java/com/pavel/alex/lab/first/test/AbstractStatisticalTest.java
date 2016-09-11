package com.pavel.alex.lab.first.test;

import com.pavel.alex.lab.first.generator.Generator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pyshankov on 11.09.2016.
 */
public abstract class AbstractStatisticalTest implements  StatisticalTest {

    protected int[] data;

    protected double trustLevel;

    public AbstractStatisticalTest(Generator generator,int sampleLength,double trustLevel) {
        this.trustLevel=trustLevel;
        if(generator.getType().equals(Generator.Type.BYTE)){
            data = new  int[sampleLength];
            for (int i = 0 ; i < sampleLength ; i++)
                data[i] = (int) generator.generateNext();
        }
        if(generator.getType().equals(Generator.Type.BIT)){
            data = new int[1000];
                // transform bit array to byte array
        }
    }

    @Override
    public void test() {
        System.out.println("statistic: "+computeStatistic());
        System.out.println("limit value: "+limitValue(trustLevel));
    }

    protected static Map<Integer,Integer> getByteFrequency(int[] bytes){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < 256; i++) map.put(i,0);
        for(int i = 0 ; i < bytes.length; i++)
            map.put(bytes[i],map.get(bytes[i])+1);
        return  map;
    }

}
