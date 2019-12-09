package database;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

import entities.Admin;
import entities.BusSchedule;
import entities.Customer;
import entities.CustomerSchedule;
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
	// HAVE TO MAKE EVERY METHOD THROW EXCEPTION TO LOGIC PART OF PROJECT(which is
	// the controllers)
	// Controllers should handle any of the exceptions

	// Checks if username and password is in database
	public static boolean verify(String username, String password) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement ps;
		ResultSet resultSet;
		String query = "SELECT * FROM Customer WHERE username = ? AND password = ?";

		try {

			ps = con.prepareStatement(query);

			ps.setString(1, username);

			ps.setString(2, password);

			resultSet = ps.executeQuery();

			if (resultSet.next()) {

				return true;

			} else {
				return false;
			}
		} catch (SQLException e) {

			throw new SQLException();

		} finally {

			con.close();

		}

	}

	public static boolean isAdmin(String username) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement ps;
		ResultSet resultSet;
		String query = "SELECT * FROM Customer WHERE username = ? and admin_access = ?";

		try {
			ps = con.prepareStatement(query);

			ps.setString(1, username);

			ps.setString(2, "Y");

			resultSet = ps.executeQuery();

			if (resultSet.next()) {

				return true;

			} else {
				return false;

			}
		} catch (SQLException e) {

			throw new SQLException();

		} finally {

			con.close();

		}

	}

	public static Customer getCustomerInfo(String username) throws SQLException {

		Customer customer;

		Connection con = SQLConnection.connector();
		PreparedStatement ps;
		ResultSet rs;
		String query = "SELECT * FROM Customer WHERE username = ?";

		try {

			ps = con.prepareStatement(query);

			ps.setString(1, username);

			rs = ps.executeQuery();

			if (rs.next()) {

				return customer = new Customer(Integer.parseInt(rs.getString("ssn")), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"), rs.getString("username"),
						rs.getString("password"), rs.getString("address"), rs.getString("city"), rs.getString("state"),
						rs.getString("country"), rs.getString("zip"), rs.getString("security_question"),
						rs.getString("security_answer"), rs.getString("id"), rs.getString("admin_access"));

			} else {
				return null;

			}
		} catch (SQLException e) {

			throw new SQLException();
		} finally {

			con.close();

		}
	}

	public static Admin getAdminInfo(String username) throws SQLException {

		Admin admin;

		Connection con = SQLConnection.connector();
		PreparedStatement ps;
		ResultSet rs;
		String query = "SELECT * FROM Customer WHERE username = ?";

		try {

			ps = con.prepareStatement(query);

			ps.setString(1, username);

			rs = ps.executeQuery();

			if (rs.next()) {

				return admin = new Admin(Integer.parseInt(rs.getString("ssn")), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"), rs.getString("username"),
						rs.getString("password"), rs.getString("address"), rs.getString("city"), rs.getString("state"),
						rs.getString("country"), rs.getString("zip"), rs.getString("security_question"),
						rs.getString("security_answer"), rs.getString("id"), rs.getString("admin_access"));

			} else {
				return null;

			}
		} catch (SQLException e) {

			throw new SQLException();
		} finally {

			con.close();

		}
	}

	// Retrieves Security Question
	public static String retrieveSecurityQuestion(String username) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement ps;
		ResultSet resultSet;
		String query = "SELECT * FROM Customer WHERE username = ?";

		try {

			ps = con.prepareStatement(query);

			ps.setString(1, username);

			resultSet = ps.executeQuery();

			if (resultSet.next()) {

				return resultSet.getNString(12);

			} else {
				return null;

			}
		} catch (SQLException e) {

			throw new SQLException();

		} finally {

			con.close();

		}
	}

	// Retrieves Security Answer
	public static String retrieveAnswer(String username) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement ps;
		ResultSet resultSet;
		String query = "SELECT * FROM Customer WHERE username = ?";

		try {

			ps = con.prepareStatement(query);

			ps.setString(1, username);

			resultSet = ps.executeQuery();

			if (resultSet.next()) {

				return resultSet.getNString(13);

			} else {

				System.out.println("There is an issue");

				return null;

			}
		} catch (SQLException e) {

			throw new SQLException();

		} finally {

			con.close();

		}

	}

	// Updates password

	public static void newPassword(String password, String username) throws SQLException {

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
			String securityQuestion, String securityAnswer, String id, String admin_access) throws SQLException {

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

			throw new SQLException();

		} finally {

			con.close();

		}

	}

	// Returns bus schedule records in an observable list to populate the tableview
	public static ObservableList<BusSchedule> getBusScheduleInfo() throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement ps;
		ResultSet rs;

		ObservableList<BusSchedule> listOfAllRides = FXCollections.observableArrayList();

		String query = "SELECT * FROM Bus_Schedule WHERE delete_flag = ?";

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

		try {

			ps = con.prepareStatement(query);

			ps.setString(1, "0");
			
			rs = ps.executeQuery();

			while (rs.next()) {

				String departureTime = sdf.format(rs.getTimestamp("departure_time"));
				String arrivalTime = sdf.format(rs.getTimestamp("arrival_time"));

				listOfAllRides.add(new BusSchedule(rs.getString("from_station"), rs.getString("to_station"),
						rs.getDate("departure_date"), rs.getDate("arrival_date"), arrivalTime, departureTime,
						rs.getString("passenger_no"), getCapacity(rs.getString("bus_ID")),
						rs.getString("schedule_ID")));

			}
			return listOfAllRides;

		} catch (SQLException e) {

			e.printStackTrace();
			
			throw new SQLException();

		} finally {

			con.close();
		}

	}

	// Returns customer schedule records in an observable list to populate the
	// customer's already viewed tableview
	public static ObservableList<CustomerSchedule> getCustomerScheduleInfo(String ssn) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement ps;
		ResultSet rs;

		ObservableList<CustomerSchedule> listOfAllRides = FXCollections.observableArrayList();

		String query = "SELECT * FROM Customer_Schedule WHERE SSN = ? AND delete_flag = ?";

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

		try {

			ps = con.prepareStatement(query);

			ps.setString(1, ssn);

			ps.setString(2, "0");

			rs = ps.executeQuery();

			while (rs.next()) {

				listOfAllRides.add(new CustomerSchedule(rs.getString("from_station"), rs.getString("to_station"),
						rs.getDate("departure_date"), rs.getDate("arrival_date"), rs.getString("arrival_time"),
						rs.getString("departure_time"), rs.getString("passenger_no"),
						getCapacity(getBusID(rs.getString("schedule_ID"))), rs.getString("schedule_ID")));

			}
			return listOfAllRides;

		} catch (SQLException e) {

			e.printStackTrace();

			throw new SQLException();

		} finally {

			con.close();
		}

	}

	public static String getCapacity(String busID) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String query = "SELECT capacity FROM Bus WHERE bus_ID = ?";

		try {

			preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, busID);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				return resultSet.getString(1);

			} else {
				return null;

			}
		} catch (SQLException e) {

			throw new SQLException();

		} finally {

			con.close();

		}

	}

	public static String getBusID(String scheduleID) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String query = "SELECT bus_ID FROM Bus_Schedule WHERE schedule_ID = ?";

		try {

			preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, scheduleID);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				return resultSet.getString(1);

			} else {

				return null;

			}
		} catch (SQLException e) {

			throw new SQLException();

		} finally {

			con.close();

		}
	}

	// Inserts new record into customer schedule table

	public static void bookRide(String snn, String schedule_ID, String passenger_no, String from_station,
			String to_station, Date arrival_date, Date departure_date, String arrival_time, String departure_time,
			String delete_flag) throws SQLException, java.sql.SQLIntegrityConstraintViolationException {

		Connection con = SQLConnection.connector();
		PreparedStatement ps;

		String query = "INSERT INTO Customer_Schedule (SSN, schedule_ID, passenger_no, from_station, to_station, "
				+ "arrival_date, departure_date, arrival_time, departure_time, delete_flag) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {

			ps = con.prepareStatement(query);

			ps.setString(1, snn);
			ps.setString(2, schedule_ID);
			ps.setString(3, passenger_no);
			ps.setString(4, from_station);
			ps.setString(5, to_station);
			ps.setString(6, String.valueOf(arrival_date));
			ps.setString(7, String.valueOf(departure_date));
			ps.setString(8, arrival_time);
			ps.setString(9, departure_time);
			ps.setString(10, delete_flag);

			ps.executeUpdate();

		} catch (java.sql.SQLIntegrityConstraintViolationException e) {

			throw new java.sql.SQLIntegrityConstraintViolationException();

		} finally {

			con.close();

		}
	}

	public static void updateNumOfPassengers(String passengerNum, String schedule_ID) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement ps;
		PreparedStatement ps2;

		String query = "UPDATE Bus_Schedule SET passenger_no = ? WHERE schedule_ID = ?";
		String query2 = "UPDATE Customer_Schedule SET passenger_no = ? WHERE schedule_ID = ?";

		try {

			ps = con.prepareStatement(query);

			ps2 = con.prepareStatement(query2);

			ps.setString(1, passengerNum);

			ps.setString(2, schedule_ID);

			ps2.setString(1, passengerNum);

			ps2.setString(2, schedule_ID);

			ps.executeUpdate();

			ps2.executeUpdate();

		} catch (SQLException e) {

			throw new SQLException();

		} finally {

			con.close();

		}

	}

	public static void setDeleteFlag(String deleteFlag, String ssn, String scheduleID) throws SQLException {

		Connection con = SQLConnection.connector();

		PreparedStatement ps;

		String query = " UPDATE Customer_Schedule SET delete_flag = ? WHERE SSN = ? and schedule_ID = ?";

		try {

			ps = con.prepareStatement(query);

			ps.setString(1, deleteFlag);

			ps.setString(2, ssn);

			ps.setString(3, scheduleID);

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

			throw new SQLException();

		} finally {

			con.close();

		}

	}

	public static boolean isRideDeleted(String ssn, String scheduleID) throws SQLException {

		Connection con = SQLConnection.connector();

		PreparedStatement ps;

		ResultSet rs;

		String query = "SELECT delete_flag FROM Customer_Schedule WHERE SSN = ? AND schedule_ID = ? ";

		try {

			ps = con.prepareStatement(query);

			ps.setString(1, ssn);

			ps.setString(2, scheduleID);

			rs = ps.executeQuery();

			rs.next();

			if (rs.getString("delete_flag").equals("1")) {

				return true;

			} else {

				return false;

			}

		} catch (SQLException e) {

			e.printStackTrace();

			throw new SQLException();

		} finally {

			con.close();

		}

	}

	public static void addBusRide(String from, String to, String departureDate, String arrivalDate,
			String departureTime, String arrivalTime, String busID) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement ps;

		String query = "INSERT INTO Bus_Schedule( bus_ID, passenger_no, from_station, to_station, arrival_date, "
				+ "departure_date, arrival_time, departure_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			ps = con.prepareStatement(query);

			ps.setString(1, busID);
			ps.setString(2, "0");
			ps.setString(3, from.toUpperCase());
			ps.setString(4, to.toUpperCase());
			ps.setString(5, String.valueOf(arrivalDate));
			ps.setString(6, String.valueOf(departureDate));
			ps.setString(7, arrivalTime);
			ps.setString(8, departureTime);

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

			throw new SQLException();

		} finally {

			con.close();

		}
	}

	public static boolean verifyLocationExist(String from, String to) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement ps;
		PreparedStatement ps2;
		ResultSet rs;
		ResultSet rs2;

		String query = "SELECT station_name FROM Bus_Station WHERE station_name = ?";
		String query2 = "SELECT station_name FROM Bus_Station WHERE station_name = ?";

		try {

			ps = con.prepareStatement(query);

			ps2 = con.prepareStatement(query2);

			ps.setString(1, from);

			ps2.setString(1, to);

			rs = ps.executeQuery();
			rs2 = ps2.executeQuery();

			if (rs.next() && rs2.next())
				return true;

			else
				return false;

		} catch (SQLException e) {

			e.printStackTrace();

			throw new SQLException();

		} finally {

			con.close();

		}

	}

	public static Boolean verifyBusID(String busNum) throws SQLException {

		Connection con = SQLConnection.connector();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String query = "SELECT bus_ID FROM Bus WHERE bus_ID = ?";

		try {

			preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, busNum);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				return true;

			} else {

				return false;

			}
		} catch (SQLException e) {

			throw new SQLException();

		} finally {

			con.close();

		}
	}
	
	public static void deleteBusRide(String id) throws SQLException {
		
		Connection con = SQLConnection.connector();
		PreparedStatement ps;
		String query = "UPDATE Bus_Schedule SET delete_flag = ? WHERE schedule_ID = ?";
		
		try {
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, "1");
			ps.setString(2, id);
			
			ps.executeUpdate(); 
			
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			
			throw new SQLException();
		}
		finally {
			
			con.close();
			
		}
		
		
	}

	
	public static void setDeleteFlagAsAdmin(String scheduleID) throws SQLException {

		Connection con = SQLConnection.connector();

		PreparedStatement ps;

		String query = " UPDATE Customer_Schedule SET delete_flag = ? WHERE schedule_ID = ?";

		try {

			ps = con.prepareStatement(query);

			ps.setString(1, "1");

			ps.setString(2, scheduleID);

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

			throw new SQLException();

		} finally {

			con.close();

		}

	}
		
	

}
