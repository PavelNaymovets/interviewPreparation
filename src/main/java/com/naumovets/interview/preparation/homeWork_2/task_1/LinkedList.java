package com.naumovets.interview.preparation.homeWork_2.task_1;

import com.naumovets.interview.preparation.homeWork_2.util.List;

import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<T> implements List<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    private static class Node<T> {
        T element;
        Node<T> prev;
        Node<T> next;

        public Node(Node<T> prev, T element, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public LinkedList() {
    }

    @Override
    public boolean add(T element) {
        addLast(element);

        return true;
    }

    @Override
    public void add(int index, T element) {
        Objects.checkIndex(index, size);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);

        return node(index).element;
    }

    @Override
    public T set(int index, T element) {
        Objects.checkIndex(index, size);
        Node<T> x = node(index);
        T oldVal = x.element;
        x.element = element;

        return oldVal;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);

        return unlink(node(index));
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.element == null) {
                    unlink(x);

                    return true;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (o.equals(x.element)) {
                    unlink(x);

                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;

            x.element = null;
            x.next = null;
            x.prev = null;

            x = next;
        }

        first = last = null;
        size = 0;
    }

    private void linkFirst(T e) {
        final Node<T> firstElement = first;
        final Node<T> newNode = new Node<>(null, e, firstElement);
        first = newNode;

        if (firstElement == null)
            last = newNode;
        else
            firstElement.prev = newNode;

        size++;
    }

    void linkLast(T e) {
        final Node<T> lastElement = last;
        final Node<T> newNode = new Node<>(lastElement, e, null);
        last = newNode;

        if (lastElement == null)
            first = newNode;
        else
            lastElement.next = newNode;

        size++;
    }

    void linkBefore(T e, Node<T> element) {
        final Node<T> prevElement = element.prev;
        final Node<T> newNode = new Node<>(prevElement, e, element);
        element.prev = newNode;

        if (prevElement == null)
            first = newNode;
        else
            prevElement.next = newNode;

        size++;
    }

    private T unlinkFirst(Node<T> f) {
        final T element = f.element;
        final Node<T> next = f.next;
        f.element = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;

        return element;
    }

    private T unlinkLast(Node<T> l) {
        final T element = l.element;
        final Node<T> prev = l.prev;
        l.element = null;
        l.prev = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;

        return element;
    }

    T unlink(Node<T> x) {
        final T element = x.element;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.element = null;
        size--;

        return element;
    }

    public T getFirst() {
        Node<T> firstElement = first;

        if (firstElement == null)
            throw new NoSuchElementException();

        return firstElement.element;
    }

    public T getLast() {
        Node<T> lastElement = last;

        if (lastElement == null)
            throw new NoSuchElementException();

        return lastElement.element;
    }

    public T removeFirst() {
        Node<T> firstElement = first;

        if (firstElement == null)
            throw new NoSuchElementException();

        return unlinkFirst(firstElement);
    }

    public T removeLast() {
        Node<T> lastElement = last;

        if (lastElement == null)
            throw new NoSuchElementException();

        return unlinkLast(lastElement);
    }

    public void addFirst(T element) {
        linkFirst(element);
    }

    public void addLast(T element) {
        linkLast(element);
    }

    private Node<T> node(int index) {
        Node<T> x = first;

        for (int i = 0; i < index; i++)
            x = x.next;

        return x;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        build:
        {
            for (Node<T> x = first; x != null; x = x.next) {
                sb.append(x.element);

                if (x.next == null) {
                    sb.append(']');
                    break build;
                }

                sb.append(',').append(' ');
            }
        }

        return sb.toString();
    }
}
