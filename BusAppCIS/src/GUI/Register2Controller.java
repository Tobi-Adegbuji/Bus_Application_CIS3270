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
import javafx.stage.StageStyle;

public class Register2Controller {

	@FXML
public Button back; 
	
	//BACK TO FIRST REGISTER PAGE 
	@FXML
	public void backToRegister(ActionEvent event) throws IOException, SQLException  {
	
	    back.getScene().setRoot(FXMLLoader.load(getClass().getResource("Register.fxml")));

		
	}
	
}
