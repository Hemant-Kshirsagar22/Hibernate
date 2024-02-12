package com.hgk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertIntoDBUsingPostgresql 
{
	public static void main(String[] args) throws Exception
    {
        
        Connection connection = null;
        PreparedStatement query = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String DBUrl = "jdbc:postgresql://localhost/hibernate";
        String userName = "hemant";
        String password = "123";
        try
        {
        
            // Step 1 : Load And Register Driver

            Class.forName("org.postgresql.Driver");

            // step 2 : form Connection

            connection = DriverManager.getConnection(DBUrl,userName,password);

            query = connection.prepareStatement("INSERT INTO student VALUES(?,?,?)");

            System.out.print("Enter Roll Number : ");
            Integer rno = Integer.parseInt(br.readLine());
            
            System.out.print("Enter Your Name : ");
            String name = br.readLine();
            
            System.out.print("Enter Percentage : ");
            Float per = Float.parseFloat(br.readLine());

            query.setInt(1,rno);
            query.setString(2,name);
            query.setFloat(3, per);

            int status = query.executeUpdate();

            if(status == 0)
            {
                throw new Exception("Error While Inserting The Data !!!");
            }
            else
            {
                System.out.println("Data Inserted Successfully !!!");
            }

        }   
        catch(Exception e)
        {
            e.printStackTrace();

            System.out.println("\n\nError While Inserting The Data Into SQL !!!");
        }
        finally
        {
            connection.close();
        }
    }
}
