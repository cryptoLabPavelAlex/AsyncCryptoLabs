package com.pavel.alex.lab.first.generator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Librarian implements Generator {

    private final String FILENAME = "kant.txt";
    private int index = 0;
    private byte[] array;

    public Librarian() {
        try {
            System.setIn(new FileInputStream(FILENAME));
            Scanner sc = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            while (sc.hasNext()) {
                sb.append(sc.next());
            }
            array = sb.toString().getBytes();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public long generateNext() {
        if (index>array.length){
            index=0;
        }
        return array[index];
    }

    @Override
    public Type getType() {
        return Type.BYTE;
    }
}
