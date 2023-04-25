package com.naumovets.interview.preparation.homeWork_2.util;

public interface List<T> {
    boolean add(T element);
    void add(int index, T element);
    T get(int index);
    T set(int index, T element);
    int size();
    T remove(int index);
    boolean remove(Object o);
    void clear();
}
