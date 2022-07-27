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
     * South 영역에 추가할 Componet들
     */
    JPanel p = new JPanel();
    String[] comboName = { "  ALL  ","sname" };
 
    JComboBox combo = new JComboBox(comboName);
    JTextField jtf = new JTextField(20);
//    JTextField id = new JTextField();
    JButton serach = new JButton("검색");
 
    SnameViewDAO dao = new SnameViewDAO();
    String sname;
    
    

    /**
     * 화면구성 및 이벤트등록
     */
    public SnameView() {
    	
        p.setBounds(0, 0, 485, 150);

        // South영역
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
				setVisible(false); // 창 안보이게 하기
			}
		});

        
        setSize(501, 181);
        setVisible(true);
 
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serach.addActionListener(this);
 
        // 모든레코드를 검색하여 DefaultTableModle에 올리기
        dao.userSelectAll(dt);
//        int row = jt.getSelectedRow();
//        sname = jt.getValueAt(row, 1).toString();

        //첫번행 선택.
        if (dt.getRowCount() > 0)
            jt.setRowSelectionInterval(0, 0);
 int row = jt.getSelectedRow();
    }// 생성자끝
 
    /**
     * main메소드 작성
     */
    public static void main(String[] args) {
        new SnameView();
    }


    /**
     * 가입/수정/삭제/검색기능을 담당하는 메소드
     * */
 
    public void actionPerformed(ActionEvent e) {
 if (e.getSource() == serach) {// 검색 버튼 클릭
            // JComboBox에 선택된 value 가져오기
            String fieldName = combo.getSelectedItem().toString();
            System.out.println("필드명 " + fieldName);
 
            if (fieldName.trim().equals("ALL")) {// 전체검색
                dao.userSelectAll(dt);
                if (dt.getRowCount() > 0)
                    jt.setRowSelectionInterval(0, 0);
            } else {
                if (jtf.getText().trim().equals("")) {
                    jtf.requestFocus();
                } else {// 검색어를 입력했을경우
                    dao.getUserSearch(dt, fieldName, jtf.getText());
                    if (dt.getRowCount() > 0)
                        jt.setRowSelectionInterval(0, 0);
                }
            }
        }
	 
 }
    }