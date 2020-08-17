package com.company.task14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static final Map<String, String> USER_CRED = new HashMap<String, String>(){
        {put("a", "a");
            put("Ivanov1-AC", "qwerty66");
            put("Mamedova-DG", "qwerty66");}};

    public static  Logger logger = new Logger("C:\\Users\\Alex\\Documents\\GSM\\log.txt");
    public static String curentUser;
    public static List<Transport> curentGsm;

    public static void main(String[] args) throws IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите логин: ");
            curentUser = scanner.nextLine();
            System.out.print("Введите пароль: ");
            String pass = scanner.nextLine();
            if (!USER_CRED.containsKey(curentUser)) {
                System.out.println("Введены неверный учетные данные.");
            } else if (USER_CRED.get(curentUser).equals(pass)) {
                System.out.println(curentUser + ", добро пожаловать!");
                logger.log(curentUser,"login");
                while (true) {
                    String comand = scanner.next();
                    if (comand.equals("start")) {
                        logger.log(curentUser,"start");
                        try {
                            ConsoleInterface.start(curentGsm);
                        }
                        catch (WrongGsmFormatException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else if(comand.equals("sort")){
                        logger.log(curentUser,"sort");
                        ConsoleInterface.sort(curentGsm);
                    }
                    else if(comand.equals("history")){
                        logger.log(curentUser,"history");
                        ConsoleInterface.history();
                    }
                    else if(comand.equals("openHistory")){
                        logger.log(curentUser,"openHistory");
                        ConsoleInterface.openHistory();
                    }
                    else if(comand.equals("logout")){
                        logger.log(curentUser,"logout");
                        break;
                    }
                }
            } else {
                System.out.println("Введены неверный учетные данные.");
            }
        }
    }
}
