package com.naumovets.interview.preparation.homeWork_1;

import com.naumovets.interview.preparation.homeWork_1.task_1.Person;
import com.naumovets.interview.preparation.homeWork_1.task_2.Car;
import com.naumovets.interview.preparation.homeWork_1.task_2.Engine;
import com.naumovets.interview.preparation.homeWork_1.task_2.LightWeightCar;
import com.naumovets.interview.preparation.homeWork_1.task_2.Lorry;
import com.naumovets.interview.preparation.homeWork_1.task_3.Circle;
import com.naumovets.interview.preparation.homeWork_1.task_3.Figure;
import com.naumovets.interview.preparation.homeWork_1.task_3.Square;
import com.naumovets.interview.preparation.homeWork_1.task_3.Triangle;

import static com.naumovets.interview.preparation.homeWork_1.task_1.Person.builder;

public class HomeWorkApplication {
    public static void main(String[] args) {
        //=====================================================
        // Задание 1. Pattern Builder
        //=====================================================

        /*
         Задание реализовано в пекедже task_1.
        */

        Person person = builder()
                .setFirstName("Alexander")
                .setMiddleName("Ivanovich")
                .setLastName("Ivanov")
                .setAge(10)
                .setGender("Mail")
                .setCountry("Australia")
                .setAddress("New Street")
                .setPhone("901489840234")
                .build();

        System.out.println(person);

        //=====================================================
        // Задание 2.
        //=====================================================

        /*
         Задание реализовано в пекедже task_2.

         Комментарии:
         * Любая машина может двигать и останавливаться. Они все делают это одинаково в независимости от характеристик.
         Удаляю интерфейс Moveable и Stopable. Переношу их методы в абстрактный класс Car;
         * В абстрактном классе убираю убстрактные методы и делаю дефолтные реализации для всех методов. Так как примерно
         машины делают одно и тоже в этих действиях. Если появится особенность в будущем, то этот метод можно
         переопределить в наследнике. Пример класс LightWeightCar, метод .start().
        */

        Engine lightWeightCarEngine = new Engine(123120, "light weight motor", 100);
        Engine lorryEngine = new Engine(121429, "lorry motor", 400);

        Car lightWeightCar = new LightWeightCar(lightWeightCarEngine, "white", "lightWeightCar");
        Car lorry = new Lorry(lorryEngine, "black", "lorry");

        lightWeightCar.start();
        lorry.start();

        //=====================================================
        // Задание 3.
        //=====================================================

        /*
         Задание реализовано в пекедже task_3.

         Комментарии:
         * Книга Effective java не рекомендует применять наследование при написании программ. Применил, так как
         того требовало задание.
        */

        Figure circle = new Circle();
        Figure square = new Square();
        Figure triangle = new Triangle();

        circle.draw();
        square.draw();
        triangle.draw();
    }
}
