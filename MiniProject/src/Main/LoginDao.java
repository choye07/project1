package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;




public class LoginDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public boolean list(LoginVo p) {
		try {
			connDB();
			
			String query = "SELECT * FROM nmember WHERE id='" + p.getId()
			+ "' AND pwd='" + p.getPassword() + "'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			
			if(rs.getRow() == 0) {
			}else {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public void connDB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}