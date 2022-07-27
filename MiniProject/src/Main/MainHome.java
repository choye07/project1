package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class MainHome extends JFrame implements ActionListener {

	private LoginDao ldao;
	private JButton bLogin;
	private JButton bmember;

	private JTextField id;
	private JPasswordField pwd;
	private JLabel lid;
	private JLabel lpwd;

	public MainHome() {
		super();
		
		ldao = new LoginDao();
		setSize(632, 398);
		setLocationRelativeTo(null);
		new JPanel();
		JPanel MainPanel = new JPanel();
		bmember = new JButton("회원가입");
		bLogin = new JButton("로그인");
		lid = new JLabel("ID : ");
		lpwd = new JLabel("Password : ");
		id = new JTextField(10);
		pwd = new JPasswordField(10);
		
		
		getContentPane().add(MainPanel);
		getContentPane().add(MainPanel);
		getContentPane().add(MainPanel);
		

		lid.setBounds(217, 167, 23, 15);
		lpwd.setBounds(195, 192, 69, 15);

		id.setBounds(263, 164, 116, 21);
		pwd.setBounds(263, 189, 116, 21);

		bLogin.setBounds(217, 263, 92, 29);
		bLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "id를 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
				} else if (pwd.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "password를 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
				} else {
					LoginVo vo = new LoginVo(id.getText(), pwd.getText());
					System.out.println(vo.toString());
					
					LoginVo.user(vo);

					boolean b = ldao.list(vo);
					JOptionPane.showMessageDialog(null, " 로그인 되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);

					setVisible(false);
					new StudyRoom();
				}
			}
		});

		bmember.setBounds(321, 263, 92, 29);
		bmember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Member();
				setVisible(false); // 창 안보이게 하기
			}
		});

		bLogin.addActionListener(this);
		getContentPane().setLayout(null);

		getContentPane().add(lid);
		getContentPane().add(id);
		getContentPane().add(lpwd);
		getContentPane().add(pwd);
		getContentPane().add(bLogin);
		getContentPane().add(bmember);

		setVisible(true);

	}

	public static void main(String[] args) {
		new MainHome();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}