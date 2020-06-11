package com.company.task1;

import java.util.*;

public class GsmCalculation {
    //Типы автомобилей
    private static final HashMap<Integer, String> CAR_TYPE = new HashMap<Integer, String>() {{
        put(100, "Легковой автомобиль");
        put(200, "Грузовой автомобиль");
        put(300, "Пассажирский транспорт");
        put(400, "Тяжелая техника");
    }};
    //Хранение цен на бензин
    private static final HashMap<Integer, Double> FUEL_PRICE = new HashMap<Integer, Double>() {{
        put(100, 46.10d);
        put(200, 48.90d);
        put(300, 47.50d);
        put(400, 48.90d);
    }};
    //Хранение расхода топлива на 100
    private static final HashMap<Integer, Double> FUEL_CONSUMPTION = new HashMap<Integer, Double>() {{
        put(100, 12.5d);
        put(200, 12d);
        put(300, 11.5d);
        put(400, 20d);
    }};

    //Расчет затрат на ГСМ по типу
    private static double totalCoast(ArrayList<Transport> transports, int type) {
        double totalCoast = 0;
        for (Transport transport : transports) {
            if (transport.getType() == (type)) {
                totalCoast += FUEL_PRICE.get(type) * ((double) transport.getMileage() / 100) * FUEL_CONSUMPTION.get(type);
            }
        }
        return totalCoast;
    }

    //Расчет затрат на ГСМ суммарный
    private static double totalCoast(ArrayList<Transport> transports) {
        double totalCoast = 0;
        for (Transport transport : transports) {
            totalCoast += FUEL_PRICE.get(transport.getType()) * ((double) transport.getMileage() / 100) * FUEL_CONSUMPTION.get(transport.getType());
        }
        return totalCoast;
    }

    //Пузырьковая сортировка по пробегу
    public static void sortMilage(List<Transport> transports) {
        // i - номер прохода
        for (int i = 0; i < transports.size() - 1; i++) {
            // внутренний цикл прохода
            for (int j = transports.size() - 1; j > i; j--) {
                if (transports.get(j - 1).getMileage() > transports.get(j).getMileage()) {
                    int tmp = transports.get(j - 1).getMileage();
                    transports.get(j - 1).setMileage(transports.get(j).getMileage());
                    transports.get(j).setMileage(tmp);
                }
            }
        }
    }

    //Пузырьковая сортировка по доп. информации
    public static void sortAddInfo(List<Transport> transports) {
        // i - номер прохода
        for (int i = 0; i < transports.size() - 1; i++) {
            // внутренний цикл прохода
            for (int j = transports.size() - 1; j > i; j--) {
                if (transports.get(j - 1).getAddInfo() > transports.get(j).getAddInfo()) {
                    int tmp = transports.get(j - 1).getAddInfo();
                    transports.get(j - 1).setAddInfo(transports.get(j).getAddInfo());
                    transports.get(j).setAddInfo(tmp);
                }
            }
        }
    }

    //Вывод затрат на ГСМ - суммарно, в разрезе по типу
    public static void printTotalGsmCoast(ArrayList<Transport> transports) {
        System.out.printf("%s %.2f", "Итоговая стоимость затрат на ГСМ = ", totalCoast(transports));
        System.out.printf("\n%s %.2f", "Итоговая стоимость затрат на ГСМ легковых авто = ", totalCoast(transports, 100));
        System.out.printf("\n%s %.2f", "Итоговая стоимость затрат на ГСМ грузовых авто = ", totalCoast(transports, 200));
        System.out.printf("\n%s %.2f", "Итоговая стоимость затрат на ГСМ пассажирского транспорта = ", totalCoast(transports, 300));
        System.out.printf("\n%s %.2f", "Итоговая стоимость затрат на ГСМ тяжелой техники = ", totalCoast(transports, 400));
    }

    //Вывод типа, имеющего максимальные затраты на ГСМ
    public static void printMaxGsmType(ArrayList<Transport> transports) {
        double maxCoast = totalCoast(transports, 100);
        ;
        String type = "Легковое авто";
        if (totalCoast(transports, 200) > maxCoast) {
            maxCoast = totalCoast(transports, 200);
            type = "Грузовое авто";
        }
        if (totalCoast(transports, 300) > maxCoast) {
            maxCoast = totalCoast(transports, 300);
            type = "Пассажирский транспорт";
        }
        if (totalCoast(transports, 400) > maxCoast) {
            maxCoast = totalCoast(transports, 400);
            type = "Тяжелая техника";
        }
        System.out.printf("\n\nМаксимальная стоимость расходов на ГСМ у '%s', она равна %.2f", type, maxCoast);
    }

    //Вывод типа, имеющего минимальные затраты на ГСМ
    public static void printMinGsmType(ArrayList<Transport> transports) {
        double minCoast = totalCoast(transports, 100);
        String type = "Легковое авто";
        if (totalCoast(transports, 200) < minCoast) {
            minCoast = totalCoast(transports, 200);
            type = "Грузовое авто";
        }
        if (totalCoast(transports, 300) < minCoast) {
            minCoast = totalCoast(transports, 300);
            type = "Пассажирский транспорт";
        }
        if (totalCoast(transports, 400) < minCoast) {
            minCoast = totalCoast(transports, 400);
            type = "Тяжелая техника";
        }
        System.out.printf("\n\nМинимальная стоимость расходов на ГСМ у '%s', она равна %.2f", type, minCoast);
    }

    //Вывод в разрезе каждого типа, с сортировко по пробегу либо по доп информации
    public static void printSortByTypev(ArrayList<Transport> transports, int type, boolean byAddInfo) {
        System.out.printf("\n\nСортировка по %s\n", (byAddInfo ? "доп. информации:" : "пробегу:"));
        List<Transport> transportByType = new ArrayList<>();
        for (Transport transport : transports) {
            if (transport.getType() == type) {
                if (transportByType.isEmpty()) {
                    transportByType.add(transport);
                } else {
                    for (int i = 0; i < transportByType.size(); i++) {
                        if (transportByType.get(i).getNumber() == transport.getNumber()) {
                            transportByType.get(i).setMileage(transportByType.get(i).getMileage() + transport.getMileage());
                            transportByType.get(i).setAddInfo(transportByType.get(i).getAddInfo() + transport.getAddInfo());
                            break;
                        } else {
                            transportByType.add(transport);
                            break;
                        }
                    }
                }
            }
        }
        if (byAddInfo) {
            sortAddInfo(transportByType);
        } else {
            sortMilage(transportByType);
        }
        for (Transport t : transportByType) {
            System.out.println("Тип автомобиля - '" + CAR_TYPE.get(t.getType()) + "', номер автомобиля - " + t.getNumber() + ", пробег автомобиля - " + t.getMileage() + ", доп. инмормация - " + t.getAddInfo());
        }
    }
}



