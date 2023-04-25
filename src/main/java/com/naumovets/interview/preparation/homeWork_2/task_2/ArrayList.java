package com.naumovets.interview.preparation.homeWork_2.task_2;

import com.naumovets.interview.preparation.homeWork_2.util.List;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int capacity;
    private int size;

    public ArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = new Object[0];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }

        capacity = elementData.length;
    }


    @Override
    public boolean add(T element) {
        if (size == capacity)
            grow();

        elementData[size] = element;
        size++;

        return true;
    }

    @Override
    public void add(int index, T element) {
        checkRangeForAdd(index);

        if (size == elementData.length)
            elementData = grow();

        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size += 1;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);

        return (T) elementData[index];
    }

    @Override
    public T set(int index, T element) {
        Objects.checkIndex(index, size);
        T oldValue = (T) elementData[index];
        elementData[index] = element;

        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T oldValue = (T) elementData[index];
        fastRemove(index);

        return oldValue;
    }

    private void fastRemove(int index) {
        size -= 1;

        if (size > index)
            System.arraycopy(elementData, index + 1, elementData, index, size - index);

        elementData[size] = null;
    }

    @Override
    public boolean remove(Object o) {
        int index = 0;

        found:
        {
            if (o == null) {
                for (; index < size; index++)
                    if (elementData[index] == null)
                        break found;
            } else {
                for (; index < size; index++)
                    if (o.equals(elementData[index]))
                        break found;
            }
            return false;
        }

        fastRemove(index);

        return true;
    }

    @Override
    public void clear() {
        for (int to = size, i = 0; i < to; i++)
            elementData[i] = null;

        size = 0;
    }

    private Object[] grow() {
        return elementData = Arrays.copyOf(elementData, newCapacity());
    }

    private int newCapacity() {
        return capacity == 0 ? DEFAULT_CAPACITY : capacity * 2;
    }

    private void checkRangeForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(indexOutOfBounds(index));
        }
    }

    private String indexOutOfBounds(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        build:
        {
            for (int i = 0; i < size; i++) {
                sb.append(elementData[i]);

                if (i == (size - 1)) {
                    sb.append(']');
                    break build;
                }

                sb.append(',').append(' ');
            }
        }

        return sb.toString();
    }
}
