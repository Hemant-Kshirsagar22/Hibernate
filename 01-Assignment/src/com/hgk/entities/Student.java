package com.hgk.entities;

public class Student 
{
	int rollNumber;
	String name;
	float percentage;
	
	// constructors 
	
	public Student() 
	{
		
	}
	
	public Student(int rollNumber, String name, float percentage)
	{
		this.rollNumber = rollNumber;
		this.name = name;
		this.percentage = percentage;
	}

	// setters
	public void setRollNumber(int rollNumber) 
	{
		this.rollNumber = rollNumber;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public void setPercentage(float percentage) 
	{
		this.percentage = percentage;
	}
	
	// getters
	public int getRollNumber() 
	{
		return(rollNumber);
	}
	
	public String getName() 
	{
		return(name);
	}
	
	public float getPercentage() 
	{
		return(percentage);
	}

	
	public String toString() 
	{
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", percentage=" + percentage + "]";
	}
	
}
