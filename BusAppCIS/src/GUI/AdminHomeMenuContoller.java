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

public class AdminHomeMenuContoller {

	@FXML
	public void logOut(ActionEvent event) throws IOException, SQLException  {
	
		
		
		 Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml")); 
		 
		 Scene loginScene = new Scene(loginParent); 
		 
		 Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		 
		 window.setScene(loginScene);
		 window.setResizable(false);
		 
		
	}
	
	//Takes you to view my rides screen 
		@FXML
		public void viewMyRides(ActionEvent event) throws IOException, SQLException  {
		
			
			
			 Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/ViewMyRides.fxml")); 
			 
			 Scene loginScene = new Scene(loginParent); 
			 
			 Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			 
			 window.setScene(loginScene);
			 window.setResizable(false);
			 
			
		}
	
}
