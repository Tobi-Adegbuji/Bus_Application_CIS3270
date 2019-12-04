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
	
		
		
		
		
		
		@FXML
		public void toLogin(ActionEvent event) throws IOException, SQLException  {
		
			
			Connection con = SQLConnection.connector(); 
			PreparedStatement ps; 
			ResultSet rs;
			
			String query = "insert into Customer" + 
					"(ssn" + 
					",firstName" + 
					",lastName" + 
					",email" + 
					",phone" + 
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
					"(123456789" + 
					",'Alex'" + 
					",'Bugnon'" + 
					",'alexbugnon@gmail.com'" + 
					",'1234567890'" + 
					",'username'" + 
					",'passwrd'" + 
					",'1454 Alley Rd'" + 
					",'Atlanta'" + 
					",'GA'" + 
					",'United States of America'" + 
					",'30000'" + 
					",'What is your mom\'s name?'" + 
					",'Elizabeth'" + 
					",'1234'" + 
					")"; 
			
			ps = con.prepareStatement("");
			
			
			try {
		
			 Parent registerParent = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml")); 
			 
			 Scene registerScene = new Scene(registerParent); 
			 
			 Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			 

			 window.setScene(registerScene);
			 window.setResizable(false);
			 
			}
			catch(Exception e) {
				
				
				
			}
		
	}

}
