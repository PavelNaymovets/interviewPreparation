package com.naumovets.interview.preparation.homeWork_1.task_2;

public abstract class Car {
    public Engine engine;
    private String color;
    private String name;

    public Car(Engine engine, String color, String name) {
        this.engine = engine;
        this.color = color;
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void start() {
        System.out.println("Car starting");
    }

    public void open() {
        System.out.println("Car is opened");
    }

    public void move() {
        System.out.println("Car is moving");
    }

    public void stop() {
        System.out.println("Car was stopped");
    }
}
