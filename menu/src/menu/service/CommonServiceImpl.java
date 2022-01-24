package menu.service;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommonServiceImpl implements CommonService {

	@Override
	public void CancelProc(Parent root) {
		// TODO Auto-generated method stub

		Stage stage = (Stage) root.getScene().getWindow();
		stage.close();

	}

	@Override
	public void errorMsg(String title, String headerStr, String contextStr) {
		// TODO Auto-generated method stub
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerStr);
		alert.setContentText(contextStr);
		alert.showAndWait();
	}

}