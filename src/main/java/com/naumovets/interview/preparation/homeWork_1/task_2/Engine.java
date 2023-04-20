package com.naumovets.interview.preparation.homeWork_1.task_2;

public class Engine {
    private int number;
    private String model;
    private int horsePower;

    public Engine(int number, String model, int horsePower) {
        this.number = number;
        this.model = model;
        this.horsePower = horsePower;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
