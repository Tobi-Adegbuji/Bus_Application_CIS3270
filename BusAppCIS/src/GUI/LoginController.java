package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import database.SQLConnection;
import database.SQLMethods;
import entities.Admin;
import entities.Customer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.scene.Node;

public class LoginController extends Application implements Initializable {

	@FXML
	public TextField user;

	@FXML
	private PasswordField pass;

	@FXML
	private Label notify = new Label();

	@FXML
	private Label isConnected;
	
	Connection connection = SQLConnection.connector();

	Stage window;

	// Main Method
	public static void main(String[] args) {
		launch(args);
	}

	// LOADS THE LOGIN SCREEN 
	@Override
	public void start(Stage window) throws IOException {

		this.window = window;

		Parent root = FXMLLoader.load(getClass().getResource("/GUI/login.fxml")); // WHERE GUI IS DESIGNED
																					// (SceneBuilder)
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/GUI/application.css").toExternalForm());
		window.setScene(scene);
		window.setResizable(false);
		window.setTitle("Edge Xpress");
		window.show();

	}

	// CHECKS IF DATABSE IS CONNECTED
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			if (isDBConnected()) {
				isConnected.setText("Status: Connected");
			} else {
				isConnected.setText("Status: Not Connected");
			}
		} catch (Exception e) {

			e.printStackTrace();

			isConnected.setText("Status: Not Connected");

		}

	}

	// LEADS TO HOME MENU

	@FXML
	public void login(ActionEvent event) throws IOException, SQLException {

		
		if (SQLMethods.verify(user.getText(), pass.getText())) {

			if (SQLMethods.isAdmin(user.getText())) { // Checks if user has admin access in database

				FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/AdminHomeMenu.fxml"));
				
				Parent mainMenu = loader.load();
 
				AdminHomeMenuContoller ahmc = loader.getController();
				
				//sets the admin object in admin home menu controller  
				ahmc.passAdminInfo(createAdmin());
				
				Scene mainMenuScene = new Scene(mainMenu);

				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

				window.setScene(mainMenuScene);
				window.setResizable(false);

			} else {

				
				// Takes you to customer home menu
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/HomeMenu.fxml"));
				
				Parent mainMenu = loader.load();
 
				HomeMenuController hmc = loader.getController(); 

				//This method sets the customer object in home menu controller  
				
				hmc.passCustomerInfo(createCustomer());
				
				Scene mainMenuScene = new Scene(mainMenu);

				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

				window.setScene(mainMenuScene);
				window.setResizable(false);
			}
		} else {

			notify.setText("Invalid Username or Password");

		}
		
		
	}

	// Retrieves a customers information so it can be passed from scene to scene
	public Customer createCustomer() {

		try {
			return SQLMethods.getCustomerInfo(user.getText());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	// Retrieves admin information temporarily
	public Admin createAdmin() {

		try {
			return SQLMethods.getAdminInfo(user.getText());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	// TAKES YOU TO SIGNUP PAGE

	@FXML
	public void register(ActionEvent event) throws IOException, SQLException {

		Parent registerParent = FXMLLoader.load(getClass().getResource("/GUI/Register.fxml"));

		Scene registerScene = new Scene(registerParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(registerScene);

		window.setResizable(false);

	}

	// TAKES YOU TO PASSWORD RECOVERY
	@FXML
	public void forgotPassword(MouseEvent event) throws IOException, SQLException {

		Parent registerParent = FXMLLoader.load(getClass().getResource("/GUI/ForgotPassword.fxml"));

		Scene registerScene = new Scene(registerParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(registerScene);

		window.setResizable(false);

	}

	public Label getNotify() {
		return notify;
	}
	
public boolean isDBConnected() throws NullPointerException{
		
		try {
			return !connection.isClosed(); //simply returns true if connection is closed
		} catch (SQLException e) {
			e.printStackTrace();
			return false; 
		} 
		
	}
	
	
	                    
	                    

}
