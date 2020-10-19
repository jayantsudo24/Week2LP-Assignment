/*12.  write a program that will determine if given two strings are anagrams or not. 
 * For ex. strings abcd,bcda and cadb are anagrams asuming white spaces can be ignored.*/
package com.week2.programs;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class CheckAnagrams {

	private static final Logger logger = Logger.getLogger(CheckAnagrams.class);
	static boolean checkAnagrams(char[] str1, char[] str2) {
		
		int lengthStr1= str1.length;
		int lengthStr2= str2.length;
		
		if(lengthStr1 != lengthStr2) 
			   return false;
		
		Arrays.sort(str1);
		Arrays.sort(str2);
		
		for(int i=0; i<lengthStr1; i++) {
			
			if(str1[i] != str2[i])
				return false;
		}
		
		return true;	
	}
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		Scanner sc= new Scanner(System.in);
		
		logger.info("enter frst string");
		String str1= sc.next();
		char[] string1=str1.toCharArray();
		
		logger.info("enter second string");
		String str2=sc.next();
		char[] string2=str2.toCharArray();
		
		if(checkAnagrams(string1, string2 )) {
			
			logger.debug("Strings are anagrams");
		}
		else {
			
			logger.debug("Strings are not anagrams");
		}
	}
}
