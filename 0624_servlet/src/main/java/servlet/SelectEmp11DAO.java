package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectEmp11DAO {
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "c##scott";
	private final String PASSWORD = "tiger";
	
	
	public SelectEmp11DAO() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}//catch
	}//constructor
	
	public void selectEmp() {
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.createStatement();
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno, from emp";
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}//finally
	}//selectEmp
}//SelectEmp11DAO
