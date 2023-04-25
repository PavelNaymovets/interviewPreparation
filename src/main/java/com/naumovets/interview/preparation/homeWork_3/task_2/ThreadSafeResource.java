package com.naumovets.interview.preparation.homeWork_3.task_2;

import java.util.concurrent.locks.Lock;

public class ThreadSafeResource {
    private int counter;
    private final Lock locker;

    public ThreadSafeResource(Lock locker) {
        this.locker = locker;
    }

    public void increase() {
        locker.lock();

        counter++;
        System.out.println("Thread " + Thread.currentThread().getName() + ": " + counter);

        locker.unlock();
    }
}
