package com.pavel.alex.lab.first;


import com.pavel.alex.lab.first.generator.DefaultJavaGenerator;
import com.pavel.alex.lab.first.generator.Generator;
import com.pavel.alex.lab.first.generator.LehmerHigh;
import com.pavel.alex.lab.first.generator.LehmerLow;
import com.pavel.alex.lab.first.test.StatisticalSignIndependencyTest;
import com.pavel.alex.lab.first.test.StatisticalTest;

/**
 * Created by pyshankov on 07.09.2016.
 */
public class Main {
    public static void main(String[] args) {


        Generator generator = new LehmerLow();
        StatisticalTest test = new StatisticalSignIndependencyTest(generator,1000,0.05);
        test.test();

        generator = new LehmerHigh();
        test = new StatisticalSignIndependencyTest(generator,10000,0.05);
        test.test();

        generator = new DefaultJavaGenerator();
        test = new StatisticalSignIndependencyTest(generator,10000,0.05);
        test.test();

    }

}
