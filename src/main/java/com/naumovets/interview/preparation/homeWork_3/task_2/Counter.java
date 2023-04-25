package com.naumovets.interview.preparation.homeWork_3.task_2;



public class Counter implements Runnable {
    private ThreadSafeResource threadSafeResource;

    public Counter(ThreadSafeResource threadSafeResource) {
        this.threadSafeResource = threadSafeResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            threadSafeResource.increase();
        }
    }
}
