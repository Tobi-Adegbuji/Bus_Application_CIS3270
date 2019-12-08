package GUI;

import java.io.IOException;
import java.sql.SQLException;

import entities.Admin;
import entities.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminHomeMenuContoller {

	Admin admin; 
	
	
	@FXML
	public void logOut(ActionEvent event) throws IOException, SQLException  {
	
		
		
		 Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml")); 
		 
		 Scene loginScene = new Scene(loginParent); 
		 
		 Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		 
		 window.setScene(loginScene);
		 window.setResizable(false);
		 
		
	}
	
	// Takes you to view my rides screen
		@FXML
		public void viewMyRides(ActionEvent event) throws IOException, SQLException {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ViewMyRides.fxml"));
			
			Parent mainMenu = loader.load();

			ViewMyRidesController vmrc = loader.getController(); 

			//This method set the customer object in book rides controller 
				
			vmrc.passAdminInfo(admin);
			
			Scene mainMenuScene = new Scene(mainMenu);

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(mainMenuScene);
			window.setResizable(false);


		}

		@FXML
		public void bookRides(ActionEvent event) throws IOException, SQLException {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/BookRides.fxml"));
			
			Parent mainMenu = loader.load();

			BookRidesController brc = loader.getController(); 

			//This method set the customer object in book rides controller 
			
			brc.passAdminInfo(admin);
			
			
			Scene mainMenuScene = new Scene(mainMenu);

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(mainMenuScene);
			window.setResizable(false);

		}
		
		public void passAdminInfo(Admin a) {
			
			this.admin = a; 
			
		}
		
		//comment
		@FXML
		public void editRides(ActionEvent event) throws IOException, SQLException {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/EditRides.fxml"));

			Parent mainMenu = loader.load();
			
			EditRidesController erc = loader.getController();
			
			erc.passAdminInfo(admin);
			
			Scene mainMenuScene = new Scene(mainMenu);

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(mainMenuScene);
			window.setResizable(false);
			
		}
	
}
