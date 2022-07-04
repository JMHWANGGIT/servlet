package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FreeBoardDAO {
	
	public FreeBoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//FreeBoardDAO constructor 
	
	private Connection con;
	private PreparedStatement psmt;
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USER = "c##scott";
	final String PASSWORD = "tiger";
	
	public int insertFreeBoard(FreeBoardDTO dto) {
		int successCount = 0;
		String sql = "insert into freeboard (bno, btitle, bwriter"
				+ ", bcnts, bdate) values(mno_seq.nextval, ?,?,?, sysdate)";
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getBtitle());
			psmt.setString(2, dto.getBwriter());
			psmt.setString(3, dto.getBcnts());
			
			successCount = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}//finally
		
		return successCount;
	}//insertFreeBoard

	public ArrayList<FreeBoardDTO> selectList() {
		ArrayList<FreeBoardDTO> list = new ArrayList<FreeBoardDTO>();
		String sql = "select bno, btitle, bwriter, bcnts, bdate from freeboard"
				+ " order by bno desc";
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				FreeBoardDTO tmp = new FreeBoardDTO();
				tmp.setBno(rs.getString("bno"));
				tmp.setBtitle(rs.getString("btitle"));
				tmp.setBwriter(rs.getString("bwriter"));
				tmp.setBcnts(rs.getString("bcnts"));
				tmp.setBdate(rs.getString("bdate"));
				list.add(tmp);
			}//while
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				psmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}//finally
		
		return list;
	}//selectList

}//class
