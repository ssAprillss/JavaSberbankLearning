package com.company.task9;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        String text = "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, 'and what is the use of a book,' thought Alice 'without pictures or conversation?'";
        char[] textArray = text.toLowerCase().toCharArray();
        HashMap<Character,Integer> output = new HashMap<>();
        for(char a: textArray){
            if((int)a >= 97 && (int)a <=122){
                if(output.containsKey(a)){
                    output.put(a,output.get(a)+1);
                }
                else{
                    output.put(a,1);
                }
            }
        }
        System.out.println(output.toString());//65 - 122
    }
}