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
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewMyRidesController implements Initializable {

	private Customer customer;

	private Admin admin;

	@FXML
	private TableView<CustomerSchedule> tableView; // The tableView is expecting BusSchedule objects
	@FXML
	private TableColumn<CustomerSchedule, String> fromColumn;
	@FXML
	private TableColumn<CustomerSchedule, String> toColumn;
	@FXML
	private TableColumn<CustomerSchedule, Date> departureDateColumn;
	@FXML
	private TableColumn<CustomerSchedule, Date> arriavalDateColumn;
	@FXML
	private TableColumn<CustomerSchedule, Timestamp> departureTimeColumn;
	@FXML
	private TableColumn<CustomerSchedule, Timestamp> arrivalTimeColumn;
	@FXML
	private TableColumn<CustomerSchedule, String> numberOfPassengersColumn;
	@FXML
	private TableColumn<CustomerSchedule, String> busCapacity;
	@FXML
	private TableColumn<CustomerSchedule, String> scheduleIDColumn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		tableView.setPlaceholder(new Label(""));

		fromColumn.setCellValueFactory(new PropertyValueFactory<CustomerSchedule, String>("fromStation"));

		toColumn.setCellValueFactory(new PropertyValueFactory<CustomerSchedule, String>("toStation"));

		departureDateColumn.setCellValueFactory(new PropertyValueFactory<CustomerSchedule, Date>("departureDate"));

		arriavalDateColumn.setCellValueFactory(new PropertyValueFactory<CustomerSchedule, Date>("arrivalDate"));

		departureTimeColumn.setCellValueFactory(new PropertyValueFactory<CustomerSchedule, Timestamp>("departureTime"));

		arrivalTimeColumn.setCellValueFactory(new PropertyValueFactory<CustomerSchedule, Timestamp>("arrivalTime"));

		numberOfPassengersColumn
				.setCellValueFactory(new PropertyValueFactory<CustomerSchedule, String>("numberOfPassengers"));

		busCapacity.setCellValueFactory(new PropertyValueFactory<CustomerSchedule, String>("capacity"));

		scheduleIDColumn.setCellValueFactory(new PropertyValueFactory<CustomerSchedule, String>("scheduleID"));

		Platform.runLater(() -> {

			try {

				ObservableList<CustomerSchedule> rides = SQLMethods.getCustomerScheduleInfo(String.valueOf(customer.getSsn()));

				tableView.setItems(rides);

			} catch (NullPointerException e) {

				try {
					ObservableList<CustomerSchedule> rides;
					rides = SQLMethods.getCustomerScheduleInfo(String.valueOf(admin.getSsn()));
					tableView.setItems(rides);

				} catch (SQLException e1) {

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		});

	}


	// deletes a ride from customer schedule
	@FXML
	public void deleteRide() throws IOException {

		if(customer == null && admin != null) {
			
			 deleteAdminRide();
			
		}
		else {
			
			deleteCustomerRide();
			
		}
		
	}

	@FXML
	public void logOut(ActionEvent event) throws IOException, SQLException {

		Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml"));

		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(loginScene);
		window.setResizable(false);

	}

	
	public void deleteCustomerRide() {
		
		ObservableList<CustomerSchedule> allRides, ridesSelected;

		allRides = tableView.getItems();

		ridesSelected = tableView.getSelectionModel().getSelectedItems();

		try {

			// Flags the delete column

			SQLMethods.setDeleteFlag("1", String.valueOf(customer.getSsn()), ridesSelected.get(0).getScheduleID());

			// Updating number of passengers

			int newNumberOfPassengers = Integer.valueOf(ridesSelected.get(0).getNumberOfPassengers()) - 1;

			String scheduleID = ridesSelected.get(0).getScheduleID();

			SQLMethods.updateNumOfPassengers(String.valueOf(newNumberOfPassengers), scheduleID);

			// Updating table view

			ObservableList<CustomerSchedule> rides = SQLMethods.getCustomerScheduleInfo(String.valueOf(customer.getSsn()));

			tableView.setItems(rides);

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
	}
	
	
	
public void deleteAdminRide() {
		
		ObservableList<CustomerSchedule> allRides, ridesSelected;

		allRides = tableView.getItems();

		ridesSelected = tableView.getSelectionModel().getSelectedItems();

		
		try {

			// Flags the delete column

			SQLMethods.setDeleteFlag("1", String.valueOf(admin.getSsn()), ridesSelected.get(0).getScheduleID());

			// Updating number of passengers

			int newNumberOfPassengers = Integer.valueOf(ridesSelected.get(0).getNumberOfPassengers()) - 1;

			String scheduleID = ridesSelected.get(0).getScheduleID();

			SQLMethods.updateNumOfPassengers(String.valueOf(newNumberOfPassengers), scheduleID);

			// Updating table view

			ObservableList<CustomerSchedule> rides = SQLMethods.getCustomerScheduleInfo(String.valueOf(admin.getSsn()));

			tableView.setItems(rides);

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
	}
	
	
	
	
	
	@FXML
	public void home(ActionEvent event) throws IOException, SQLException {

		if (customer == null && admin != null) {

			// Takes you to customer home menu

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/AdminHomeMenu.fxml"));

			Parent mainMenu = loader.load();

			AdminHomeMenuContoller ahmc = loader.getController();

			// This method sets the customer object in home menu controller

			ahmc.passAdminInfo(admin);

			Scene mainMenuScene = new Scene(mainMenu);

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(mainMenuScene);
			window.setResizable(false);

		}

		else {
			// Takes you to customer home menu

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/HomeMenu.fxml"));

			Parent mainMenu = loader.load();

			HomeMenuController hmc = loader.getController();

			// This method sets the customer object in home menu controller

			hmc.passCustomerInfo(customer);

			Scene mainMenuScene = new Scene(mainMenu);

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(mainMenuScene);
			window.setResizable(false);
		}

	}

	public void passCustomerInfo(Customer c) {

		this.customer = c;

	}

	public void passAdminInfo(Admin a) {

		this.admin = a;

	}

}
