package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudyStartjcgDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##green";
	String password = "green1234";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs;

	public boolean slist(StudyStartjcgVo v) {
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			String sql = "INSERT INTO jcg " + "	VALUES (?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, LoginVo.userid.getId());
			pstmt.setString(2, v.getSname());
			pstmt.setString(3, v.getjcgstdt());
			pstmt.setString(4, v.getjcgStudy1());
			pstmt.setString(5, v.getjcgStudy2());
			pstmt.setString(6, v.getjcgStudy3());
			pstmt.setString(7, v.getjcgstt());

			pstmt.executeUpdate();
			System.out.println("success");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nope");
		}

		return false;
	}

	public void connDB() {
		try {
			if(pstmt!=null) {
				pstmt.close();}
			
			}catch(Exception e) {
				e.printStackTrace();
		}
		try {
			if(con!=null) {con.close();}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
