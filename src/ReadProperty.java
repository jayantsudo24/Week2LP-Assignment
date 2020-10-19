/*9. program to read property file in java.*/
package com.week2.programs;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperty {
	
	public static void main(String[] args) throws Exception {
		
		Properties prop= new Properties();
		InputStream is=new FileInputStream("configuration.poperties");
		
		prop.load(is);
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("password"));
	}
}
