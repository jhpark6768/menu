package menu;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import menu.service.CommonService;
import menu.service.CommonServiceImpl;
import menu.service.MenuService;
import menu.service.MenuServiceImpl;
import menu.service.OrderService;
import menu.service.OrderServiceImpl;

public class Controller {
	private Parent menuForm;
	private Parent orderForm;
	private OrderService os;
	private MenuService ms;
	private CommonService cs;
	
	public Controller (){
		os = new OrderServiceImpl();
		ms = new MenuServiceImpl();
		cs = new CommonServiceImpl();
	}

	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.menuForm = root;
	}
	
	public void setOrderForm(Parent orderForm) {
		// TODO Auto-generated method stub
		this.orderForm = orderForm;
	}
	
	public void MenuProc() {
		ms.MenuProc(menuForm);
	}
	
	public void CancelProc(ActionEvent event) {
		cs.windowClose(event);
	}
	
	public void OrderProc() {
		os.OrderProc(orderForm);
	}
	

}