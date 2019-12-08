package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import database.SQLMethods;
import entities.Admin;
import entities.BusSchedule;
import entities.Customer;
import entities.CustomerSchedule;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

	

public class EditRidesController implements Initializable {

	
	Stage window;
	Scene scene;
	
	
	private Admin admin;
	
	
	@FXML
	private TableView<BusSchedule> tableView; // The tableView is expecting BusSchedule objects
	@FXML
	private TableColumn<BusSchedule, String> fromColumn;
	@FXML
	private TableColumn<BusSchedule, String> toColumn;
	@FXML
	private TableColumn<BusSchedule, Date> departureDateColumn;
	@FXML
	private TableColumn<BusSchedule, Date> arriavalDateColumn;
	@FXML
	private TableColumn<BusSchedule, Timestamp> departureTimeColumn;
	@FXML
	private TableColumn<BusSchedule, Timestamp> arrivalTimeColumn;
	@FXML
	private TableColumn<BusSchedule, String> numberOfPassengersColumn;
	@FXML
	private TableColumn<BusSchedule, String> busCapacity;
	@FXML
	private TableColumn<BusSchedule, String> scheduleIDColumn;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		fromColumn.setCellValueFactory(new PropertyValueFactory<BusSchedule, String>("fromStation"));

		toColumn.setCellValueFactory(new PropertyValueFactory<BusSchedule, String>("toStation"));

		departureDateColumn.setCellValueFactory(new PropertyValueFactory<BusSchedule, Date>("departureDate"));

		arriavalDateColumn.setCellValueFactory(new PropertyValueFactory<BusSchedule, Date>("arrivalDate"));

		departureTimeColumn.setCellValueFactory(new PropertyValueFactory<BusSchedule, Timestamp>("departureTime"));

		arrivalTimeColumn.setCellValueFactory(new PropertyValueFactory<BusSchedule, Timestamp>("arrivalTime"));

		numberOfPassengersColumn
				.setCellValueFactory(new PropertyValueFactory<BusSchedule, String>("numberOfPassengers"));

		busCapacity.setCellValueFactory(new PropertyValueFactory<BusSchedule, String>("capacity"));

		scheduleIDColumn.setCellValueFactory(new PropertyValueFactory<BusSchedule, String>("scheduleID"));

		tableView.setItems(getSchedule());

	}
	
	
	public ObservableList<BusSchedule> getSchedule() {

		try {
			return SQLMethods.getBusScheduleInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("It returned Null");
		return null;

	}
	
	
	public void addTrip(ActionEvent event) throws IOException, SQLException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/addTrip"));
		
		
		
		
		
	}
	
	
	
	public void passAdminInfo(Admin a) {

		this.admin = a;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
