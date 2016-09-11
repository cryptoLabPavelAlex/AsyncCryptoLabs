package com.pavel.alex.lab.first.test;

import com.pavel.alex.lab.first.generator.Generator;
import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.Map;

/**
 * Created by pyshankov on 11.09.2016.
 */
public class EquitabilityStatisticalTest extends AbstractStatisticalTest {


    public EquitabilityStatisticalTest(Generator generator,int sampleLength,double trustLevel) {
        super(generator,sampleLength,trustLevel);
    }

    @Override
    public double computeStatistic() {
        Map<Integer,Integer> map = getByteFrequency(data);
        int m = data.length;
        double n = m/256;
        double result = 0;
        for(int j = 0 ; j < 256; j++ ){
            result+= Math.pow((map.get(j)-n),2)/n;
        }
        return result;
    }

    @Override
    public double limitValue(double trustLevel) {
        //two side alternative
        int l = 255;
        double quantile = new NormalDistribution(0,1).inverseCumulativeProbability(1-trustLevel/2);
        return Math.sqrt(2*l)*quantile+l;
    }
}
