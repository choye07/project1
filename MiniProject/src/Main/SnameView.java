package Main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
 
 
public class SnameView extends JFrame implements ActionListener {
 

	String[] name = {"sname"};
 
    DefaultTableModel dt = new DefaultTableModel(name, 0);
    JTable jt = new JTable(dt);
    JScrollPane jsp = new JScrollPane(jt);
 
    /*
     * South ������ �߰��� Componet��
     */
    JPanel p = new JPanel();
    String[] comboName = { "  ALL  ","sname" };
 
    JComboBox combo = new JComboBox(comboName);
    JTextField jtf = new JTextField(20);
//    JTextField id = new JTextField();
    JButton serach = new JButton("�˻�");
 
    SnameViewDAO dao = new SnameViewDAO();
    String sname;
    
    

    /**
     * ȭ�鱸�� �� �̺�Ʈ���
     */
    public SnameView() {
    	
        p.setBounds(0, 0, 485, 150);

        // South����
        p.setBackground(Color.WHITE);
        p.setLayout(null);
        combo.setBounds(74, 10, 67, 21);
        p.add(combo);
        jtf.setBounds(146, 10, 226, 21);
        p.add(jtf);
        serach.setBounds(377, 9, 78, 23);
        p.add(serach);
        getContentPane().setLayout(null);
        jsp.setBounds(0, 47, 485, 103);
 
        getContentPane().add(jsp);
        getContentPane().add(p);
        
        JButton back = new JButton("<");
        back.setBounds(12, 10, 41, 23);
        p.add(back);
        back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ServerSetting();
				setVisible(false); // â �Ⱥ��̰� �ϱ�
			}
		});

        
        setSize(501, 181);
        setVisible(true);
 
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serach.addActionListener(this);
 
        // ��緹�ڵ带 �˻��Ͽ� DefaultTableModle�� �ø���
        dao.userSelectAll(dt);
//        int row = jt.getSelectedRow();
//        sname = jt.getValueAt(row, 1).toString();

        //ù���� ����.
        if (dt.getRowCount() > 0)
            jt.setRowSelectionInterval(0, 0);
 int row = jt.getSelectedRow();
    }// �����ڳ�
 
    /**
     * main�޼ҵ� �ۼ�
     */
    public static void main(String[] args) {
        new SnameView();
    }


    /**
     * ����/����/����/�˻������ ����ϴ� �޼ҵ�
     * */
 
    public void actionPerformed(ActionEvent e) {
 if (e.getSource() == serach) {// �˻� ��ư Ŭ��
            // JComboBox�� ���õ� value ��������
            String fieldName = combo.getSelectedItem().toString();
            System.out.println("�ʵ�� " + fieldName);
 
            if (fieldName.trim().equals("ALL")) {// ��ü�˻�
                dao.userSelectAll(dt);
                if (dt.getRowCount() > 0)
                    jt.setRowSelectionInterval(0, 0);
            } else {
                if (jtf.getText().trim().equals("")) {
                    jtf.requestFocus();
                } else {// �˻�� �Է��������
                    dao.getUserSearch(dt, fieldName, jtf.getText());
                    if (dt.getRowCount() > 0)
                        jt.setRowSelectionInterval(0, 0);
                }
            }
        }
	 
 }
    }