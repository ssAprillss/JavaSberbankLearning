package com.company.task3;

public class Transport implements Maintenanceble {
    private int type;
    private int number;
    private int mileage;
    private int addInfo;
//Конструктор получает на вход строку и парсит ее.


    public Transport(int type, int number, int mileage, int addInfo) {
        this.type = type;
        this.number = number;
        this.mileage = mileage;
        this.addInfo = addInfo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(int addInfo) {
        this.addInfo = addInfo;
    }

    @Override
    public double getMaintanceCoast() {
        return Constants.FUEL_CONSUMPTION.get(type) * ((double) mileage / 100) * Constants.FUEL_CONSUMPTION.get(type);
    }
}
