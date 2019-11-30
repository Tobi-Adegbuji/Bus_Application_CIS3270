package database;

import java.sql.*;


public class TableCreation {
	
	
	public static void main(String[] args) {
	
	Connection connection = SQLConnection.connector(); 
		
	String customerTable = "CREATE TABLE Customer" +
	"(ssn INTEGER(9) not NULL ," +
	" firstName VARCHAR(20), " +
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
	" PRIMARY KEY (ssn))"; 

	String adminTable = "CREATE TABLE Admin" +
	"(ssn INTEGER(9) not NULL ," +
	" firstName VARCHAR(20), " +
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
	" PRIMARY KEY (ssn))"; 


	
	String dropCustomer = "DROP TABLE Customer"; 

	
	Statement statement;
	
	try {
		statement = connection.createStatement();
		
		statement.executeUpdate(adminTable); 

		System.out.println("Table Created");
		 
		statement.close();
		connection.close();
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	} 
	
	
}







}



