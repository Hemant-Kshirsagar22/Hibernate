package com.hgk;

import com.hgk.entities.Employee;

public class App {

	public static void main(String[] args) 
	{
		Employee e1 = new Employee();
		System.out.println(e1);
		
		Employee e2 = new Employee(1,"AAA",50000.00,"Pune");
		System.out.println(e2);
		
		Employee e3 = new Employee();
		
		e3.setEno(2);
		e3.setEname("BBB");
		e3.setSalary(60000.00);
		e3.setCity("Mumbai");
		
		System.out.println("Employee NO     : " + e3.getEno());
		System.out.println("Employee Name   : " + e3.getEname());
		System.out.println("Employee Salary : " + e3.getSalary() + " Rs.");
		System.out.println("Employee City   : " + e3.getCity());

	}

}
