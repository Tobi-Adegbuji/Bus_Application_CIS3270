package database;

import java.io.IOException;
import java.sql.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SQLMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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

	
	
	//Retrieves Security Question 
	public static String retrieveSecurityQuestion(String username) throws SQLException {

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
			return null;

		}
	}
	
	
	//Retrieves Security Question 
		public static String retrieveAnswer(String username) throws SQLException {

			Connection con = SQLConnection.connector();
			PreparedStatement preparedStatement;
			ResultSet resultSet;
			String query = "SELECT * FROM Customer WHERE username = ?";

			preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, username);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				return resultSet.getNString(14);

			} else {
				
				System.out.println("There is an issue");
				
				return null;

			}
		}

	//Updates password 
	
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
			String securityQuestion, String securityAnswer, String id) throws Exception {

		Connection con = SQLConnection.connector();
		PreparedStatement ps;
		ResultSet rs;

		String query = "insert into Customer" + "(ssn" + ",firstName" + ",lastName" + ",email" + ",username"
				+ ",password" + ",street" + ",city" + ",state" + ",country" + ",zip" + ",security_question"
				+ ",security_answer" + ",id" + ")" + "values" + "(?" + ",?" + ",?" + ",?" + ",?" + ",?" + ",?" + ",?"
				+ ",?" + ",?" + ",?" + ",?" + ",?" + ",?" + ")";
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

			ps.executeUpdate();

			System.out.println("User was registered");

		} catch (SQLException e) {

			throw new SQLException();

		} finally {

			con.close();

		}

	}

}
