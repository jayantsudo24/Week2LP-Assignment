/*5. write a program that relies on fork/join framework to sum the elements of a list. */
package com.week2.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class SumOfArrayList {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list= new ArrayList();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter no of elements to add");
		int n=sc.nextInt();
		
		System.out.println("Enter elements to add");
	    for(int i=0; i< n; i++) {
	    	
	    	int data=sc.nextInt();
	    	list.add(data);
	    }
	    
	    SumCamculate s=new SumCamculate(list,0,list.size());
	    System.out.println(s.compute());
	}
}
class SumCamculate extends RecursiveTask<Integer>{
	
	static final int THRESHOLD = 10;
	private List<Integer> list;
	int begin;
	int end;
	
	public SumCamculate(List<Integer> list,int begin, int end) {
		super();
		this.list=list;
		this.begin=begin;
		this.end=end;
	}
  

	@Override
	protected Integer compute() {
		
		final int size = end - begin;
	    
		if (size < THRESHOLD) {
	      
			int sum = 0;
	      for (int i = begin; i < end; i++)
	        sum += list.get(i);
	      return sum;
	    } 
		
		else {
	      
			final int mid = list.size()/2;
	      SumCamculate sum1 = new SumCamculate(list, begin, mid);
	      sum1.fork();
	      SumCamculate sum2 = new SumCamculate(list, mid, end);
	      sum2.fork();
	      
	      return sum2.join()+sum1.join();
	    }
		
	}
}