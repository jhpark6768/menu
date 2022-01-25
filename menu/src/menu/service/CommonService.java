package menu.service;

import javafx.event.ActionEvent;

public interface CommonService {
	public void errorMsg(String title, String headerStr, String contextStr);
	public void windowClose(ActionEvent event);
}