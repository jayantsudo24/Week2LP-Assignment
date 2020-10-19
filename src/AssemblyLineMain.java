package com.week2.programs;

import org.apache.log4j.BasicConfigurator;

public class AssemblyLineMain {

    public static void main(String[] args) throws InterruptedException {
       
    	BasicConfigurator.configure();
        AssemblyLine.startAssemblyLine();
        Thread.sleep(60 * 1000);
        AssemblyLine.stopAssemblyLine();
    }

}
