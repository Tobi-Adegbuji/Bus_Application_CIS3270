package GUI;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RegisterController {

	
	@FXML
	public void backToLogin(ActionEvent event) throws IOException, SQLException  {
	
		
		
		 Parent loginParent = FXMLLoader.load(getClass().getResource("Login.fxml")); 
		 
		 Scene loginScene = new Scene(loginParent); 
		 
		 Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		 
		 window.setScene(loginScene);
		 window.setResizable(false);
		 
		
	}
	
	@FXML
	public void toRegister2(ActionEvent event) throws IOException, SQLException  {
	
		
		
		 Parent registerParent = FXMLLoader.load(getClass().getResource("Register2.fxml")); 
		 
		 Scene registerScene = new Scene(registerParent); 
		 
		 Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		 

		 window.setScene(registerScene);
		 window.setResizable(false);
		 
		
	}
	

	
	
	
	
}
