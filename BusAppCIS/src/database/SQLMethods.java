package database;

import java.sql.*;

public class SQLMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean verify(String username, String password) {
		
		Connection con = SQLConnection.connector();
		PreparedStatement preparedStatement; 
		ResultSet resultSet; 
		String query = "SELECT * FROM Customer WHERE username = ? AND password = ?"; 
		
		try { 
			
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, username);

			preparedStatement.setString(2, password);


			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
				return true; 
				
			}
			else {
				return false; 
				
			}
			
			
		}
		catch(Exception e) {
			
			return false;
			
		}
		finally {
			
			
		}
		
	}

}
