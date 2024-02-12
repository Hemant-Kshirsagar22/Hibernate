package com.hgk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class App 
{
	public static void main(String[] args) 
	{
		FileReader fileReader = null;
		BufferedReader br = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String DBUrl = "jdbc:mysql://localhost:3306/hibernate";
        String userName = "hemant";
        String password = "1234";
		try
		{
			fileReader =  new FileReader("resources/student.csv");
			br = new BufferedReader(fileReader);
			String line = null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DBUrl,userName,password);
			
			preparedStatement = connection.prepareStatement("insert into student values(?,?,?)");
						
			while((line = br.readLine()) != null)
			{
				String token[] = line.split(",");
			
				if(token.length < 3)
				{
					continue;
				}
								
				preparedStatement.setInt(1, Integer.parseInt(token[0]));
				preparedStatement.setString(2, token[1]);
				preparedStatement.setFloat(3, Float.parseFloat(token[2]));
				
				preparedStatement.executeUpdate();
			}
			
			System.out.println("Data added into database successfully !!!");
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				br.close();
				connection.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
		}
		
		
	}
}
