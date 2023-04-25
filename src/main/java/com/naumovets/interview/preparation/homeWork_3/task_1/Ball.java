package com.naumovets.interview.preparation.homeWork_3.task_1;

public class Ball {
    public synchronized void ping() {
        System.out.println("Thread " + Thread.currentThread().getName() + ": " + "Ping");
        notifyAll();

        try {
            wait(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void pong() {
        System.out.println("Thread " + Thread.currentThread().getName() + ": " + "Pong");
        notifyAll();

        try {
            wait(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
