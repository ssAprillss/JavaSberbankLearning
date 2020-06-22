package com.company.task3;

import com.company.task1.GsmCalculation;
import com.company.task1.Transport;

import java.util.ArrayList;

public class Main {
    //Входные данные
public static final String[] GSM_ARRAY = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
    public static void main(String[] args) {
        ArrayList<Transport> park = new ArrayList<>();
        for (String gsmItem: GSM_ARRAY
             ) {
            park.add(new Transport(gsmItem));
        }
        GsmCalculation.printTotalGsmCoast(park);
        GsmCalculation.printMaxGsmType(park);
        GsmCalculation.printMinGsmType(park);
        GsmCalculation.printSortByTypev(park,400,true);

    }
}
