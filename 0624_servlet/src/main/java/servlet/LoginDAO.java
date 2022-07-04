package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
	public LoginDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//constructor
	
	private final String URL ="jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER ="c##scott";
	private final String PASSWORD ="tiger";
	
	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	//id만 체크(유효한 아이디인지 먼저 체크)
	public int idCheck(MemberDTO dto) throws SQLException{
		String sql = "select count(mid) from member where mid=?";
		//결과값이 0 : 아이디가 없다.  /  결과값이 1 : 아이디가 있다. 
		int result = 0;
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		psmt = con.prepareStatement(sql);
		psmt.setString(1, dto.getMid());
		rs = psmt.executeQuery();
		
		rs.next();
		result = rs.getInt(1);//결과의 첫번째 컬럼을 int값으로 가져온다. 
		rs.close();
		psmt.close();
		con.close();
		return result;
	}//idCheck
	
	
	//id와 pwd 체크 (유효한 id의 패스워드까지 체크)
	public int loginCheck(MemberDTO dto) throws SQLException{
		String sql = "select count(mid) from member where mid=? and mpwd=?";
		//결과값이 0 : id는 이미 있으므로, pwd가 잘못되었다. 
		//결과값이 1 : id도 있고, pwd도 정상이다. 
		int result = 0;
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		psmt = con.prepareStatement(sql);
		psmt.setString(1, dto.getMid());
		psmt.setString(2, dto.getMpwd());
		rs = psmt.executeQuery();
		
		rs.next();
		result = rs.getInt(1);
		rs.close();
		psmt.close();
		con.close();

		return result;
	}//loginCheck
}
