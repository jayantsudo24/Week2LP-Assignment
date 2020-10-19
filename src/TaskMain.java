package com.week2.programs;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;


public class TaskMain {

    private static final Logger logger = Logger.getLogger(TaskMain.class);

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        Task taskA = new Task("Task-A", new Adder(1));
        Task taskB = new Task("Task-B", new Adder(2), taskA);
        Task taskC = new Task("Task-C", new Adder(3), taskA, taskB);
        Task taskD = new Task("Task-D", new Adder(4), taskA, taskB, taskC);

        logger.info("Result: " + forkJoinPool.invoke(taskD));
    }

    private static class Adder implements Callable {

        private static final AtomicInteger result = new AtomicInteger();
        private Integer nr;

        public Adder(Integer nr) {
            this.nr = nr;
        }

        public Integer call() {

            logger.info( "Adding number: " + nr
                    + " by thread:" + Thread.currentThread().getName());

            return result.addAndGet(nr);
        }
    }
    
    
}
