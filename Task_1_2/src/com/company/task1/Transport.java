package com.company.task1;

public class Transport {
    private int type;
    private int number;
    private int mileage;
    private int addInfo;
//Конструктор получает на вход строку и парсит ее.
    public Transport(String transportInfo) {
        this.type = Integer.parseInt(transportInfo.split("_")[0].substring(1));
        this.number = Integer.parseInt(transportInfo.split("_")[1].split("-")[0]);
        this.mileage = Integer.parseInt(transportInfo.split("_")[1].split("-")[1]);
        if(!transportInfo.split("_")[0].equals("C100")) {
            this.addInfo = Integer.parseInt(transportInfo.split("_")[1].split("-")[2]);
        }
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


}
