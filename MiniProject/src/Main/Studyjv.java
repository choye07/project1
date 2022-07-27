package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Studyjv extends JFrame{
	private JTextField txtJavaStudy;
	private JLabel Lstudyjava;
	public Studyjv(){
		setVisible(true);
		setSize(632, 398);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel MainPanel = new JPanel();
		MainPanel.setBounds(0, 0, 0, 0);
		getContentPane().add(MainPanel);
		
		Lstudyjava = new JLabel("\uC790\uBC14 \uC2A4\uD130\uB514 \uBC29");
		Lstudyjava.setBounds(252, 56, 99, 15);
		getContentPane().add(Lstudyjava);
		
		JLabel lp6 = new JLabel("All User Study Record");
		lp6.setBounds(168, 161, 128, 15);
		getContentPane().add(lp6);
		
		JLabel lpMe = new JLabel(LoginVo.userid.getId());
		lpMe.setBounds(239, 130, 57, 15);
		getContentPane().add(lpMe);
		
		JButton btnview1 = new JButton("\uBCF4\uAE30");
		btnview1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new StudyjvRecordMe ();
			}
		});
		btnview1.setBounds(308, 126, 65, 23);
		getContentPane().add(btnview1);
		
		JButton btnview2 = new JButton("\uBCF4\uAE30");
		btnview2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new StudyjvRecordOther ();
			}
		});
		btnview2.setBounds(308, 157, 65, 23);
		getContentPane().add(btnview2);
		
		
		JButton Home = new JButton("\uB2E4\uB978 \uC11C\uBC84\uAC00\uAE30");
		Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new StudyRoom();
			}
		});
		Home.setBounds(159, 288, 128, 23);
		getContentPane().add(Home);
		
		JButton btnStart = new JButton("\uACF5\uBD80 \uC2DC\uC791");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new StudyStartjV();
			}
		});
		btnStart.setBounds(331, 288, 97, 23);
		getContentPane().add(btnStart);
	}
}
