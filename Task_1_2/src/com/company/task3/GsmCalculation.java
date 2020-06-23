package com.company.task3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GsmCalculation {
    //Типы автомобилей


    //Расчет затрат на ГСМ по типу
    private static double totalCoast(ArrayList<Transport> transports, int type) {
        double totalCoast = 0;
        for (Transport transport : transports) {
            if (transport.getType() == (type)) {
                totalCoast += transport.getMaintanceCoast();
            }
        }
        return totalCoast;
    }

    //Расчет затрат на ГСМ суммарный
    private static double totalCoast(ArrayList<Transport> transports) {
        double totalCoast = 0;
        for (Transport transport : transports) {
            totalCoast += transport.getMaintanceCoast();
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
                if (transportByType.isEmpty()) {         //Проверка совпадения типа, и начальных условий
                    transportByType.add(transport);
                } else {
                    for (int i = 0; i < transportByType.size(); i++) {
                        if (transportByType.get(i).getNumber() == transport.getNumber()) {          //Проверка на совпадение номера
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
            System.out.println("Тип автомобиля - '" + Constants.CAR_TYPE.get(t.getType()) + "', номер автомобиля - " + t.getNumber() + ", пробег автомобиля - " + t.getMileage() + ", доп. инмормация - " + t.getAddInfo());
        }
    }
}



