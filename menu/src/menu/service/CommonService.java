package menu.service;

import javafx.scene.Parent;

public interface CommonService {
	public void CancelProc(Parent root);
	public void errorMsg(String title, String headerStr, String contextStr);
}