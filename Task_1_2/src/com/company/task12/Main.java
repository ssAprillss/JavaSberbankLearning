package com.company.task12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        String[] input = {"Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1"};
        Map<String,Integer> result = new HashMap<>();
        for(String a: input){
            String name = a.split(" ")[0];
            Integer points = Integer.parseInt(a.split(" ")[1]);
            if(result.containsKey(name)){
                result.put(name,result.get(name)+points);
            }
            else {
                result.put(name,points);
            }
        }
        System.out.println(result.toString());
        System.out.println("Winers: " + getWiners(result).toString());
    }
    public static ArrayList<String> getWiners(Map<String,Integer> result){
        int maxScore = 0;
        ArrayList<String> output = new ArrayList<>();
        for (Integer a : result.values()){
            if(a > maxScore){
                maxScore = a;
            }
        }
        for(String a : result.keySet()){
            if(result.get(a).equals(maxScore)){
                output.add(a);
            }
        }
        return output;
    }
}
