package database;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

import entities.BusSchedule;
import entities.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SQLMethods {

	// HAVE TO CLOSE CONNECTIONS STILL
	//HAVE TO MAKE EVERY METHOD THROW EXCEPTION TO LOGIC PART OF PROJECT(which is the controllers) 
	//Controllers should handle any of the exceptions
	
	
	
	

	// Checks if username and password is in database
	public static boolean verify(String username, String password) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String query = "SELECT * FROM Customer WHERE username = ? AND password = ?";

		preparedStatement = con.prepareStatement(query);

		preparedStatement.setString(1, username);

		preparedStatement.setString(2, password);

		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {

			return true;

		} else {
			return false;

		}
	}

	public static boolean isAdmin(String username) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String query = "SELECT * FROM Customer WHERE username = ? and admin_access = ?";

		preparedStatement = con.prepareStatement(query);

		preparedStatement.setString(1, username);

		preparedStatement.setString(2, "Y");

		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {

			return true;

		} else {
			return false;

		}
	}

	// we need to make
	public static Customer getCustomerInfo(String username) throws SQLException {

		Customer customer;

		Connection con = SQLConnection.connector();
		PreparedStatement preparedStatement;
		ResultSet rs;
		String query = "SELECT * FROM Customer WHERE username = ?";

		preparedStatement = con.prepareStatement(query);

		preparedStatement.setString(1, username);

		rs = preparedStatement.executeQuery();

		if (rs.next()) {

			return customer = new Customer(Integer.parseInt(rs.getString("ssn")), rs.getString("first_name"),
					rs.getString("last_name"), rs.getString("email"), rs.getString("username"),
					rs.getString("password"), rs.getString("address"), rs.getString("city"), rs.getString("state"),
					rs.getString("country"), rs.getString("zip"), rs.getString("security_question"),
					rs.getString("security_answer"), rs.getString("id"), rs.getString("admin_access"));

		} else {
			return null;

		}
	}

	// Retrieves Security Question
	public static String retrieveSecurityQuestion(String username) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String query = "SELECT * FROM Customer WHERE username = ?";

		preparedStatement = con.prepareStatement(query);

		preparedStatement.setString(1, username);

		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {

			return resultSet.getNString(12);

		} else {
			return null;

		}
	}

	// Retrieves Security Answer
	public static String retrieveAnswer(String username) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String query = "SELECT * FROM Customer WHERE username = ?";

		preparedStatement = con.prepareStatement(query);

		preparedStatement.setString(1, username);

		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {

			return resultSet.getNString(13);

		} else {

			System.out.println("There is an issue");

			return null;

		}
	}

	// Updates password

	public static void newPassword(String password, String username) throws Exception {

		Connection con = SQLConnection.connector();
		PreparedStatement ps;
		ResultSet rs;

		String query = "UPDATE Customer SET password = ? WHERE username = ?";
		try {
			ps = con.prepareStatement(query);

			ps.setString(1, password);

			ps.setString(2, username);

			ps.executeUpdate();

			System.out.println("Password was updated.");

		} catch (SQLException e) {

			throw new SQLException();

		} finally {

			con.close();

		}

	}

	// Creates a new customer.
	public static void toRegister(String ssn, String firstName, String lastName, String email, String city,
			String address, String country, String state, String zipcode, String username, String password,
			String securityQuestion, String securityAnswer, String id, String admin_access) throws Exception {

		Connection con = SQLConnection.connector();
		PreparedStatement ps;

		String query = "insert into Customer" + "(ssn" + ",first_name" + ",last_Name" + ",email" + ",username"
				+ ",password" + ",address" + ",city" + ",state" + ",country" + ",zip" + ",security_question"
				+ ",security_answer" + ",id" + ",admin_access" + ")" + "values" + "(?" + ",?" + ",?" + ",?" + ",?"
				+ ",?" + ",?" + ",?" + ",?" + ",?" + ",?" + ",?" + ",?" + ",?" + ",?" + ")";
		try {
			ps = con.prepareStatement(query);

			ps.setString(1, ssn);

			ps.setString(2, firstName);

			ps.setString(3, lastName);

			ps.setString(4, email);

			ps.setString(5, username);

			ps.setString(6, password);

			ps.setString(7, address);

			ps.setString(8, city);

			ps.setString(9, state);

			ps.setString(10, country);

			ps.setString(11, zipcode);

			ps.setString(12, securityQuestion);

			ps.setString(13, securityAnswer);

			ps.setString(14, id);

			ps.setString(15, admin_access);

			ps.executeUpdate();

			System.out.println("User was registered");

		} catch (SQLException e) {

			e.printStackTrace();
			;

		} finally {

			con.close();

		}

	}

	// Returns bus schedule records in an observable list to populate the tableview
	public static ObservableList<BusSchedule> getBusScheduleInfo() throws Exception {

		Connection con = SQLConnection.connector();
		Statement st;
		ResultSet rs;

		ObservableList<BusSchedule> listOfAllRides = FXCollections.observableArrayList();

		String query = "SELECT * FROM Bus_Schedule";

		try {

			st = con.createStatement();

			rs = st.executeQuery(query);

			while (rs.next()) {

				listOfAllRides.add(new BusSchedule(rs.getString("from_station"), rs.getString("to_station"),
						rs.getDate("departure_date"), rs.getDate("arrival_date"), rs.getTimestamp("departure_time"),
						rs.getTimestamp("arrival_time"), rs.getString("passenger_no"),
						getCapacity(rs.getString("bus_ID")), rs.getString("schedule_ID")));

			}

		} finally {

			con.close();
		}

		return listOfAllRides;

	}

	public static String getCapacity(String busID) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String query = "SELECT capacity FROM Bus WHERE bus_ID = ?";

		preparedStatement = con.prepareStatement(query);

		preparedStatement.setString(1, busID);

		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {

			return resultSet.getString(1);

		} else {
			return null;

		}
	}

	
	
	//Inserts new record into customer schedule table
	
	public static void bookRide(String snn, String schedule_ID, String passenger_no, String from_station, String to_station
, Date arrival_date, Date departure_date, Timestamp arrival_time, Timestamp departure_time, String delete_flag ) throws SQLException, java.sql.SQLIntegrityConstraintViolationException {
		
		Connection con = SQLConnection.connector();
		PreparedStatement ps; 
		
		String query = "INSERT INTO Customer_Schedule (SSN, schedule_ID, passenger_no, from_station, to_station, "
				+ "arrival_date, departure_date, arrival_time, departure_time, delete_flag) VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		ps = con.prepareStatement(query);
		
		ps.setString(1, snn);
		ps.setString(2,schedule_ID);
		ps.setString(3,passenger_no);
		ps.setString(4,from_station);
		ps.setString(5 ,to_station);
		ps.setString(6, String.valueOf(arrival_date));
		ps.setString(7, String.valueOf(departure_date));
		ps.setString(8, String.valueOf(arrival_time));
		ps.setString(9, String.valueOf(departure_time));
		ps.setString(10, delete_flag);
		
		ps.executeUpdate(); 
		
		
		ps.close();
		con.close();
		
		
	}

	public void addToCustomerSchedule(ObservableList<BusSchedule> ride) {

	}

}
