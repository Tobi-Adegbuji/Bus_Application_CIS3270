package database;

import java.sql.*;


public class DatabaseSetup {
	
	
	public static void main(String[] args) throws Exception {
	
	Connection connection = SQLConnection.connector(); 
		
	String customerTable = "CREATE TABLE Customer" +
	"(ssn INTEGER(9) not NULL ," +
	" first_name VARCHAR(20) not NULL," +
	" last_name VARCHAR(20) not NULL, " +
	" email VARCHAR(100) not NULL," +
	" username VARCHAR(20) not NULL, " +
	" password VARCHAR(25) not NULL, " +
	" address VARCHAR(100) not NULL, " +
	" city VARCHAR(50) not NULL, " +
	" state VARCHAR(50) not NULL, " +
	" country VARCHAR(25) not NULL," +
	" zip VARCHAR(5) not NULL, " +
	" security_question VARCHAR(200) not NULL, " +
	" security_answer VARCHAR(200) not NULL, " +
	" id VARCHAR(7) not NULL, " +
	" admin_access VARCHAR(1) not NULL, " +
	" PRIMARY KEY (ssn))"; 

	
	//Creating one admin 
	
	SQLMethods.toRegister("000000000", "admin", "admin", "admin", "admin", 
			"admin", "admin","admin", "00000", "adm1n", "adm1n", "What is your first name?", 
			"admin", "0000", "Y");
	
	
	String schedule = "CREATE TABLE Admin" +
	"(tripID INTEGER(6) not NULL ," +
	" capacity INTEGER(25), " +
	" lastName VARCHAR(20), " +
	" email VARCHAR(100), " +
	" phone VARCHAR(12), " +
	" username VARCHAR(20), " +
	" password VARCHAR(25), " +
	" street VARCHAR(100), " +
	" city VARCHAR(50), " +
	" state VARCHAR(50), " +
	" country VARCHAR(25)," +
	" zip VARCHAR(5), " +
	" security_question VARCHAR(700), " +
	" security_answer VARCHAR(200), " +
	" id VARCHAR(7), " +
	" PRIMARY KEY (tripID))"; 


	
	String dropCustomer = "DROP TABLE Customer"; 

	
	Statement statement;
	
	try {
		statement = connection.createStatement();
		
//		statement.executeUpdate(); 

		System.out.println("Table Created");
		 
		statement.close();
		connection.close();
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	} 
	
	
}







}



