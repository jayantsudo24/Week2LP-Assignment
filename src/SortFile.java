package com.week2.programs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SortFile {
	
	public static void main(String[] args)  {
		
	
	BufferedReader reader = null; 
    BufferedWriter writer = null;
       
    ArrayList<String> lines = new ArrayList();
     
    try
    {
        
    
        reader = new BufferedReader(new FileReader("BeforeSorting.text"));
         
        String currentLine = reader.readLine();
         
        while (currentLine != null) 
        {
            lines.add(currentLine);
            currentLine = reader.readLine();
        }
         
        Collections.sort(lines);
         
        writer = new BufferedWriter(new FileWriter("AfterSorting.text"));
         
        for (String line : lines)
        {
            writer.write(line);
            writer.newLine();
        }
    } 
    catch (IOException e) 
    {
        e.printStackTrace();
    }
    finally
    {
   
        try
        {
            if (reader != null)
            {
                reader.close();
            }
             
            if(writer != null)
            {
                writer.close();
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
} 
}


