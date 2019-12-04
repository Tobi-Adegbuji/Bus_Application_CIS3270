package database;

import java.io.IOException;
import java.sql.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SQLMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean verify(String username, String password) throws SQLException {
		
		Connection con = SQLConnection.connector();
		PreparedStatement preparedStatement; 
		ResultSet resultSet; 
		String query = "SELECT * FROM Customer WHERE username = ? AND password = ?"; 
		
			
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
	
		
		
		
		
		
		
		public static void toRegister(String ssn, String firstName, String lastName, String email, String city, String address, String country, String state, 
				String zipcode, String username, String password, String securityQuestion, String securityAnswer, String id) throws Exception  {
		
			
			Connection con = SQLConnection.connector(); 
			PreparedStatement ps; 
			ResultSet rs;
			
			String query = "insert into Customer" + 
					"(ssn" + 
					",firstName" + 
					",lastName" + 
					",email" +  
					",username" + 
					",password" + 
					",street" + 
					",city" + 
					",state" + 
					",country" + 
					",zip" + 
					",security_question" + 
					",security_answer" + 
					",id" + 
					")" + 
					"values" + 
					"(?" + 
					",?" + 
					",?" + 
					",?" + 
					",?" + 
					",?" + 
					",?" + 
					",?" + 
					",?" + 
					",?" + 
					",?" + 
					",?" + 
					",?" + 
					",?" + 
					")"; 
			try {
			ps = con.prepareStatement(query);
			
			ps.setString(1, String.valueOf(ssn));

			ps.setString(2, firstName);
			
			ps.setString(3, lastName);
			
			ps.setString(4, email);
			
			ps.setString(5, username);
			
			ps.setString(6, password);
			
			ps.setString(7, address);
			
			ps.setString(8, city);
			
			ps.setString(9, state);
			
			ps.setString(10, country);
			
			ps.setString(11, String.valueOf(zipcode));
			
			ps.setString(12, securityQuestion);
			
			ps.setString(13, securityAnswer);
			
			ps.setString(14, String.valueOf(id));
			
			
			ps.executeUpdate();
			
			System.out.println("User was registered");
			
			}
			catch(SQLException e) {
				
				throw new SQLException(); 
				
			}
			finally {
				
				con.close();
				
			}
			
		}

}
