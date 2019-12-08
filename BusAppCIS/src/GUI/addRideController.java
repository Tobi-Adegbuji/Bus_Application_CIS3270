package GUI;

import database.SQLMethods;
import entities.Admin;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.SQLConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class addRideController {
	
	
	
	@FXML
	private TextField fromStation;
	@FXML
	private TextField toStation;
	@FXML
	private TextField arrivalDate;
	@FXML
	private TextField departureDate;
	@FXML
	private TextField arrivalTime;
	@FXML
	private TextField departureTime;
	@FXML
	private TextField numberOfPassengers;
	@FXML
	private TextField capacity;
	@FXML
	private TextField scheduleID;

	Admin admin; 

	public void passAdminInfo(Admin a) {
		
		this.admin = a; 
		
	}
	
	
	
	public void addRide() {
		
		
		try {
			
			SQLMethods.toBusSchedule(fromStation.getText(), toStation.getText(), arrivalDate.getText(), 
					departureDate.getText(), arrivalTime.getText(), departureTime.getText(), numberOfPassengers.getText(), capacity.getText(), scheduleID.getText());
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("There is an issue");
		}
		
		
		
	}
	
	@FXML 
	public void create(ActionEvent event) throws IOException, SQLException {
		
		addRide();
		
		Parent editRidesParent = FXMLLoader.load(getClass().getResource("/GUI/EditRides.fxml")); 
		
		Scene editRidesScene = new Scene(editRidesParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(editRidesScene);
		window.setResizable(false);
		
		
	}
	
	@FXML
	public void backToEdit(ActionEvent event) throws IOException, SQLException {
		
		Parent editRidesParent = FXMLLoader.load(getClass().getResource("/GUI/EditRides.fxml"));

		Scene editRidesScene = new Scene(editRidesParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(editRidesScene);
		window.setResizable(false);
		
	}
	
	
	
}
