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

    public static void main(String[] args) throws IOException {

        while (true) {
            login();
        }

    }

    public static Map<String, String> userCred = new HashMap<String, String>(){
        {put("a", "a");
        put("Ivanov1-AC", "qwerty66");
        put("Mamedova-DG", "qwerty66");}};

    public static  Logger logger = new Logger("C:\\Users\\Alex\\Documents\\GSM\\log.txt");
    public static String curentUser;
    public static List<Transport> curentGsm;

    public static void login() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        curentUser = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String pass = scanner.nextLine();
        if (!userCred.containsKey(curentUser)) {
            System.out.println("Введены неверный учетные данные.");
        } else if (userCred.get(curentUser).equals(pass)) {
            System.out.println(curentUser + ", добро пожаловать!");
            logger.log(curentUser,"login");
            while (true) {
                String comand = scanner.next();
                if (comand.equals("start")) {
                    logger.log(curentUser,"start");
                    start();
                }
                else if(comand.equals("sort")){
                    logger.log(curentUser,"sort");
                    sort();
                }
                else if(comand.equals("history")){
                    logger.log(curentUser,"history");
                    history();
                }
                else if(comand.equals("openHistory")){
                    logger.log(curentUser,"openHistory");
                    openHistory();
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

    public static void start() {
        System.out.println("Введите данные о ГСМ в нужном формате:");
        List<String> transports = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Единица: ");
            String transpor = scanner.nextLine();
            if (transpor.equals("end")) {
                System.out.println("Ввод завершен");
                break;
            } else {
                transports.add(transpor);
            }
        }
        curentGsm = getTransportFromStringArr(transports);
        File file = new File("C:\\Users\\Alex\\Documents\\GSM\\" + System.currentTimeMillis());
        File paramFile = new File(file.getAbsolutePath() + "-param");
        try (FileWriter fileWriter = new FileWriter(file); FileWriter paramWriter = new FileWriter(paramFile)) {
            for (String a : transports) {
                fileWriter.append(a + "\n");
            }
            paramWriter.append(GsmCalculation.getTotalGsmCoast(curentGsm));
            paramWriter.append(GsmCalculation.getMaxGsmType(curentGsm));
            paramWriter.append(GsmCalculation.getMinGsmType(curentGsm));
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("Упс, произошла ошибка записи в файл, но Вы держитесь там!");
        }
    }

    public static void sort(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип транспорта:");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.println("Хотите сортировать по пробегу?(да/нет)");
        String sortBy = scanner.nextLine();
        if(sortBy.equals("да")){
            GsmCalculation.printSortByTypev(curentGsm,  type, false);
        }
        else {
            System.out.println("Хотите сортировать по доп. информации?(да/нет)");
            sortBy = scanner.nextLine();
            if(sortBy.equals("да")){
                GsmCalculation.printSortByTypev(curentGsm,  type, true);
            }
            else
            {
                System.out.println("Больше нет доступных сортировок.");
            }
        }
    }

    public static void  history(){
        File file = new File("C:\\Users\\Alex\\Documents\\GSM");
        for(String a : file.list()){
            System.out.println(a);
        }
    }

    public static void openHistory() throws IOException {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Введите имя файла: ");
        String fileName = scanner.nextLine();
        Path path = Paths.get("C:\\Users\\Alex\\Documents\\GSM\\"+fileName);
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

    public static List<Transport> getTransportFromStringArr(List<String> transports) {
        List<Transport> park = new ArrayList<>();
        for (String gsmItem : transports) {
            park.add(new Transport(Integer.parseInt(gsmItem.split("_")[0].substring(1)),
                    Integer.parseInt(gsmItem.split("_")[1].split("-")[0]),
                    Integer.parseInt(gsmItem.split("_")[1].split("-")[1]),
                    (!gsmItem.split("_")[0].equals("C100")) ? Integer.parseInt(gsmItem.split("_")[1].split("-")[2]) : 0));
        }
        return park;
    }
}
