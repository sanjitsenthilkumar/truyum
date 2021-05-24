package Dao;

import java.util.Properties;
import java.sql.*;

public class ConnectionHandler {

	public static Connection getConnection()
	{
		try 
		{
			Properties prop = new Properties();
			prop.load(ConnectionHandler.class.getResourceAsStream("connection.properties"));
			
			Connection conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));

			return conn;
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
