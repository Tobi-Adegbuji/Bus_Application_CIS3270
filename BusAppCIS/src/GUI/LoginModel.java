package GUI;

import java.sql.Connection;
import java.sql.SQLException;

import database.SQLConnection;

public class LoginModel {

	
	//Might delete this class and include its methods inside of the loginController class
	
	public Connection connection; 

	
	public LoginModel() {
		
		connection = SQLConnection.connector();
		
		if (connection == null) {
			
			System.out.println("Issue with Connection");
			
			
		}
		
	}
	
	
	public boolean isDBConnected() throws NullPointerException{
		
		try {
			return !connection.isClosed(); //simply returns true if connection is closed
		} catch (SQLException e) {
			e.printStackTrace();
			return false; 
		} 
		
	}
	
	
	
	
	
}
