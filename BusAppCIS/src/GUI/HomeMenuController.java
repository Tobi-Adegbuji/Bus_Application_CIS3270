package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import entities.Customer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomeMenuController implements Initializable {

	
	@FXML
	Label greet; 
	
	private Customer customer; 
	
	@FXML
	public void logOut(ActionEvent event) throws IOException, SQLException {

		
		Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml"));

		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(loginScene);
		window.setResizable(false);

	}

	// Takes you to view my rides screen
	@FXML
	public void viewMyRides(ActionEvent event) throws IOException, SQLException {

		Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/ViewMyRides.fxml"));

		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(loginScene);
		window.setResizable(false);

	}

	@FXML
	public void bookRides(ActionEvent event) throws IOException, SQLException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/BookRides.fxml"));
		
		Parent mainMenu = loader.load();

		BookRidesController brc = loader.getController(); 

		//This method set the customer object in book rides controller 
		
		brc.passCustomerInfo(customer);
		
		Scene mainMenuScene = new Scene(mainMenu);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(mainMenuScene);
		window.setResizable(false);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		
	}

	public void passCustomerInfo(Customer c) {
		
		this.customer = c; 
		greet.setText("Welcome " + customer.getFirstName()+ ".");
		
	}

	
	

}
