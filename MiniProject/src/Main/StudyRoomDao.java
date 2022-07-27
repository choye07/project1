//package Main;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class StudyRoomDao {
//	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	String user = "c##green";
//	String password = "green1234";
//
//	private Connection con;
//	private Statement stmt;
//	private PreparedStatement pstmt = null;
//	private ResultSet rs;
//String sname;
//
//	public boolean studylist() {
//		connDB();
//		try {
//			pstmt = con.prepareStatement("SELECT SNAME FROM SERVERLIST WHERE id= "+LoginVo.userid.getId()); // SQL 질의
//			rs = pstmt.executeQuery(); // 쿼리 실행결과를 rs에 저장한다
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			if(rs.next()) {
//				sname = rs.getString("SNAME");
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	public void connDB() {
//		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, user, password);
//			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//
//}