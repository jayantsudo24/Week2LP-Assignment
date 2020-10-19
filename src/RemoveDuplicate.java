/*14.  Design a algorithm and write a code to remove the duplicate characters in a string without using any
additional buffer. Use one or two additional variables are fine but don't use an extra copy of the array.*/
package com.week2.programs;

import java.util.Scanner;

public class RemoveDuplicate {
	
	public static void remove(String str) {
		
		String newStr= "";

		for(int i=0; i< str.length(); i++) {
			
			char c=str.charAt(i);
			if(newStr.indexOf(c)<0) {
				
				newStr+=c;
				
			}
		}
		
		System.out.println(newStr);
	}
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter a string to remove its duplicates");
		String str=sc.nextLine();
		
		remove(str);
	}

}
