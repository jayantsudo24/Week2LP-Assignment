/*6.Let say c:/myFile.text looks like this>
  you learning file io with core java programming
write a program to insert/write content at specific position in file in java, such that after execution
 of program file must look like this-
you ARE learning file io with core java programming.*/
package com.week2.programs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class InsertAtSpecific {
	
	private static final Logger logger = Logger.getLogger(InsertAtSpecific.class);
	
	public static void main(String[] args) throws IOException{
		
		BasicConfigurator.configure();
		BufferedWriter writer = null;
		BufferedReader buffer=null;
		
		try {
			new File("MyFile.text");
			
			buffer= new BufferedReader(new FileReader("MyFile.text"));
			
			String str=buffer.readLine();
			
			String updatedStr = str.substring(0,4) + "ARE" + str.substring(4);
		   
			writer = new BufferedWriter(new FileWriter("MyFile.text",true));
			writer.write("\n"+ updatedStr);
			
			
			logger.debug("Done");
		}
		catch(IOException e) {
			
			logger.error("An error occured");
			e.printStackTrace();
		}
		finally {
			 try{
		            if (buffer != null)
		            {
		                buffer.close();
		            }
		             
		            if(writer != null)
		            {
		                writer.close();
		            }
		        } 
			 catch (IOException e) {
		            e.printStackTrace();
		        }
		}
	}
}
