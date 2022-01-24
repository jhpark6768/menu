package menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class MenuMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);

		Controller ctrl = loader.getController();
		
		ctrl.setRoot(root);
		
		ComboBox<String> cmbCnt1 = 
				(ComboBox<String>)root.lookup("#cmbCnt1");
		cmbCnt1.getItems().addAll("1 인분", "2 인분", "3 인분", "4 인분");
		
		ComboBox<String> cmbCnt2 = 
				(ComboBox<String>)root.lookup("#cmbCnt2");
		cmbCnt2.getItems().addAll("1 인분", "2 인분", "3 인분", "4 인분");
		
		ComboBox<String> cmbCnt3 = 
				(ComboBox<String>)root.lookup("#cmbCnt3");
		cmbCnt3.getItems().addAll("1 인분", "2 인분", "3 인분", "4 인분");
		
		ComboBox<String> cmbCnt4 = 
				(ComboBox<String>)root.lookup("#cmbCnt4");
		cmbCnt4.getItems().addAll("1 인분", "2 인분", "3 인분", "4 인분");
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("메뉴판");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}