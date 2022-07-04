package login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.dto.Member2DTO;

public class Login2DAO {

	
	private final String URL ="jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER ="c##scott";
	private final String PASSWRD ="tiger";
	
	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public Login2DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//Login2DAO
	
	
	public int loginCheck(Member2DTO dto) throws SQLException{
		String sql = "select count(mid) cnt from member where mid=? and mpwd=?";
		int loginYN = 0;
		con = DriverManager.getConnection(URL, USER, PASSWRD);
		psmt = con.prepareStatement(sql);
		psmt.setString(1, dto.getMid());
		psmt.setString(2, dto.getMpwd());
		
		rs = psmt.executeQuery();
		rs.next();
		loginYN = rs.getInt("cnt");
		
		rs.close();
		psmt.close();
		con.close();
		
		return loginYN;
	}//loginCheck

}
