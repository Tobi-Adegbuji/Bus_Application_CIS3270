package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class SQLConnection  {
	

	//Anytime we need to create connection to database we can call this static method

	public static Connection connector(){
	String url = "jdbc:mysql://35.186.182.187:3306/BusApplication";
	String username = "root"; 
	String password = "gsuPanthers2019"; 
	
	try {
	Connection connection = DriverManager.getConnection(url,username,password);
	return connection; 
	}
	catch(SQLException e) {
		System.out.println("Connection is not succfessful");
		e.printStackTrace(); //used for debugging 
		return null; 
		
	}
	
	
	
	}

	

}