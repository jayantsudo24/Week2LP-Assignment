/*1.Write a program that increment the integers from 1 to 1000000 using a multithreaded application
(Runnable) ie. Multiple threads should increment the counter, allowed to increment the counter until 
reaches the max value. Manage the threads using thread pool. Make sure shutdown the executor once the 
process completed.*/
package com.week2.programs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class ThreadPool implements Runnable {
	
	private static final Logger logger = Logger.getLogger(ThreadPool.class);
	
	private static AtomicInteger counter;
    private static final int LIMIT = 10000;
    private static final int THREADPOOLSIZE = 5;

    public static void main(String[] args) {
    	
    	BasicConfigurator.configure();
    	
        counter = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(THREADPOOLSIZE);
        for (int i = 0; i < THREADPOOLSIZE; i++) {
            executorService.submit(new ThreadPool());
        }
        executorService.shutdown();
    }

    public void run() {
        while (counter.get() < LIMIT) {
            increaseCounter();
            try {  
            	Thread.sleep(2000);  
            } 
            catch (InterruptedException e) {
            	
            	e.printStackTrace(); 
            	Thread.currentThread().interrupt();
            }  
        }
    }

    private void increaseCounter() {
        logger.debug(Thread.currentThread().getName() + " : " + counter.getAndIncrement());
    }
}
