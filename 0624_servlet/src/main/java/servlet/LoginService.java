package servlet;

import java.sql.SQLException;

public class LoginService {
	
	private LoginDAO dao;
	
	public LoginService() {
		dao = new LoginDAO();
	}//constructor
	
	public int loginCheck(MemberDTO dto) throws SQLException{
		int result = 0;
		
		result = dao.idCheck(dto);
		if(result != 1) return -1;//id오류 
		
		result = dao.loginCheck(dto);
		return result;//0이면 pwd오류, 1이면 정상로그인 수행 가능.
	}//loginCheck
}//class
