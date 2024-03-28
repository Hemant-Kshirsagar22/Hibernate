package com.tca;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.tca.entities.Student;

public class App {

	public static void main(String[] args) 
	{
		System.out.println("Welocome to TCA");
		
		
		Class<Student> c = Student.class;
		
		System.out.println("");
		System.out.println("PARENT CLASS : " + c.getSuperclass());
		
		
		Field fields[] =c.getDeclaredFields(); // f[0]: rno    f[1]:name  f[2]:per
		
		System.out.println("\n\n****Fields in Student Class *****");
		
		for(Field f:fields)
		{
			System.out.println(f);
		}
		
		Method[] methods = c.getDeclaredMethods();
		
		System.out.println("\n\n****Methods in Student Class *****");
		
		for(Method m :  methods)
		{
			System.out.println(m);
		}
			
		Constructor<?>[] constructors = c.getDeclaredConstructors();
		
		System.out.println("\n\n****Constructors in Student Class *****");
		
		for(Constructor<?> con : constructors)
		{
			System.out.println(con);
		}

		
		String[]  names  = {"IND", "ENG" ,"NZ"};
		
		for(String s :names)
		{
			System.out.println(s);
		}
	}

}







