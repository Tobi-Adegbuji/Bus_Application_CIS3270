package GUI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.SQLConnection;
import database.SQLMethods; //
import javafx.event.ActionEvent;
import javafx.fxml.FXML; //
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField; //
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RegisterController {

	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField email;
	@FXML
	private TextField city;
	@FXML
	private TextField address;
	@FXML
	private TextField country;
	@FXML
	private TextField state;
	@FXML
	private TextField zipcode;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private TextField securityQuestion;
	@FXML
	private TextField securityAnswer;
	@FXML
	private TextField ssn;

	// Takes you back to login
	@FXML
	public void backToLogin(ActionEvent event) throws IOException, SQLException {

		Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml"));

		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(loginScene);
		window.setResizable(false);

	}

	@FXML
	public void complete(ActionEvent event) throws IOException, SQLException {

		register();

		Parent loginParent = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml"));

		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(loginScene);
		window.setResizable(false);

	}

	// Checks page
	public void register() {

		try {

			SQLMethods.toRegister(ssn.getText(), firstName.getText(), lastName.getText(), email.getText(),
					city.getText(), address.getText(), country.getText(), state.getText(), zipcode.getText(),
					username.getText(), password.getText(), securityQuestion.getText(), securityAnswer.getText(),
					"1000", "N");

			System.out.println("Complete");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("There is an issue");

		}

	}

}
