package com.pavel.alex.lab.first.generator;

/**
 * Created by pyshankov on 07.09.2016.
 */
public interface Generator {

    long getFirstState();

    Object getCurrentState();

    long generateNext();

}
