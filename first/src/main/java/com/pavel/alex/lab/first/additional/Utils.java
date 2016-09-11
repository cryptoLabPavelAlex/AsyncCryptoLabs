package com.pavel.alex.lab.first.additional;

import java.util.*;

/**
 * Created by pyshankov on 11.09.2016.
 */
public class Utils {

    public static Map<Integer,Integer> getByteFrequency(int[] bytes){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < 256; i++) map.put(i,0);
        for(int i = 0 ; i < bytes.length; i++)
            map.put(bytes[i],map.get(bytes[i])+1);
        return  map;
    }

    public static List<Map.Entry<Integer,Integer>> getPairs(int[] bytes){
        int n = bytes.length/2;
        List<Map.Entry<Integer,Integer>> pairs = new ArrayList<>(bytes.length);
        for(int i = 1 ; i <= n; i++){
            pairs.add(new AbstractMap.SimpleImmutableEntry<>(bytes[2*i-2],bytes[2*i-1]));
        }
        return pairs;
    }

    public static Integer getPairCountFromMap(int firstValue, int secondValue, Map<Map.Entry<Integer,Integer>,Integer> source){
        Map.Entry<Integer,Integer> pair = new AbstractMap.SimpleImmutableEntry<>(firstValue,secondValue);
        return source.get(pair);
    }

    public static Map<Map.Entry<Integer,Integer>,Integer> getPairsCount(List<Map.Entry<Integer,Integer>> list){
        Map<Map.Entry<Integer,Integer>,Integer> map = new HashMap<>();
        for (Map.Entry<Integer,Integer> pair : list)
            map.put(pair,0);
        for (Map.Entry<Integer,Integer> pair : list)
            map.put(pair,(map.get(pair)+1));
        return map;
    }

    public static Map<Integer,Integer> getCountElementFirstPlace(List<Map.Entry<Integer,Integer>> list){
        Map<Integer,Integer> map = new HashMap<>();
        for(Map.Entry<Integer,Integer> pair : list){
            if(map.containsKey(pair.getKey())){
                map.put(pair.getKey(),map.get(pair.getKey())+1);
            }else {
                map.put(pair.getKey(),1);
            }
        }
        return map;
    }

    public static Map<Integer,Integer> getCountElementSecondPlace(List<Map.Entry<Integer,Integer>> list){
        Map<Integer,Integer> map = new HashMap<>();
        for(Map.Entry<Integer,Integer> pair : list){
            if(map.containsKey(pair.getValue())){
                map.put(pair.getValue(),map.get(pair.getValue())+1);
            }else {
                map.put(pair.getValue(),1);
            }
        }
        return map;
    }

}
