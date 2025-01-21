package com.hgk.service;

import java.util.List;

import com.hgk.dao.StudentDao;
import com.hgk.entities.Student;
import com.hgk.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	@Override
	public String addStudent(Student student) 
	{
		student.setCity(student.getCity().toLowerCase());
		student.setName(student.getName().toLowerCase());
		
		StudentDao studentDao= StudentDaoFactory.getInstanceStudentDao();
		String status = studentDao.add(student);
		return status;
	}

	@Override
	public List<Student> fetchAllStudents() {
		
		StudentDao studenDao = StudentDaoFactory.getInstanceStudentDao();
		List<Student> list = studenDao.fetchAll();
		return list;
	}

	@Override
	public String removeStudent(Integer id) {
		
		StudentDao studentDao = StudentDaoFactory.getInstanceStudentDao();
		String status = studentDao.remove(id);
		return status;
	}
	
	@Override
	public List<Student> fetchStudentByName(String name) 
	{
		
		name = name.toLowerCase();
		
		StudentDao studentDao = StudentDaoFactory.getInstanceStudentDao();
		List<Student> list = studentDao.fetchByName(name);
		return list;
	}

	@Override
	public List<Student> fetchStudentByCity(String city) 
	{
		city = city.toLowerCase();
		
		StudentDao studentDao = StudentDaoFactory.getInstanceStudentDao();
		List<Student> list = studentDao.fetchByCity(city);
		return list;
	}

	@Override
	public List<Student> fetchStudentByPer(Double per) 
	{
				
		StudentDao studentDao = StudentDaoFactory.getInstanceStudentDao();
		List<Student> list = studentDao.fetchByPer(per);
		return list;
	}
}
