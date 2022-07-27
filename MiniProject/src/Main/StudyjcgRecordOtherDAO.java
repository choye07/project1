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
 * �ʿ��� ��������
 * */
Connection con;
Statement st;
PreparedStatement ps;
ResultSet rs;

/**
 * �ε� ������ ���� ������
 * */
public StudyjcgRecordOtherDAO() {
    try {
        // �ε�
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // ����
        con = DriverManager
                .getConnection("jdbc:oracle:thin:@localhost:1521/xe",
                        "c##green", "green1234");

    } catch (ClassNotFoundException e) {
        System.out.println(e + "=> �ε� fail");
    } catch (SQLException e) {
        System.out.println(e + "=> ���� fail");
    }
}//������

/**
 * DB�ݱ� ��� �޼ҵ�
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
 * userlist�� ��� ���ڵ� ��ȸ
 * */
public void userSelectAll(DefaultTableModel t_model) {
    try {
        st = con.createStatement();
        rs = st.executeQuery("select * from jcg ");

        // DefaultTableModel�� �ִ� ���� ������ �����
        for (int i = 0; i < t_model.getRowCount();) {
            t_model.removeRow(0);
        }

        while (rs.next()) {
      	  Object data[] = { rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)};

            t_model.addRow(data); //DefaultTableModel�� ���ڵ� �߰�
        }

    } catch (SQLException e) {
        System.out.println(e + "=> userSelectAll fail");
    } finally {
        dbClose();
    }
}//userSelectAll()


//userListInsert()


/**
 * �˻��ܾ �ش��ϴ� ���ڵ� �˻��ϱ� (like�����ڸ� ����Ͽ� _, %�� ����Ҷ��� PreparedStatemnet�ȵȴ�. �ݵ��
 * Statement��ü�� �̿���)
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

        // DefaultTableModel�� �ִ� ���� ������ �����
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


}// Ŭ������