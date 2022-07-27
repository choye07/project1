package Main;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
 
 
public class StudyjcgRecordMe extends JFrame implements ActionListener {
 
    String[] name = { "jcgstdt","jcgStudy1","jcgStudy2","jcgStudy3", "jcgstt" };
 
    DefaultTableModel dt = new DefaultTableModel(name, 0);
    JTable jt = new JTable(dt);
    JScrollPane jsp = new JScrollPane(jt);
 
    /*
     * South ������ �߰��� Componet��
     */
    JPanel p = new JPanel();
    String[] comboName = { "  ALL  ", " jcgstdt","jcgstt" };
 
    JComboBox combo = new JComboBox(comboName);
    JTextField jtf = new JTextField(20);
    JButton serach = new JButton("�˻�");
 
    StudyjcgRecordMeDAO  dao = new StudyjcgRecordMeDAO ();
 
    /**
     * ȭ�鱸�� �� �̺�Ʈ���
     */
    public StudyjcgRecordMe() {
       
        super("GUI ȸ���������α׷� - DB����");
        p.setBounds(0, 22, 615, 46);
 
        
        JButton back = new JButton("<");
         back.setBounds(10, 10, 78, 23);
       back.addActionListener(new ActionListener() {
       			public void actionPerformed(ActionEvent e) {
       				new Studyjcg();
       				setVisible(false); // â �Ⱥ��̰� �ϱ�
       			}
       		});
               p.add(back);
        // South����
        p.setBackground(Color.WHITE);
        p.setLayout(null);
        combo.setBounds(111, 11, 67, 21);
        p.add(combo);
        jtf.setBounds(183, 11, 226, 21);
        p.add(jtf);
        serach.setBounds(414, 10, 78, 23);
        p.add(serach);
        getContentPane().setLayout(null);
        jsp.setBounds(0, 69, 615, 258);
 
        getContentPane().add(jsp);
        getContentPane().add(p);
 
        setSize(631, 400);
        setVisible(true);
 
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        new StudyjcgRecordMe();
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
 
    }//actionPerformed()----------
 
}