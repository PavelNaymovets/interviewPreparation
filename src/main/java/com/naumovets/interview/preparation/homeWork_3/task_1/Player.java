package com.naumovets.interview.preparation.homeWork_3.task_1;

import java.util.function.Consumer;

public class Player implements Runnable{
    private final Ball ball;
    private final Consumer<Ball> action;

    public Player(Ball ball, Consumer<Ball> action) {
        this.ball = ball;
        this.action = action;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            action.accept(ball);
        }
    }
}
