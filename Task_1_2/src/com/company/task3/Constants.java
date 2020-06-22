package com.company.task3;

import java.util.HashMap;

public class Constants {
    public static final HashMap<Integer, String> CAR_TYPE = new HashMap<Integer, String>() {{
        put(100, "Легковой автомобиль");
        put(200, "Грузовой автомобиль");
        put(300, "Пассажирский транспорт");
        put(400, "Тяжелая техника");
    }};
    //Хранение цен на бензин
    public static final HashMap<Integer, Double> FUEL_PRICE = new HashMap<Integer, Double>() {{
        put(100, 46.10d);
        put(200, 48.90d);
        put(300, 47.50d);
        put(400, 48.90d);
    }};
    //Хранение расхода топлива на 100
    public static final HashMap<Integer, Double> FUEL_CONSUMPTION = new HashMap<Integer, Double>() {{
        put(100, 12.5d);
        put(200, 12d);
        put(300, 11.5d);
        put(400, 20d);
    }};
}
