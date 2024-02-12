package com.hgk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayDataFromDB {

	public static void main(String[] args) throws Exception
    {
        
        Connection connection = null;
        Statement query = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
                        
            System.out.println("RNO NAME PER");
            while(rs.next())
            {
            	System.out.println(rs.getInt("rno") + " " + rs.getString("name") + "  " + rs.getFloat("per"));
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
