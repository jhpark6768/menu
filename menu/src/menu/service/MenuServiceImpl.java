package menu.service;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import menu.DAO.DatabaseServiceImpl;
import menu.Controller;
import menu.Menu;

public class MenuServiceImpl implements MenuService {
	DatabaseServiceImpl dao = new DatabaseServiceImpl();
		
	@Override
	public void MenuProc(Parent menuForm) {
		// TODO Auto-generated method stub
		OrderServiceImpl os = new OrderServiceImpl();
		
		Stage OrderForm = new Stage();

		Parent order = null;
		
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/menu/Order.fxml"));

		try {
			order = loader.load();
			OrderForm.setScene(new Scene(order));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Controller ctrl = loader.getController();
		ctrl.setOrderForm(order);

		ComboBox<String> cmbPay = (ComboBox<String>)order.lookup("#cmbPay");
		cmbPay.getItems().addAll("현금 결제", "신용/체크카드", "휴대폰결제", "네이버페이", "카카오페이", "토스");
		
		OrderForm.setTitle("주문창");
		OrderForm.show();
	
		CommonService cs = new CommonServiceImpl();
		Menu m = new Menu();
		int num = 0;
		
		if(((CheckBox)menuForm.lookup("#chkjj")).isSelected()) {
			ComboBox<String> cmbCnt1 = 
					(ComboBox<String>)menuForm.lookup("#cmbCnt1");
			if(cmbCnt1.getValue() == null) {
				cs.errorMsg("수량", "수량 선택", "짜장면 수량이 선택 되지 않았습니다.");
				return;
			}
			
			else if(cmbCnt1.getValue().equals("1 인분")) {
				m.setJj(1);
			}
			else if(cmbCnt1.getValue().equals("2 인분")) {
				m.setJj(2);
			}
			else if(cmbCnt1.getValue().equals("3 인분")) {
				m.setJj(3);
			}
			else if(cmbCnt1.getValue().equals("4 인분")) {
				m.setJj(4);
			}
			
			System.out.println("짜장면 "+ m.getJj() +"인분");
			num += m.getJj()*4000;
			
		}

		if(((CheckBox)menuForm.lookup("#chkjb")).isSelected()) {
			ComboBox<String> cmbCnt2 = 
					(ComboBox<String>)menuForm.lookup("#cmbCnt2");
			if(cmbCnt2.getValue() == null) {
				cs.errorMsg("수량", "수량 선택", "짬뽕 수량이 선택 되지 않았습니다.");
				return;
			}
			
			else if(cmbCnt2.getValue().equals("1 인분")) {
				m.setJb(1);
			}
			else if(cmbCnt2.getValue().equals("2 인분")) {
				m.setJb(2);
			}
			else if(cmbCnt2.getValue().equals("3 인분")) {
				m.setJb(3);
			}
			else if(cmbCnt2.getValue().equals("4 인분")) {
				m.setJb(4);
			}
			
			System.out.println("짬뽕 "+ m.getJb() +"인분");
			num += m.getJb()*5000;
			
		}
		if(((CheckBox)menuForm.lookup("#chkbb")).isSelected()) {
			ComboBox<String> cmbCnt3 = 
					(ComboBox<String>)menuForm.lookup("#cmbCnt3");
			if(cmbCnt3.getValue() == null) {
				cs.errorMsg("수량", "수량 선택", "볶음밥 수량이 선택 되지 않았습니다.");
				return;
			}
			
			else if(cmbCnt3.getValue().equals("1 인분")) {
				m.setBb(1);
			}
			else if(cmbCnt3.getValue().equals("2 인분")) {
				m.setBb(2);
			}
			else if(cmbCnt3.getValue().equals("3 인분")) {
				m.setBb(3);
			}
			else if(cmbCnt3.getValue().equals("4 인분")) {
				m.setBb(4);
			}
			
			System.out.println("볶음밥 "+ m.getBb() +"인분");
			num += m.getBb()*5000;
		}
		if(((CheckBox)menuForm.lookup("#chkts")).isSelected()) {
			ComboBox<String> cmbCnt4 = 
					(ComboBox<String>)menuForm.lookup("#cmbCnt4");
			if(cmbCnt4.getValue() == null) {
				cs.errorMsg("수량", "수량 선택", "탕수육 수량이 선택 되지 않았습니다.");
				return;
			}
			else if(cmbCnt4.getValue().equals("1 인분")) {
				m.setTs(1);
			}
			else if(cmbCnt4.getValue().equals("2 인분")) {
				m.setTs(2);
			}
			else if(cmbCnt4.getValue().equals("3 인분")) {
				m.setTs(3);
			}
			else if(cmbCnt4.getValue().equals("4 인분")) {
				m.setTs(4);
			}
			
			System.out.println("탕수육 "+ m.getTs() +"인분");
			num += m.getTs()*12000;
		}
		
		System.out.println("총 금액:" + num +"원");
		
		//값 전달이 없음
		os.m  = m;
	}
	
}