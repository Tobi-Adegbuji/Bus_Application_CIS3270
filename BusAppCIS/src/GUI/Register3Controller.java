package GUI;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Register3Controller {

	@FXML
public Button back; 
	
	//BACK TO FIRST REGISTER PAGE 
	@FXML
	public void backToRegister2(ActionEvent event) throws IOException, SQLException  {
	
	    back.getScene().setRoot(FXMLLoader.load(getClass().getResource("Register2.fxml")));

		
	}
	
	@FXML
	public void toRegister4(ActionEvent event) throws IOException, SQLException  {
	
		
		
		 Parent registerParent = FXMLLoader.load(getClass().getResource("Register4.fxml")); 
		 
		 Scene registerScene = new Scene(registerParent); 
		 
		 Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		 

		 window.setScene(registerScene);
		 window.setResizable(false);
		 
		
	}
	
	
}
