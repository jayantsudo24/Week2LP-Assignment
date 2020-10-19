/*3. write a program that simulates the orchestration of a read write process via stampedlock.*/
package com.week2.programs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class StampedLockExample {
    
	private static final Logger logger = Logger.getLogger(StampedLockExample.class);
	int c = 0;
    public static void main(String[] args) {
    	
    	BasicConfigurator.configure();
        final StampedLock sl = new StampedLock();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        final StampedLockExample cst = new StampedLockExample();
        
        Runnable readTask = new Runnable() {
			public void run() {
			    long stamp = sl.readLock();
			    try{
			        logger.debug("value " + cst.getValue());
			        
			    }finally{
			        sl.unlockRead(stamp);
			    }
			}
		};
        
        Runnable writeTask = new Runnable() {
			public void run() {
			    long stamp = sl.writeLock();
			    try {
			        cst.increment();
			    }finally{
			        sl.unlockWrite(stamp);
			    }
			}
		};
        
        // 3 write tasks
        executor.submit(writeTask);
        executor.submit(writeTask);
        executor.submit(writeTask);
        // 1 read task
        executor.submit(readTask);
        executor.shutdown();

    }
    public  void increment() {     
        c++;
        logger.debug("in increment " + c);
    }

    public  int getValue() {
        return c;
    }

}