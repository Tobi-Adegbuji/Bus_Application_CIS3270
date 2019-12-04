package Logic;

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
import javafx.stage.StageStyle;

public class Register2Controller {

	@FXML
public Button back; 
	
	
	
	//BACK TO FIRST REGISTER PAGE 
	@FXML
	public void backToRegister(ActionEvent event) throws IOException, SQLException  {
	
		
		System.out.println();
		
	    back.getScene().setRoot(FXMLLoader.load(getClass().getResource("/GUI/Register.fxml")));

	    
	    
		
	}
	
	
	@FXML
	public void toRegister3(ActionEvent event) throws IOException, SQLException  {
	
		
		
		 Parent registerParent = FXMLLoader.load(getClass().getResource("/GUI/Register3.fxml")); 
		 
		 Scene registerScene = new Scene(registerParent); 
		 
		 Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		 

		 window.setScene(registerScene);
		 window.setResizable(false);
		 
		
	}
	
	
}
