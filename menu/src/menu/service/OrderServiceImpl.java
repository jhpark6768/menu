package menu.service;

import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import menu.DAO.DatabaseService;
import menu.DAO.DatabaseServiceImpl;
import menu.Menu;

public class OrderServiceImpl implements OrderService {
	DatabaseService dao = new DatabaseServiceImpl();

	@Override
	public void OrderProc(Parent orderForm) {
		// TODO Auto-generated method stub
		CommonService cs = new CommonServiceImpl();
		Menu m = new Menu();

		TextField txtFld = (TextField) orderForm.lookup("#txtPlace");
		System.out.println("주소 : " + txtFld.getText());
		if(txtFld.getText().isEmpty()) {
			cs.errorMsg("입력에러", "비어 있는 주소", "주소가 비어있습니다. 입력해주세요.");
			System.out.println("주소가 비어있습니다. 입력해주세요");
			txtFld.requestFocus();
			System.out.println();
			return;
		}

		System.out.println();

		CheckBox chkUse = (CheckBox) orderForm.lookup("#chkUse");
		if(chkUse.isSelected()) {
			System.out.println("일회용품 사용");
			m.setUse(true);
		}else {
			System.out.println("일회용품 사용 안함");
			m.setUse(false);
		}

		System.out.println();

		ComboBox<String> cmbPay = (ComboBox<String>) orderForm.lookup("#cmbPay");

		if(cmbPay.getValue() == null) {
			cs.errorMsg("결제", "결제 방법 선택", "결제 수단이 선택되지 않았습니다.");
			cmbPay.requestFocus();
			return;
		}
		if(cmbPay.getValue().equals("현금 결제")) {
			m.setPay("현금 결제");
		}else if (cmbPay.getValue().equals("신용/체크카드")) {
			m.setPay("신용/체크카드");
		}else if (cmbPay.getValue().equals("휴대폰결제")) {
			m.setPay("휴대폰결제");
		}else if(cmbPay.getValue().equals("네이버페이")) {
			m.setPay("네이버페이");
		}else if(cmbPay.getValue().equals("카카오페이")) {
			m.setPay("카카오페이");
		}else if(cmbPay.getValue().equals("토스")) {
			m.setPay("토스");
		}
		System.out.println(cmbPay.getValue() + "로 결제");
		System.out.println();

		if(dao.insert(m)) {
			System.out.println("입력 성공");
			Stage s = (Stage) orderForm.getScene().getWindow();
			s.close();
		}
	}

	@Override
	public void OrderCancelProc(Parent orderForm) {
		// TODO Auto-generated method stub
		Stage stage = (Stage) orderForm.getScene().getWindow();
		stage.close();

	}
}
