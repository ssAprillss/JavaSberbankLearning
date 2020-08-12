package com.company.task14;



import java.util.ArrayList;
import java.util.List;

public class GsmCalculation {
    //Типы автомобилей


    //Расчет затрат на ГСМ по типу
    private static double totalCoast(List<Transport> transports, int type) {
        double totalCoast = 0;
        for (Transport transport : transports) {
            if (transport.getType() == (type)) {
                totalCoast += transport.getMaintanceCoast();
            }
        }
        return totalCoast;
    }

    //Расчет затрат на ГСМ суммарный
    private static double totalCoast(List<Transport> transports) {
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
    public static String getTotalGsmCoast(List<Transport> transports) {
        return ("Итоговая стоимость затрат на ГСМ = " + totalCoast(transports) +
        "\nИтоговая стоимость затрат на ГСМ легковых авто = " + totalCoast(transports, 100) +
        "\nИтоговая стоимость затрат на ГСМ грузовых авто = " + totalCoast(transports, 200) +
        "\nИтоговая стоимость затрат на ГСМ пассажирского транспорта = " + totalCoast(transports, 300)+
        "\nИтоговая стоимость затрат на ГСМ тяжелой техники = " + totalCoast(transports, 400));
    }

    //Вывод типа, имеющего максимальные затраты на ГСМ
    public static String getMaxGsmType(List<Transport> transports) {
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
        return ("\n\nМаксимальная стоимость расходов на ГСМ у "+type+", она равна "+ maxCoast);
    }

    //Вывод типа, имеющего минимальные затраты на ГСМ
    public static String getMinGsmType(List<Transport> transports) {
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
        return ("\n\nМаксимальная стоимость расходов на ГСМ у "+type+", она равна "+ minCoast);
    }

    //Вывод в разрезе каждого типа, с сортировко по пробегу либо по доп информации
    public static void printSortByTypev(List<Transport> transports, int type, boolean byAddInfo) {
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



