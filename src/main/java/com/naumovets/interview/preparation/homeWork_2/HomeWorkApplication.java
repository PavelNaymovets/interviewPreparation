package com.naumovets.interview.preparation.homeWork_2;

import com.naumovets.interview.preparation.homeWork_2.task_1.LinkedList;
import com.naumovets.interview.preparation.homeWork_2.util.List;
import com.naumovets.interview.preparation.homeWork_2.task_2.ArrayList;

public class HomeWorkApplication {
    public static void main(String[] args) {
        //=====================================================
        // Задание 1. LinkedList
        //=====================================================

        /*
         Задание реализовано в пекедже task_1.
        */

        List<String> list = new LinkedList<>();

        list.add("Элемент 1");
        list.add("Элемент 2");
        System.out.println(list);

        list.add(1, "Новый элемент");
        System.out.println(list);

        String getElementList = list.get(1);
        System.out.println(getElementList);

        list.set(1, "Измененный элемент");
        System.out.println(list);

        int sizeList = list.size();
        System.out.println(sizeList);

        list.remove(1);
        System.out.println(list);

        list.clear();
        System.out.println(list);

        //=====================================================
        // Задание 2. ArrayList
        //=====================================================

        /*
         Задание реализовано в пекедже task_2.
        */

        List<String> arr = new ArrayList<>();

        arr.add("Элемент 1");
        arr.add("Элемент 2");
        System.out.println(arr);

        arr.add(1, "Новый элемент");
        System.out.println(arr);

        String getElementArr = arr.get(1);
        System.out.println(getElementArr);

        arr.set(1, "Измененный элемент");
        System.out.println(arr);

        int sizeArr = arr.size();
        System.out.println(sizeArr);

        arr.remove(1);
        System.out.println(arr);

        arr.clear();
        System.out.println(arr);
    }
}
