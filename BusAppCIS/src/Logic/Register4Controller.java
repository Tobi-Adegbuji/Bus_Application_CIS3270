package Logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.SQLConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Register4Controller {

	@FXML
public Button back; 
	
	@FXML
	public void backToRegister3(ActionEvent event) throws IOException, SQLException  {
	
	    back.getScene().setRoot(FXMLLoader.load(getClass().getResource("/GUI/Register3.fxml")));

		
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
