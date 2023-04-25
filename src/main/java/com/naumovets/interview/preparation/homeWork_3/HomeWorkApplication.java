package com.naumovets.interview.preparation.homeWork_3;

import com.naumovets.interview.preparation.homeWork_3.task_1.Ball;
import com.naumovets.interview.preparation.homeWork_3.task_1.Player;
import com.naumovets.interview.preparation.homeWork_3.task_2.Counter;
import com.naumovets.interview.preparation.homeWork_3.task_2.ThreadSafeResource;

import java.util.concurrent.locks.ReentrantLock;

public class HomeWorkApplication {
    public static void main(String[] args) {
        //=====================================================
        // Задание 1.
        //=====================================================

        /*
         Задание реализовано в пекедже task_1.
        */

        Ball ball = new Ball();
        Player leftPayer = new Player(ball, Ball::ping);
        Player rightPayer = new Player(ball, Ball::pong);

        new Thread(leftPayer, "Payer_1").start();
        new Thread(rightPayer, "Payer_2").start();

        //=====================================================
        // Задание 2.
        //=====================================================

        /*
         Задание реализовано в пекедже task_2.
        */

        ThreadSafeResource resource = new ThreadSafeResource(new ReentrantLock());

        Counter counterOne = new Counter(resource);
        Counter counterTwo = new Counter(resource);

        new Thread(counterOne, "counterOne").start();
        new Thread(counterTwo, "counterTwo").start();
    }
}
