/*13. write a program that computes your initials form your full name and displays them. 
For ex. John F Kennedy should display JFK . USe string builder class.*/
package com.week2.programs;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class ComputeInitial {
     
	private static final Logger logger = Logger.getLogger(ComputeInitial.class);
	public static void main(String[] args){
		
		BasicConfigurator.configure();
		StringBuilder buffer = new StringBuilder();
		
		Scanner sc= new Scanner(System.in);
   	    String str=sc.nextLine();

		String[] value=str.split("\\s");    //splits the string based on string
		
		for(String s:value){
			
			buffer.append(s.charAt(0));
		}
		
		logger.debug(buffer.toString());
	}
 }
