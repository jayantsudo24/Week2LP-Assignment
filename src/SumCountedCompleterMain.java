package com.week2.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class SumCountedCompleterMain {

	private static final Logger logger = Logger.getLogger(SumCountedCompleterMain.class);

    public static void main(String[] args) {

    	BasicConfigurator.configure();
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        Random rnd = new Random();
        List<Integer> list = new ArrayList();
        for (int i = 0; i < 200; i++) {
            list.add(1 + rnd.nextInt(10));
        }

        SumCountedCompleter sumCountedCompleter = new SumCountedCompleter(null, list);
        forkJoinPool.invoke(sumCountedCompleter);
        logger.info( "Done! Result: " + sumCountedCompleter.getRawResult());
}
}
