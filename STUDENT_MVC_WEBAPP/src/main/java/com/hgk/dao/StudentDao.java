package com.hgk.dao;

import java.util.List;

import com.hgk.entities.Student;

public interface StudentDao 
{
	public abstract String add(Student student);
		
	public abstract String remove(Integer id);
	
	public abstract List<Student> fetchAll();
	public abstract List<Student> fetchByName(String name);
	public abstract List<Student> fetchByCity(String city);
	public abstract List<Student> fetchByPer(Double per);
	
}
