package Main;


//MenuJTabaleExam.java
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ServerSetting extends JFrame implements ActionListener {
  JMenu m = new JMenu("����");
  JMenuItem insert = new JMenuItem("����");

  JMenuItem delete = new JMenuItem("����");
  JMenuItem quit = new JMenuItem("����");
  JMenuBar mb = new JMenuBar();

  String[] name = { "id", "sname1", "sname2" };

  DefaultTableModel dt = new DefaultTableModel(name, 0);
  JTable jt = new JTable(dt);
  JScrollPane jsp = new JScrollPane(jt);

  /*
   * South ������ �߰��� Componet��
   */
  JPanel p = new JPanel();
  String[] comboName = { "  ALL  ", "  ID  ", " Sname1 ", "Sname2" };

  JComboBox combo = new JComboBox(comboName);
  JTextField jtf = new JTextField(20);
  JButton serach = new JButton("�˻�");

  ServerSettingDao dao = new ServerSettingDao();
  private final JButton btnNewButton = new JButton("\uC11C\uBC84 \uC804\uCCB4 \uBCF4\uAE30");

  /**
   * ȭ�鱸�� �� �̺�Ʈ���
   */
  public ServerSetting() {
	  setLocationRelativeTo(null);
     
      //�޴��������� �޴��� �߰�
      m.add(insert);

      m.add(delete);
      m.add(quit);
      //�޴��� �޴��ٿ� �߰�
      mb.add(m);
     
      //�����쿡 �޴��� ����
      setJMenuBar(mb);
      p.setBounds(0, 111, 484, 40);
     
      // South����
      p.setBackground(Color.WHITE);
      p.setLayout(null);
      combo.setBounds(51, 11, 81, 21);
      p.add(combo);
      jtf.setBounds(137, 11, 226, 21);
      p.add(jtf);
      serach.setBounds(368, 10, 65, 23);
      p.add(serach);
      getContentPane().setLayout(null);
      jsp.setBounds(0, 149, 484, 189);

      getContentPane().add(jsp);
      getContentPane().add(p);
      btnNewButton.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		setVisible(false);
      		new SnameView();
      	}
      });
      btnNewButton.setBounds(185, 50, 131, 23);
      
      getContentPane().add(btnNewButton);
      JButton back = new JButton("<");
      back.setBounds(0, 0, 41, 23);
      getContentPane().add(back);
      back.addActionListener(new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
      				new StudyRoom();
      				setVisible(false); // â �Ⱥ��̰� �ϱ�
      			}
      		});

      setSize(500, 400);
      setVisible(true);

      super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // �̺�Ʈ���
      insert.addActionListener(this);

      delete.addActionListener(this);
      quit.addActionListener(this);
      serach.addActionListener(this);

      // ��緹�ڵ带 �˻��Ͽ� DefaultTableModle�� �ø���
      dao.userSelectAll(dt);
     
      //ù���� ����.
      if (dt.getRowCount() > 0)
          jt.setRowSelectionInterval(0, 0);

  }// �����ڳ�

  /**
   * main�޼ҵ� �ۼ�
   */
  public static void main(String[] args) {
      new ServerSetting();
  }

  /**
   * ����/����/����/�˻������ ����ϴ� �޼ҵ�
   * */

  public void actionPerformed(ActionEvent e) {
      if (e.getSource() == insert) {// ���� �޴������� Ŭ��
          new ServerSettingGUI(this, "����");

      }else if (e.getSource() == delete) {// ���� �޴������� Ŭ��
          // ���� Jtable�� ���õ� ��� ���� ���� ���´�.
          int row = jt.getSelectedRow();
          System.out.println("������ : " + row);

          Object obj = jt.getValueAt(row, 0);// �� ���� �ش��ϴ� value
          System.out.println("�� : " + obj);

          if (dao.userDelete(obj.toString()) > 0) {
              ServerSettingGUI.messageBox(this, "���ڵ� �����Ǿ����ϴ�.");
             
              //����Ʈ ����
              dao.userSelectAll(dt);
              if (dt.getRowCount() > 0)
                  jt.setRowSelectionInterval(0, 0);

          } else {
              ServerSettingGUI.messageBox(this, "���ڵ尡 �������� �ʾҽ��ϴ�.");
          }

      } else if (e.getSource() == quit) {// ���� �޴������� Ŭ��
          System.exit(0);

      } else if (e.getSource() == serach) {// �˻� ��ư Ŭ��
          // JComboBox�� ���õ� value ��������
          String fieldName = combo.getSelectedItem().toString();
          System.out.println("�ʵ�� " + fieldName);

          if (fieldName.trim().equals("ALL")) {// ��ü�˻�
              dao.userSelectAll(dt);
              if (dt.getRowCount() > 0)
                  jt.setRowSelectionInterval(0, 0);
          } else {
              if (jtf.getText().trim().equals("")) {
                  ServerSettingGUI.messageBox(this, "�˻��ܾ �Է����ּ���!");
                  jtf.requestFocus();
              } else {// �˻�� �Է��������
                  dao.getUserSearch(dt, fieldName, jtf.getText());
                  if (dt.getRowCount() > 0)
                      jt.setRowSelectionInterval(0, 0);
              }
          }
      }

  }//actionPerformed()----------

}