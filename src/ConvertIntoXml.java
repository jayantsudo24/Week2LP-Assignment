package com.week2.programs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConvertIntoXml {
	
	public static void main(String[] args) throws Exception {
		
		Properties prop=new Properties();
		 
		prop.setProperty("email.support", "kanak@gmail.com");
		
		 
		 OutputStream os= new FileOutputStream("config.poperties");
		 
		 prop.storeToXML(os, null);
		 
		 System.out.println("Done");
		 
	}

}
