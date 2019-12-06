package database;

import java.sql.*;


public class DatabaseSetup {
	
	
	public static void main(String[] args) throws Exception {
	
	Connection connection = SQLConnection.connector(); 
		
	String customer = "CREATE TABLE Customer" +
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
	" admin_access VARCHAR(1) not NULL default 'N', " +
	" PRIMARY KEY (ssn))"; 

	
	//Creating one admin 
	
//	SQLMethods.toRegister("000000000", "admin", "admin", "admin", "admin", 
//			"admin", "admin","admin", "00000", "adm1n", "adm1n", "What is your first name?", 
//			"admin", "0000", "Y");
//	
	
	
	
	//Creating bus schedule table
	String busSchedule = "CREATE TABLE Bus_Schedule" +
	"(schedule_ID INTEGER not NULL AUTO_INCREMENT ," +  //Automatically increments the PK
	" bus_ID INTEGER(3), " +
	" passenger_no VARCHAR(25), " +
	" from_station VARCHAR(50), " +
	" to_station VARCHAR(50), " +
	" arrival_date DATE, " +
	" departure_date DATE, " +
	" arrival_time DATETIME, " +
	" departure_time DATETIME, " +
	" PRIMARY KEY (schedule_ID)," +
	" FOREIGN KEY (bus_ID) REFERENCES Bus(bus_ID), " +
	" FOREIGN KEY (from_station) REFERENCES Bus_Station(station_name), " +
	" FOREIGN KEY (to_station) REFERENCES Bus_Station(station_name)" +
	")"; 


	String bus = "CREATE TABLE Bus" +
			"(bus_ID INTEGER(3) not NULL AUTO_INCREMENT ," +  
			" capacity INTEGER(26), " + //each bus has 26 seats only
			" PRIMARY KEY (bus_ID))";
	
	String bus_station = "CREATE TABLE Bus_Station" +
			"(station_name VARCHAR(26) not NULL, " +
			" station_acronym VARCHAR(5), " +
			" PRIMARY KEY (station_name))";
	
	String customer_schedule = "CREATE TABLE Customer_Schedule" +
			"(SSN INTEGER(9) not NULL, " +
			" schedule_ID INTEGER not NULL, " +
			" passenger_no VARCHAR(25) not NULL, " +
			" from_station VARCHAR(50) not NULL, " +
			" to_station VARCHAR(50) not NULL, " +
			" arrival_date DATE not NULL, " +
			" departure_date DATE not NULL, " +
			" arrival_time DATETIME not NULL, " +
			" departure_time DATETIME not NULL, " +
			" delete_flag VARCHAR(1) not NULL default '0', " + //if this value is 1, the user deleted the schedule. 
			" PRIMARY KEY (SSN, schedule_ID) , " +
			" FOREIGN KEY (SSN) REFERENCES Customer(SSN), " +
			" FOREIGN KEY (schedule_ID) REFERENCES Bus_Schedule(schedule_ID)" +
			")"; 
	
	
	
	String dropCustomer = "DROP TABLE Bus_Schedule"; 

	
	
	
	Statement statement;
	
	try {
		statement = connection.createStatement();
		
		statement.executeUpdate(customer_schedule); 

		System.out.println("Table Created");
		 
		statement.close();
		connection.close();
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	} 
	finally {
		
		connection.close();
		
	}
	
	
}







}



