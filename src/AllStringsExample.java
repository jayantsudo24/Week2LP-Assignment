package com.week2.programs;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class AllStringsExample {
	
	private static final Logger logger = Logger.getLogger(AllStringsExample.class);
	// Concatenates to String 
    public static void concat1(String s1) 
    { 
        s1 += "Varshney"; 
    } 
  
    // Concatenates to StringBuilder 
    public static void concat2(StringBuilder s2) 
    { 
        s2.append("Varshney"); 
    } 
  
    // Concatenates to StringBuffer 
    public static void concat3(StringBuffer s3) 
    { 
        s3.append("Varshney"); 
    } 
  
    public static void main(String[] args) 
    { 
    	BasicConfigurator.configure();
    	
        String s1 = "Kanak"; 
        concat1(s1);  // s1 is not changed 
        logger.debug("String: " + s1); 
  
        StringBuilder s2 = new StringBuilder("rohan"); 
        concat2(s2); // s2 is changed 
        logger.debug("StringBuilder: " + s2); 
  
        StringBuffer s3 = new StringBuffer("monika"); 
        concat3(s3); // s3 is changed 
        logger.debug("StringBuffer: " + s3); 
    } 

}
