package com.naumovets.interview.preparation.homeWork_1.task_2;

public class LightWeightCar extends Car {
    public LightWeightCar(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    public void start() {
        System.out.println("Light weight car starting");
    }
}
