package com.springdemo.hibernate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TestJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectMapper obt = new ObjectMapper();
    	try {
    		List<Student> names = new ArrayList<Student>();
   		 
			Student pt= new Student("derdf", "legrand2", "comedie2@yahoo.fr");
			 names.add(pt);
			 //names.add(pt1);
			// names.add(pt2);
			 
			obt.writeValue(new File("data/students.json"), names);
			 
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println( "Hello World!" );

	}

}
