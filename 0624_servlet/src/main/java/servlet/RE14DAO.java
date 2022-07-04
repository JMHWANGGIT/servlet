package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RE14DAO {
	
	public RE14DAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}//constructor (생성자) 
	
	Connection con;
	PreparedStatement psmt;
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	final String USER = "c##scott";
	final String PASSWORD = "tiger"; 
	//final : 변수의 상수화 : 한번 값을 대입하면 다시는 값을 바꾸지 못한다. 
	
	public int insertMember(MemberDTO dto) {
		int successCount = 0;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD); 
			//DriverManager : 오라클 driver를 여러번 호출해도 한번만 정의할수 있게끔 제어하는 역할 
			String sql = "insert into member(mno, mid, mpwd"
					+ ", tel1, tel2, tel3, email1, email2, mdate) values("
					+ "mno_seq.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getMid());
			psmt.setString(2, dto.getMpwd());
			psmt.setString(3, dto.getTel1());
			psmt.setString(4, dto.getTel2());
			psmt.setString(5, dto.getTel3());
			psmt.setString(6, dto.getEmail1());
			psmt.setString(7, dto.getEmail2());
			
			successCount = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
			psmt.close();
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}//finally
		
		return successCount;
	}//insertMember

}//class
