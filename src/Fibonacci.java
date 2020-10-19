/*5.Write a program
that relies on fork/join framework to compute the Fibonacci number at the given position(e.g. F12=144)*/
package com.week2.programs;

import java.util.Scanner;
import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {
	 
    final int n;
	
    Fibonacci(int n){
		
		this.n=n;
	}
	
	public Integer compute() {
		
		if(n<=1)
			return n;
		
		Fibonacci f1= new Fibonacci(n-1);
		f1.fork();
		Fibonacci f2= new Fibonacci(n-2);
		f2.fork();
		
		return f2.join()+f1.join();
	}
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter a number to find its fibonacci number");
		int n=sc.nextInt();
		Fibonacci fb = new Fibonacci(n);
		System.out.println(fb.compute());
		
	}
	

}
