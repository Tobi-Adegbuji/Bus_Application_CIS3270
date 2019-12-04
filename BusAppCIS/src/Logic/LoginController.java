package Logic;


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
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;

public class LoginController extends Application implements Initializable {

	@FXML
	public TextField user;

	@FXML
	public PasswordField pass;

	@FXML
	public Label notify; 
	
	@FXML
	public Label isConnected;
	
	LoginModel loginModel = new LoginModel(); 

	Stage window;

	public static void main(String[] args) {
		launch(args);
	}

	
	//LOADS THE LOGIN SCREEN (will probably have to load splash screen first instead of login) 
	@Override
	public void start(Stage window) throws IOException {

		this.window = window;

		Parent root = FXMLLoader.load(getClass().getResource("/GUI/login.fxml")); // WHERE GUI IS DESIGNED (SceneBuilder) 
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/GUI/application.css").toExternalForm());
		window.setScene(scene);
		window.setResizable(false);
		window.setTitle("Edge Xpress Login");
		window.show();

	}

	
	//CHECKS IF DATABSE IS CONNECTED
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
		if (loginModel.isDBConnected()) {
			isConnected.setText("Status: Connected");
		} else {
			isConnected.setText("Status: Not Connected");
		}}
		catch(Exception e) {
			
			e.printStackTrace();
			
			isConnected.setText("Status: Not Connected");

		}

	}

	// LEADS TO HOME MENU 

	@FXML
	public void login(ActionEvent event) throws IOException, SQLException {

		
		
		//You can use username for username and password for password to login
		System.out.println(SQLMethods.verify(user.getText(),pass.getText()));
		
		if(SQLMethods.verify(user.getText(),pass.getText())) {
			
			Parent mainMenu = FXMLLoader.load(getClass().getResource("/GUI/HomeMenu.fxml")); //LOADS NEW FXML DOCUMENT INTO mainMenu

			Scene mainMenuScene = new Scene(mainMenu); //This puts mainMenu control into new scene

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); //Getting the current window being used

			window.setScene(mainMenuScene); //putting a new scene into the current window
			window.setResizable(false); //Allows size of window to be resized if user wants 
			
		}
		else {
			
			notify.setText("Invalid Username or Password");
			

			
		}
		
		
		

	}

	//CHECKS IF USERNAME AND PASSWORD IS IN DATABASE
	
	
	
	
	//-------------
	
	
	//TAKES YOU TO SIGNUP PAGE
	
	@FXML
	public void register(ActionEvent event) throws IOException, SQLException  {
	
		
		
		 Parent registerParent = FXMLLoader.load(getClass().getResource("/GUI/Register.fxml")); 
		 
		 Scene registerScene = new Scene(registerParent); 
		 
		 Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		 
		 
		 window.setScene(registerScene);
		 
		 
		 window.setResizable(false);
		 
		
	}
	
	

}
