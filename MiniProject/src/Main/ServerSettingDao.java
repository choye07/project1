package Main;

//UserDefaultJTableDAO.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class ServerSettingDao {
 
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
  public ServerSettingDao() {
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
   * �μ��� ���� ID�� �ش��ϴ� ���ڵ� �˻��Ͽ� �ߺ����� üũ�ϱ� ���ϰ��� true =��밡�� , false = �ߺ���
   * */

  /**
   * userlist ȸ�������ϴ� ��� �޼ҵ�
   * */
  public int userListInsert(ServerSettingGUI user) {
      int result = 0;
      try {
          ps = con.prepareStatement("insert into  Serverlist  values(?,?,?)");
          ps.setString(1, user.id.getText());
          ps.setString(2, user.sname1.getText());
          ps.setString(3, user.sname2.getText());

          result = ps.executeUpdate(); //���� -> ����

      } catch (SQLException e) {
          System.out.println(e + "=> userListInsert fail");
      } finally {
          dbClose();
      }

      return result;

  }//userListInsert()

  /**
   * userlist�� ��� ���ڵ� ��ȸ
   * */
  public void userSelectAll(DefaultTableModel t_model) {
      try {
          st = con.createStatement();
          rs = st.executeQuery("select * from Serverlist  where id ="+"'"+LoginVo.userid.getId()+"'");

          // DefaultTableModel�� �ִ� ���� ������ �����
          for (int i = 0; i < t_model.getRowCount();) {
              t_model.removeRow(0);
          }

          while (rs.next()) {
          	Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3)};

              t_model.addRow(data); //DefaultTableModel�� ���ڵ� �߰�
          }

      } catch (SQLException e) {
          System.out.println(e + "=> userSelectAll fail");
      } finally {
          dbClose();
      }
  }//userSelectAll()

  /**
   * ID�� �ش��ϴ� ���ڵ� �����ϱ�
   * */
  public int userDelete(String id) {
      int result = 0;
      try {
          ps = con.prepareStatement("delete  Serverlist  where id = ? ");
          ps.setString(1, id.trim());
          result = ps.executeUpdate();

      } catch (SQLException e) {
          System.out.println(e + "=> userDelete fail");
      }finally {
          dbClose();
      }

      return result;
  }//userDelete()

  /**
   * ID�� �ش��ϴ� ���ڵ� �����ϱ�
   * */


  /**
   * �˻��ܾ �ش��ϴ� ���ڵ� �˻��ϱ� (like�����ڸ� ����Ͽ� _, %�� ����Ҷ��� PreparedStatemnet�ȵȴ�. �ݵ��
   * Statement��ü�� �̿���)
   * */
  public void getUserSearch(DefaultTableModel dt, String fieldName,
          String word) {
      String sql = "SELECT * FROM Serverlist WHERE " + fieldName.trim()
              + " LIKE '%" + word.trim() + "%'";

      try {
          st = con.createStatement();
          rs = st.executeQuery(sql);

          // DefaultTableModel�� �ִ� ���� ������ �����
          for (int i = 0; i < dt.getRowCount();) {
              dt.removeRow(0);
          }

          while (rs.next()) {
              Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3)};

              dt.addRow(data);
          }

      } catch (SQLException e) {
          System.out.println(e + "=> getUserSearch fail");
      } finally {
          dbClose();
      }

  }//getUserSearch()

}// Ŭ������
