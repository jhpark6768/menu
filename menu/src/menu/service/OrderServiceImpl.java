package menu.service;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import menu.DAO.DatabaseService;
import menu.DAO.DatabaseServiceImpl;
import menu.Menu;

public class OrderServiceImpl implements OrderService {
	DatabaseServiceImpl dao = new DatabaseServiceImpl();

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
		menuInfo(orderForm);
		System.out.println();

		if(dao.insert(m)) {
			System.out.println("입력 성공");
			Stage s = (Stage) orderForm.getScene().getWindow();
			s.close();
		}
	}

	private void menuInfo(Parent orderForm) {
		// TODO Auto-generated method stub
		Stage stage = new Stage();
		
		AnchorPane ap = new AnchorPane();
		TableView tableView = new TableView();
		
		TableColumn<Menu, Integer> jj = new TableColumn<>("jj");
		jj.setCellValueFactory(new PropertyValueFactory("jj"));
		TableColumn<Menu, Integer> jb = new TableColumn<>("jb");
		jb.setCellValueFactory(new PropertyValueFactory("jb"));
		TableColumn<Menu, Integer> bb = new TableColumn<>("bb");
		bb.setCellValueFactory(new PropertyValueFactory("bb"));
		TableColumn<Menu, Integer> ts = new TableColumn<>("ts");
		ts.setCellValueFactory(new PropertyValueFactory("ts"));
		TableColumn<Menu, String> place = new TableColumn<>("place");
		place.setCellValueFactory(new PropertyValueFactory("place"));
		TableColumn<Menu, Boolean> use = new TableColumn<>("use");
		use.setCellValueFactory(new PropertyValueFactory("use"));
		TableColumn<Menu, String> pay = new TableColumn<>("pay");
		pay.setCellValueFactory(new PropertyValueFactory("pay"));
		
		tableView.getColumns().addAll(jj,jb,bb,ts,place,use,pay);
		
		List<Menu> menuList = dao.selectAll();
		ObservableList<Menu> data = 
				FXCollections.observableArrayList(menuList);
		tableView.setItems(data);

		ap.getChildren().add(tableView);
		stage.setScene(new Scene(ap,560,200));
		stage.setTitle("주문정보");
		stage.show();
	}
	
	@Override
	public void OrderCancelProc(Parent orderForm) {
		// TODO Auto-generated method stub
		Stage stage = (Stage) orderForm.getScene().getWindow();
		stage.close();

	}
}
