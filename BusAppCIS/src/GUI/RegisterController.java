package GUI;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RegisterController {

	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField email;
	@FXML
	private TextField phoneNumber;
	
	private String fn, ln, em, pn;
	
	
	//Takes you back to login 
	@FXML
	public void backToLogin(ActionEvent event) throws IOException, SQLException {

		Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml"));

		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(loginScene);
		window.setResizable(false);

	}

	
	
	//Takes you to second register page
	@FXML
	public void toRegister2(ActionEvent event) throws IOException, SQLException {

		

			Parent registerParent = FXMLLoader.load(getClass().getResource("/GUI/Register2.fxml"));

			Scene registerScene = new Scene(registerParent);

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(registerScene);
			window.setResizable(false);
	
	}
	
	@FXML
	public void complete(ActionEvent event) throws IOException, SQLException {

		Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml"));

		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(loginScene);
		window.setResizable(false);

	}
	
	
	//Checks page
	public boolean checkPage() {		
		
		
		return true;

		
	}




	
	//Getters so we  can pass information to the next scene ---------------------------------------------
	
	public String getFn() {
		return fn;
	}



	public String getLn() {
		return ln;
	}



	public String getEm() {
		return em;
	}



	public String getPn() {
		return pn;
	}


	

	
	
	
	
	
	

}
