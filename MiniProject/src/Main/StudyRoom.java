package Main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class StudyRoom extends JFrame {
	private static final LoginVo userid = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";
	
	JButton btnJoin;
	JPanel MainPanel;
	 JButton btnSet;
	 JComboBox Study;
		private LoginDao ldao;
	 Connection con = null;
 Statement stmt = null;
	 ResultSet rs = null;
	 String i;
	 String j;

	@SuppressWarnings("unchecked")
	StudyRoom(){
		ldao = new LoginDao();
		combolist(driver);
		MainPanel = new JPanel();
		 setSize(342, 306);
		 setLocationRelativeTo(null);
		 getContentPane().setLayout(null);
		
			LoginVo vo = new LoginVo();
			System.out.println(vo.toString());
			

		 btnSet = new JButton("\uC11C\uBC84 \uAD00\uB9AC");
		 btnSet.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		setVisible(false);
		 		new ServerSetting();
		 	}
		 });
		 btnSet.setBounds(118, 206, 97, 23);
		 getContentPane().add(btnSet);
		 String[] comboname = {i,j};
	Study = new JComboBox(comboname);
//	Study.addItem(i);

		 Study.setBounds(84, 90, 162, 23);
		 getContentPane().add(Study);
		 
	 btnJoin = new JButton("\uC785\uC7A5");

		 btnJoin.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				if( Study.getSelectedItem().equals("jcg")) {		
					setVisible(false);
					new Studyjcg();
				}else if (Study.getSelectedItem().equals("java")) {
					 new Studyjv();
					 setVisible(false);
				}
			 }
		 });
		 btnJoin.setBounds(118, 159, 97, 23);
		 getContentPane().add(btnJoin);
		 
		 JLabel lblNewLabel = new JLabel(LoginVo.userid.getId());
		 lblNewLabel.setBounds(12, 21, 71, 15);
		 getContentPane().add(lblNewLabel);
		 setVisible(true);
		 
	}
	
	public String combolist(String info) {
	      try {
	         conn();

	         String query = "SELECT SNAME1, SNAME2"
				  		+ " FROM SERVERLIST"
				  		+ " WHERE id = " +"'"+LoginVo.userid.getId()+"'";
	         System.out.println("SQL : " + query);
	         rs = stmt.executeQuery(query);

	         while (rs.next()) {
	        	 
	        	 i	= rs.getString(1);
	        	 j	= rs.getString(2);
	        	 System.out.println(i);
	         }
	      }

 catch (Exception e) {
	         e.printStackTrace();
	      }

	      return i;
	   }
		 
public void conn(){
  // 오라클 드라이버 선언
  try {
   Class.forName(driver);
  } catch (ClassNotFoundException e) {
   e.printStackTrace();
  }  

  try {
   // 오라클 DB연결
	  con = DriverManager.getConnection(url, user, password);
	  stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
  } catch (SQLException ee) {
   ee.printStackTrace();
  }
 }
 
	public static void main(String[] args) {
		StudyRoom st = new StudyRoom();
		
		st.combolist(null);
	}
}