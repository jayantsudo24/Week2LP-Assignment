/*11. write a program that will determine if a given string has all unique charaters or not.
 *  for ex. string abc qualifies this criteria but abccd nor aabbcc.*/
package com.week2.programs;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class CheckUnique {
	
	private static final Logger logger = Logger.getLogger(CheckUnique.class);
	public static boolean haveUniques(char[] string) {
		
		for(int i=0; i<string.length-1; i++) {
			for(int y=i+1; y<string.length; y++) {
			     if(string[i] != string[y]) {}
			     else 
			    	 return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		
		Scanner sc=new Scanner(System.in);
		
		logger.info("enter a string");
		String str1=sc.next();
		char[] string =str1.toCharArray();
		
		if(haveUniques(string)) {
			
			logger.debug("String have unique characters");
		}
		else {
			
			logger.debug("String doen't have unique characters");
		}
	}
}
