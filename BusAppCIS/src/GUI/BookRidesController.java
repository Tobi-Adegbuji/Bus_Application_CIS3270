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

public class BookRidesController implements Initializable {

	private Customer customer;
	
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


   //first calledd
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

	@FXML
	public void bookRide() throws IOException {

		if(customer == null && admin != null) {
			
			bookAdmin(); 
			
		}
		else {
			
			bookCustomer();
			
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

	
	
	public void bookCustomer() throws IOException{
	
	ObservableList<BusSchedule> allRides, ridesSelected;

	allRides = tableView.getItems();

	ridesSelected = tableView.getSelectionModel().getSelectedItems();

	try {

		int capacity = Integer.valueOf(ridesSelected.get(0).getCapacity());

		int currentNumberOfPassengers = Integer.valueOf(ridesSelected.get(0).getNumberOfPassengers());

		if (currentNumberOfPassengers != capacity) {

			
			// Books Ride
			SQLMethods.bookRide(String.valueOf(customer.getSsn()), ridesSelected.get(0).getScheduleID(),
					ridesSelected.get(0).getNumberOfPassengers(), ridesSelected.get(0).getFromStation(),
					ridesSelected.get(0).getToStation(), ridesSelected.get(0).getArrivalDate(), 
					ridesSelected.get(0).getDepartureDate(), ridesSelected.get(0).getArrivalTime(),
					ridesSelected.get(0).getDepartureTime(), "0");

			// updating number of passengers
			int newNumberOfPassengers = Integer.valueOf(ridesSelected.get(0).getNumberOfPassengers()) + 1;
			String scheduleID = ridesSelected.get(0).getScheduleID();

			SQLMethods.updateNumOfPassengers(String.valueOf(newNumberOfPassengers), scheduleID);

			// Notifying customer they have been booked

			new RideBookedAlertBoxController().display();
			;

			// Updating tableview
			tableView.setItems(getSchedule());

		} else {

			throw new BusIsFullException();

		}

	} catch (BusIsFullException e) {

		 new BusIsFullAlertBoxController().display();


	} catch (java.sql.SQLIntegrityConstraintViolationException e) {

		try {

			if (SQLMethods.isRideDeleted(String.valueOf(customer.getSsn()), ridesSelected.get(0).getScheduleID())) {

				// Updates passenegers again
				int newNumberOfPassengers = Integer.valueOf(ridesSelected.get(0).getNumberOfPassengers()) + 1;
				String scheduleID = ridesSelected.get(0).getScheduleID();

				SQLMethods.updateNumOfPassengers(String.valueOf(newNumberOfPassengers), scheduleID);

				// Updates delete_flag to 0

				SQLMethods.setDeleteFlag("0", String.valueOf(customer.getSsn()), scheduleID);

				new RideBookedAlertBoxController().display();
				}
			else {
				
				new AlreadyScehduledAlertBoxController().display();
				
			}
			
		} catch (SQLException e2) {

			e2.printStackTrace();
		}

	} catch (SQLException e) {

		e.printStackTrace();

	}
	}
	
	
	public void bookAdmin() throws IOException{
		
		ObservableList<BusSchedule> allRides, ridesSelected;

		allRides = tableView.getItems();

		ridesSelected = tableView.getSelectionModel().getSelectedItems();

		try {

			int capacity = Integer.valueOf(ridesSelected.get(0).getCapacity());

			int currentNumberOfPassengers = Integer.valueOf(ridesSelected.get(0).getNumberOfPassengers());

			if (currentNumberOfPassengers != capacity) {

				// Books Ride
				SQLMethods.bookRide(String.valueOf(admin.getSsn()), ridesSelected.get(0).getScheduleID(),
						ridesSelected.get(0).getNumberOfPassengers(), ridesSelected.get(0).getFromStation(),
						ridesSelected.get(0).getToStation(), ridesSelected.get(0).getArrivalDate(),
						ridesSelected.get(0).getDepartureDate(), ridesSelected.get(0).getArrivalTime(),
						ridesSelected.get(0).getDepartureTime(), "0");

				// updating number of passengers
				int newNumberOfPassengers = Integer.valueOf(ridesSelected.get(0).getNumberOfPassengers()) + 1;
				String scheduleID = ridesSelected.get(0).getScheduleID();

				SQLMethods.updateNumOfPassengers(String.valueOf(newNumberOfPassengers), scheduleID);

				// Notifying customer they have been booked

				new RideBookedAlertBoxController().display();
				;

				// Updating tableview
				tableView.setItems(getSchedule());

			} else {

				throw new BusIsFullException();

			}

		} catch (BusIsFullException e) {

			BusIsFullAlertBoxController alert = new BusIsFullAlertBoxController();

			alert.display();

		} catch (java.sql.SQLIntegrityConstraintViolationException e) {

			try {

				if (SQLMethods.isRideDeleted(String.valueOf(admin.getSsn()), ridesSelected.get(0).getScheduleID())) {

					// Updates passenegers again
					int newNumberOfPassengers = Integer.valueOf(ridesSelected.get(0).getNumberOfPassengers()) + 1;
					String scheduleID = ridesSelected.get(0).getScheduleID();

					SQLMethods.updateNumOfPassengers(String.valueOf(newNumberOfPassengers), scheduleID);

					// Updates delete_flag to 0

					SQLMethods.setDeleteFlag("0", String.valueOf(admin.getSsn()), scheduleID);

					new RideBookedAlertBoxController().display();
					}
				else {
					
					new AlreadyScehduledAlertBoxController().display();
					
				}
				
			} catch (SQLException e2) {

				e2.printStackTrace();
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		}
	
	
	
	public void passCustomerInfo(Customer c) {

		this.customer = c;
		System.out.println(this.customer);

	}
	
	public void passAdminInfo(Admin a) {
		
		this.admin = a; 
		
	}
	

}
