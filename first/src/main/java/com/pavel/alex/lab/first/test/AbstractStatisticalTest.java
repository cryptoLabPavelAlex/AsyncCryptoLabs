package com.pavel.alex.lab.first.test;

import com.pavel.alex.lab.first.generator.Generator;
import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.*;

public abstract class AbstractStatisticalTest implements  StatisticalTest {

    protected int[] data;

    protected double trustLevel;

    protected int l;

    public AbstractStatisticalTest(Generator generator,int sampleLength,double trustLevel,int l) {
        this.trustLevel = trustLevel;
        this.l = l;
        if(generator.getType().equals(Generator.Type.BYTE)){
            data = new  int[sampleLength];
            for (int i = 0 ; i < sampleLength ; i++)
                data[i] = (int) generator.generateNext();
        }
        if(generator.getType().equals(Generator.Type.BIT)){
            data = new int[1000];
                // TODO: transform bit array to byte array
        }
    }

    @Override
    public void test() {
        System.out.println("statistic: "+computeStatistic());
        System.out.println("limit value: "+limitValue(trustLevel));
    }

    @Override
    public double limitValue(double trustLevel) {
        //two side alternative
        double quantile = new NormalDistribution(0,1).inverseCumulativeProbability(1-trustLevel);
        return Math.sqrt(2*l)*quantile+l;
    }

}
