package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.SQLMethods;
import entities.Admin;
import entities.Bus;
import entities.BusSchedule;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditRideController implements Initializable{

	private Admin admin;
	
	private BusSchedule schedule; 
	
	private Bus bus; 

	@FXML
	Label labelFrom;
	@FXML
	Label labelTo;
	@FXML
	Label labelDepartureDate;
	@FXML
	Label labelArrivalDate;
	@FXML
	Label labelDepartureTime;
	@FXML
	Label labelArrivalTime;
	@FXML
	Label labelBusNum;
	
	@FXML TextField from; 
	@FXML TextField to; 
	@FXML TextField departureDate; 
	@FXML TextField arrivalDate; 
	@FXML TextField departureTime; 
	@FXML TextField arrivalTime; 
	@FXML TextField busNum; 
	
	
	
	// used to pass admin object
		public void passAdminInfo(Admin a) {

			this.admin = a;

		}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Platform.runLater(() -> {
		
		labelFrom.setText(schedule.getFromStation());
		labelTo.setText(schedule.getToStation());
		labelDepartureDate.setText(String.valueOf(schedule.getDepartureDate()));
		labelArrivalDate.setText(String.valueOf(schedule.getArrivalDate()));
		labelDepartureTime.setText(schedule.getDepartureTime());
		labelArrivalTime.setText(schedule.getArrivalTime());
		labelBusNum.setText(String.valueOf(bus.getBusID()));
		});
	}
		
	
	
	@FXML
	public void updateRide() {
		
		try {
			SQLMethods.editRide(from.getText(), to.getText(), arrivalDate.getText(), departureDate.getText(), 
					arrivalTime.getText(), departureTime.getText(), Integer.parseInt(busNum.getText()));
		} catch (NumberFormatException e) {
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML 
	public void back(ActionEvent event) {
		
		
	}
		
	
	public void passBusScheduleInfo(BusSchedule schedule) {

		this.schedule = schedule;

	}
	
	public void passBusID(Bus bus) {
		
		this.bus = bus; 
		
	}
		

}
