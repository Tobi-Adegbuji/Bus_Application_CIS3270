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
	
	// Action for logout Button
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
		// action for book rides button, sends to book rides page
		@FXML
		public void bookRides(ActionEvent event) throws IOException, SQLException {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/BookRides.fxml"));
			
			Parent mainMenu = loader.load();

			BookRidesController brc = loader.getController(); 

			//This method set the customer object in book rides controller 
			
			System.out.println(admin.getPassword());
			
			brc.passAdminInfo(admin);
			
			
			Scene mainMenuScene = new Scene(mainMenu);

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(mainMenuScene);
			window.setResizable(false);

		}
		// action for edit rides button, sends to edit ride page
		@FXML
		public void editRides(ActionEvent event) throws IOException, SQLException {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/EditDeleteAdd.fxml"));
			
			Parent mainMenu = loader.load();

			EditDeleteAddController edac = loader.getController(); 

			//This method set the customer object in book rides controller 
			
			edac.passAdminInfo(admin);
			
			
			Scene mainMenuScene = new Scene(mainMenu);

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(mainMenuScene);
			window.setResizable(false);

		}
		
	
		// method to pass admin object
		public void passAdminInfo(Admin a) {
			
			this.admin = a; 
			
		}
		
		//comment
		
	
}
