package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import database.SQLMethods;
import entities.Admin;
import entities.BusSchedule;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class EditDeleteAddController implements Initializable {

	private Admin admin;

	@FXML
	private TextField from;
	@FXML
	private TextField to;
	@FXML
	private TextField departureDate;
	@FXML
	private TextField arrivalDate;
	@FXML
	private TextField departureTime;
	@FXML
	private TextField arrivalTime;
	@FXML
	private TextField busNum;

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

	// first calledd
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
	public void addRide() {
		
		try {
			
			
			if(!SQLMethods.verifyLocationExist(from.getText(), to.getText())) {
				
				throw new SQLException();
			
			}
			else if(!((String) departureDate.getText()).matches("\\d{4}-\\d{2}-\\d{2}")) {
				
				departureDate.setText("Date format must be: yyyy-mm-dd");
				
				throw new Exception(); 
				
			}
			else if(!((String) arrivalDate.getText()).matches("\\d{4}-\\d{2}-\\d{2}")) {
				
				departureDate.setText("Date format must be: yyyy-mm-dd");
				
				throw new Exception();
				
			}
			
			
			SQLMethods.addBusRide(from.getText(), to.getText(), departureDate.getText(), arrivalDate.getText(),
					departureTime.getText(), arrivalTime.getText(), busNum.getText());
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
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

	public void passAdminInfo(Admin a) {

		this.admin = a;

	}

}
