package com.hgk.service;

import java.util.List;

import com.hgk.entities.Student;

public interface StudentService
{
	public abstract String addStudent(Student student);
	
	public abstract String removeStudent(Integer id);
	
	public abstract List<Student> fetchAllStudents();
	public abstract List<Student> fetchStudentByName(String name);
	public abstract List<Student> fetchStudentByCity(String city);
	public abstract List<Student> fetchStudentByPer(Double per);
}
