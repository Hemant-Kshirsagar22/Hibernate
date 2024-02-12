package com.hgk;

import com.hgk.entities.Student;

public class App {

	public static void main(String[] args) 
	{
		Student s1 = new Student();
		System.out.println(s1);
		
		Student s2 = new Student(101,"AAA",80.87f);
		System.out.println(s2);
		
		Student s3 = new Student();
		
		s3.setRollNumber(102);
		s3.setName("BBB");
		s3.setPercentage(89.87f);
		
		System.out.println("Roll Number  : " + s3.getRollNumber());		
		System.out.println("Name         : " + s3.getName());		
		System.out.println("Percentage   : " + s3.getPercentage());		
		
	}

}
