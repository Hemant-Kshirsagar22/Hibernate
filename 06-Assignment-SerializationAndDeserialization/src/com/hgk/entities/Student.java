package com.hgk.entities;

import java.io.Serializable;

public class Student implements Serializable 
{
	static final long serialVersionUID = 1L;
	
	private int rno;
	private String name;
	private Float per;
	
	public int getRno() 
	{
		return rno;
	}
	
	public void setRno(int rno) 
	{
		this.rno = rno;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public Float getPer() 
	{
		return per;
	}
	
	public void setPer(Float per) 
	{
		this.per = per;
	}
	
	public String toString() 
	{
		return "Student [rno=" + rno + ", name=" + name + ", per=" + per + "]";
	}
}

