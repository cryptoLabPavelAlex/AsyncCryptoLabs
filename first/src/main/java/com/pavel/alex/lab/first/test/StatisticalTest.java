package com.pavel.alex.lab.first.test;

/**
 * Created by pyshankov on 11.09.2016.
 */
public interface StatisticalTest {
    void test();
    double computeStatistic();
    double limitValue(double trustLevel);
}
