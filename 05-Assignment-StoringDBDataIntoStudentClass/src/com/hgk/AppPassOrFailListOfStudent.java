package com.hgk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hgk.entities.Student;

public class AppPassOrFailListOfStudent {

	public static void main(String[] args) throws Exception
	{
        
        Connection connection = null;
        Statement query = null;
        
        ResultSet rs = null;

        String DBUrl = "jdbc:mysql://localhost:3306/hibernate";
        String userName = "hemant";
        String password = "1234";
        
        try
        {
        
            // Step 1 : Load And Register Driver

            Class.forName("com.mysql.cj.jdbc.Driver");

            // step 2 : form Connection

            connection = DriverManager.getConnection(DBUrl,userName,password);

            query = connection.createStatement();
            
            rs = query.executeQuery("select * from student");
                        
           
            
            List<Student> passStudentList = new ArrayList<>();
            List<Student> failStudentList = new ArrayList<>();
            
            while(rs.next())
            {
            	Student student = new Student();
            	
            	student.setRollNumber(rs.getInt("rno"));
            	student.setName(rs.getString("name"));
            	student.setPercentage(rs.getFloat("per"));
            	
            	if(rs.getFloat("per") < 35.00f)
            	{
            		failStudentList.add(student);
            	}
            	else if(rs.getFloat("per") >= 35.00f)
            	{
            		passStudentList.add(student);
            	}
            }
            
            System.out.println("List Of Pass Students : ");
            System.out.println("RNO NAME PER");
            for(Student student : passStudentList)
            {
            	System.out.println(student.getRollNumber() + " " + student.getName() + "  " + student.getPercentage());            	
            }
            
            System.out.println("\n\nList Of Fail Students : ");
            System.out.println("RNO NAME PER");
            for(Student student : failStudentList)
            {
            	System.out.println(student.getRollNumber() + " " + student.getName() + "  " + student.getPercentage());            	
            }
            
        }   
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            connection.close();
        }
    }

}
