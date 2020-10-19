/*8.  program to create property files and store key value pairs in it using java.*/
package com.week2.programs;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class CreateProperty {

	public static void main(String[] args) throws Exception {
		
		Properties prop= new Properties();
		OutputStream os= new FileOutputStream("configuration.poperties");
		
		prop.setProperty("url","localhost\08.mydb");
		prop.setProperty("name", "kanak");
		prop.setProperty("password", "kanakvarshney0221");
		
		prop.store(os, "This is property file");
		
		System.out.println("Done");
	}
}
