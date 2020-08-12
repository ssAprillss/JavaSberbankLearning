package com.company.task13;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
    while (true){
        String comand = scanner.next();
        if(comand.equals("write")){
            write();
        }
        else if(comand.equals("read")){
            read();
        }
        else if(comand.equals("open")){
            open();
        }
    }

    }

    public static void write () throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку символов: " );
        String inputString = scanner.nextLine();
        System.out.print("Введите количество символов: " );
        int count =  Integer.parseInt(scanner.nextLine());
        System.out.print("Введите символы через пробел: " );
        String simbol = scanner.nextLine();
        Set<Character> uniqSimbols = new HashSet<>(); //String потому что можно ввести строку а не символ
        for(char a : simbol.toCharArray()){
            if(a != ' ')
            uniqSimbols.add(a);
        }

        File file = new File("C:\\Users\\Alex\\Documents\\javaIO\\"+System.currentTimeMillis());
        FileWriter fileWriter = new FileWriter(file);
        for(char a : uniqSimbols){
           fileWriter.append("Процент совпадений по символу " + a + ": " + getPercentage(a,inputString) + "\n");
           fileWriter.append("Cовпадений по символу " + a + ": " + getCount(a,inputString)+ "\n");
        }
        fileWriter.close();
    }

    public static int getCount(char a, String string){
        int count = 0;
        for(char c : string.toCharArray()){
            if(c == a){
                count++;
            }
        }
        return count;
    }

    public static float getPercentage(char a, String string){
        return (float) getCount(a,string)/ (float)string.length();
    }

    public static void  read(){
        File file = new File("C:\\Users\\Alex\\Documents\\javaIO");
        for(String a : file.list()){
            System.out.println(a);
        }
    }

    public static void open() throws IOException {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Введите имя файла: ");
        String number = scanner.nextLine();
        Path path = Paths.get("C:\\Users\\Alex\\Documents\\javaIO\\"+number);
        if(Files.exists(path)) {
            List<String> content = Files.readAllLines(path);
            for (String a : content) {
                System.out.println(a);
            }
        }
        else {
            System.out.println("Файл не найден");
        }
    }
}
