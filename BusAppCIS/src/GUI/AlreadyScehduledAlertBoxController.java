package GUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AlreadyScehduledAlertBoxController {


	
	
	
public void display() throws IOException {
	
	Stage stage = new Stage();
	
	stage.initStyle(StageStyle.UNIFIED);
	
	stage.initModality(Modality.APPLICATION_MODAL);

	Parent parent = FXMLLoader.load(getClass().getResource("/GUI/AlreadyScheduledAlertBox.fxml"));
	
	Scene scene = new Scene(parent);

	stage.setResizable(false);

	stage.setScene(scene);

	stage.showAndWait();

	
}
	
}
