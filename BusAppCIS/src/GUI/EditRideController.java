package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.SQLConnection;
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

public class EditRideController implements Initializable {

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

	@FXML
	TextField from;
	@FXML
	TextField to;
	@FXML
	TextField departureDate;
	@FXML
	TextField arrivalDate;
	@FXML
	TextField departureTime;
	@FXML
	TextField arrivalTime;
	@FXML
	TextField busNum;

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
	public void updateRide(ActionEvent event) {

		
		
		try {

			// verify if location is in database
			if (!SQLMethods.verifyLocationExist(from.getText().toUpperCase(), to.getText().toUpperCase())) {

				// displays alert box
				new LocationNotFoundAlertBoxController().display();

				// Regex used to verify correct input
			} else if (!((String) departureDate.getText()).matches("\\d{4}-\\d{2}-\\d{2}")) {

				departureDate.setText("Date format must be: yyyy-mm-dd");

				throw new Exception();

			} else if (!((String) arrivalDate.getText()).matches("\\d{4}-\\d{2}-\\d{2}")) {

				arrivalDate.setText("Date format must be: yyyy-mm-dd");

				throw new Exception();

			} else if (!departureTime.getText().matches("\\d{2}:\\d{2}")) {

				departureTime.setText("Time format must be: HH:mm (MT)");

			} else if (!arrivalTime.getText().matches("\\d{2}:\\d{2}")) {

				arrivalTime.setText("Time format must be: HH:mm (MT)");

			} else if (!SQLMethods.verifyBusID(busNum.getText())) {

				busNum.setText("This bus # doesn't exist");

			} else {

				// Formatting time text field to a DATETIME

				String dTime = formatTime(departureTime.getText(), departureDate.getText());

				String aTime = formatTime(arrivalTime.getText(), arrivalDate.getText());

				SQLMethods.editRide(from.getText(), to.getText(), arrivalDate.getText(), departureDate.getText(),
						aTime, dTime, Integer.parseInt(busNum.getText()), schedule.getScheduleID());
				
				//Takes you back to previous screen
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/EditDeleteAdd.fxml"));

				Parent editDeleteAdd = loader.load();

				EditDeleteAddController edac = loader.getController();

				// This method sets the customer object in home menu controller

				edac.passUpdateNotification("Ride was Updated");

				Scene editDeleteAddScene = new Scene(editDeleteAdd);

				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

				window.setScene(editDeleteAddScene);
				window.setResizable(false);
				

			}
		}
		catch (Exception e) {

			e.printStackTrace();

			System.out.println("Somethings wrong with user input");

		}

	}

	

	@FXML
	public void back(ActionEvent event) throws IOException {

		Parent editDeleteAdd = FXMLLoader.load(getClass().getResource("/GUI/EditDeleteAdd.fxml"));

		Scene editDeleteAddScene = new Scene(editDeleteAdd);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(editDeleteAddScene);

		window.setResizable(false);

	}
	
	// Method used to format time into datetime
		public static String formatTime(String userTime, String date) {

			int n = Integer.parseInt(userTime.substring(0, 2)) + 5;

			switch (n) {

			case 24:
				n = 0;
				break;

			case 25:
				n = 1;
				break;

			case 26:
				n = 2;
				break;

			case 27:
				n = 3;
				break;
			default:
				break;

			}

			// extracting hour
			String hourChange = String.valueOf(n);

			StringBuilder time = new StringBuilder(userTime);

			if (hourChange.length() == 1) {

				time.replace(0, 2, "0" + hourChange);

			} else {

				time.replace(0, 2, hourChange);

			}

			String formattedString = date + " " + time + ":00";

			return formattedString;

		}

	public void passBusScheduleInfo(BusSchedule schedule) {

		this.schedule = schedule;

	}

	public void passBusID(Bus bus) {

		this.bus = bus;

	}
	
	
	
	

}
