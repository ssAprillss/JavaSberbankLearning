package com.company.task10;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {


        List<String> a = new ArrayList<>();
        a.add("AAA");
        a.add("AAA");
        a.add("AVA");
        a.add("AVA");
        System.out.println(a.toString());
        List<String> b = deleteDuplicate(a);
        System.out.println(b.toString());//65 - 122


    }
    public static <T extends Collection<K>,K> T  deleteDuplicate(T input) throws IllegalAccessException, InstantiationException {
        Class c = input.getClass();
        T output = (T) c.newInstance();
        output.add((K) input.toArray()[0]);
        output.clear();
        for(K a: input){
            if (!output.contains(a)){
                output.add(a);
            }
        }
        return output;
    }
}
