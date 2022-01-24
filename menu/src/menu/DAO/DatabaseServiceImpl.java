package menu.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import menu.Menu;
import menu.DAO.DatabaseService;
import menu.service.CommonService;
import menu.service.CommonServiceImpl;

public class DatabaseServiceImpl implements DatabaseService {

	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	CommonService cs = new CommonServiceImpl();

	public DatabaseServiceImpl() {

		// TODO Auto-generated constructor stub
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "system";
		String pass = "oracle";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("연결");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 등록 실패");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {	
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("연결");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean insert(Menu m) {
		// TODO Auto-generated method stub
		String u = getUse(m.isUse());

		//아이디 중복 체크
		//chkId가 true일 때
		String sql = "insert into member values(sq2.NEXTVAL,?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m.getJj());
			pstmt.setInt(2, m.getJb());
			pstmt.setInt(3, m.getBb());
			pstmt.setInt(4, m.getTs());
			pstmt.setString(5, m.getPlace());
			pstmt.setString(6, u);
			pstmt.setString(7, m.getPay());

			int result = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

@Override
public String getUse(boolean use) {
	// TODO Auto-generated method stub
	if(use) {
		return "사용";
	}
	return "사용안함";
}

}