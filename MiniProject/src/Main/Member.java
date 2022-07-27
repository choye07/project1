package Main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Member extends JFrame {
	private MemberDao dao;
	private JTextField id;
	private JTextField name;
	private JTextField email;

	Member() {

		dao = new MemberDao();
		setSize(632, 398);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel MainPanel = new JPanel();
		MainPanel.setBounds(0, 0, 0, 0);
		getContentPane().add(MainPanel);
		JLabel lmId = new JLabel("\uC544\uC774\uB514 :");
		lmId.setBounds(199, 98, 57, 15);
		getContentPane().add(lmId);

		JLabel lmname = new JLabel("\uC774\uB984 :");
		lmname.setBounds(209, 123, 47, 15);
		getContentPane().add(lmname);

		JLabel lmEmail = new JLabel("\uC774\uBA54\uC77C :");
		lmEmail.setBounds(199, 179, 57, 15);
		getContentPane().add(lmEmail);

		id = new JTextField();
		id.setBounds(268, 95, 162, 21);
		getContentPane().add(id);
		id.setColumns(10);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(268, 120, 162, 21);
		getContentPane().add(name);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(268, 176, 162, 21);
		getContentPane().add(email);

		JLabel lmpwd = new JLabel("\uBE44\uBC00\uBC88\uD638 :");
		lmpwd.setBounds(199, 151, 57, 15);
		getContentPane().add(lmpwd);

		JPasswordField pwd = new JPasswordField();
		pwd.setColumns(10);
		pwd.setBounds(268, 148, 162, 21);
		getContentPane().add(pwd);
		
		JButton back = new JButton("<");
	      back.setBounds(27, 42, 41, 23);
	      getContentPane().add(back);
	      back.addActionListener(new ActionListener() {
	      			public void actionPerformed(ActionEvent e) {
	      				new MainHome();
	      				setVisible(false); // 창 안보이게 하기
	      			}
	      		});


		JButton btnMem = new JButton("\uD68C\uC6D0\uAC00\uC785 \uC644\uB8CC");
		btnMem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name.getText().equals("")) { // == !=
					JOptionPane.showMessageDialog(null, "별명을 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
				} else if (email.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "e-mail을 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
				} else if (id.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "id를 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
				} else if (pwd.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "password를 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
				} else {
					MemberVo vo = new MemberVo(id.getText(), pwd.getText(),name.getText(), email.getText());
					System.out.println(vo.toString());

					boolean b = dao.list(vo);
					JOptionPane.showMessageDialog(null, " 회원가입 되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);

				}
				setVisible(false);
				new MainHome();
			}
		});
		btnMem.setBounds(265, 259, 116, 23);
		getContentPane().add(btnMem);

	}

	public static void main(String[] args) {
		new Member();
	}
}