package com.pavel.alex.lab.first.test;

import com.pavel.alex.lab.first.generator.Generator;

public class StatisticalUniformityTest extends AbstractStatisticalTest {

    public StatisticalUniformityTest(Generator generator, int sampleLength, double trustLevel,int r) {
        super(generator, sampleLength, trustLevel, 255*(r-1));
    }

    @Override
    public double computeStatistic() {
        return 0;
    }
}
