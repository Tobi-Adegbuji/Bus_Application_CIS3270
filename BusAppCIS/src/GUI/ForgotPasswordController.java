package GUI;

import java.io.IOException;
import java.sql.SQLException;

import database.SQLMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ForgotPasswordController {

	@FXML
	private TextField username;
	@FXML
	private Label question;
	@FXML
	private TextField userAnswer;
	@FXML
	private Label answerLabel;
	@FXML
	private Button answerSubmit = new Button(); 
	

	//Goes back to login screen 
	
	@FXML
	public void backToLogin(ActionEvent event) throws IOException, SQLException {

		Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml"));

		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(loginScene);
		window.setResizable(false);

	}
	
	
	
	//Displays security question in GUI
	@FXML
	public void securityQuestion(ActionEvent event) throws SQLException, IOException {
		
		String securityQuestion = SQLMethods.retrieveSecurityQuestion(username.getText()); 
		
		if(securityQuestion == null) {
			
			this.question.setText("This username is not located in our system.");
			
		}
		else {
			
			this.question.setText(securityQuestion);
			
						
		}
		
		
	}
	
	//Checks if answer is correct and if it is, it takes you back to login screen
	@FXML 
	public void checkAnswer(ActionEvent event)  throws SQLException, IOException {
		
		
		String user = username.getText();
		
		if(SQLMethods.retrieveAnswer(username.getText()).equals(userAnswer.getText()) ) {
			
			
			answerLabel.setText("Enter a new password");
			
			userAnswer.setText("");
			
			userAnswer.setPromptText("Enter a new password");
			
			answerSubmit.setStyle("-fx-background-color: darkred");
			
			answerSubmit.setOnAction(e -> {
				
				try {
					SQLMethods.newPassword(userAnswer.getText(), user);
					
					answerLabel.setText("Password Updated");
					
					Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml"));

					Scene loginScene = new Scene(loginParent);

					Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

					window.setScene(loginScene);
					window.setResizable(false);
					
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			});
				
		}
		else {
			userAnswer.setText("");
			userAnswer.setPromptText("Try Again");
			
		}
		
		
	}


	
	
	
	
	
	

}
