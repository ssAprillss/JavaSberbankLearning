package com.company.task11;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {


        Map<Integer,String> a = new HashMap<>();
        a.put(1,"AAA");
        a.put(2,"AAA");
        a.put(3,"AVA");
        a.put(4,"AVA");
        System.out.println(a.toString());

        System.out.println(swap(a).toString());//65 - 122


    }

    public static <T extends Collection<K>, K, V> Map<V, T> swap(Map<K, V> input) throws IllegalAccessException, InstantiationException {
        Map<V, T> output = new HashMap<>();
        for (K k : input.keySet()) {
            if (output.containsKey(input.get(k))) {
                T new_val = output.get(input.get(k));
                new_val.add(k);
                output.put(input.get(k), new_val);
            } else {
                T new_val = (T) new ArrayList<K>();
                new_val.add(k);
                output.put(input.get(k), new_val);
            }
        }
        return output;
    }

}
