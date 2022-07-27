package Main;

//UserDefaultJTableDAO.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class StudyjcgRecordOtherDAO {

/**
 * 필요한 변수선언
 * */
Connection con;
Statement st;
PreparedStatement ps;
ResultSet rs;

/**
 * 로드 연결을 위한 생성자
 * */
public StudyjcgRecordOtherDAO() {
    try {
        // 로드
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // 연결
        con = DriverManager
                .getConnection("jdbc:oracle:thin:@localhost:1521/xe",
                        "c##green", "green1234");

    } catch (ClassNotFoundException e) {
        System.out.println(e + "=> 로드 fail");
    } catch (SQLException e) {
        System.out.println(e + "=> 연결 fail");
    }
}//생성자

/**
 * DB닫기 기능 메소드
 * */
public void dbClose() {
    try {
        if (rs != null) rs.close();
        if (st != null) st.close();
        if (ps != null) ps.close();
    } catch (Exception e) {
        System.out.println(e + "=> dbClose fail");
    }
}//dbClose() ---



/**
 * userlist의 모든 레코드 조회
 * */
public void userSelectAll(DefaultTableModel t_model) {
    try {
        st = con.createStatement();
        rs = st.executeQuery("select * from jcg ");

        // DefaultTableModel에 있는 기존 데이터 지우기
        for (int i = 0; i < t_model.getRowCount();) {
            t_model.removeRow(0);
        }

        while (rs.next()) {
      	  Object data[] = { rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)};

            t_model.addRow(data); //DefaultTableModel에 레코드 추가
        }

    } catch (SQLException e) {
        System.out.println(e + "=> userSelectAll fail");
    } finally {
        dbClose();
    }
}//userSelectAll()


//userListInsert()


/**
 * 검색단어에 해당하는 레코드 검색하기 (like연산자를 사용하여 _, %를 사용할때는 PreparedStatemnet안된다. 반드시
 * Statement객체를 이용함)
 * */
public void getUserSearch(DefaultTableModel dt, String fieldName,
        String word) {
    String sql = "SELECT * FROM jcg WHERE " + fieldName.trim()
            + " LIKE '%" + word.trim() + "%'";

    try {
        st = con.createStatement();
        rs = st.executeQuery(sql);
        
        System.out.println(fieldName.trim());
        System.out.println(word.trim());

        // DefaultTableModel에 있는 기존 데이터 지우기
        for (int i = 0; i < dt.getRowCount();) {
            dt.removeRow(0);
        }

        while (rs.next()) {
      	  Object data[] = { rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)};
            
            dt.addRow(data);
        }

    } catch (SQLException e) {
        System.out.println(e + "=> getUserSearch fail");
    } finally {
        dbClose();
    }

}//getUserSearch()


}// 클래스끝