package Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Studyjcg extends JFrame {
	private JButton btnview1;
	public Studyjcg() {

		setVisible(true);
		setSize(632, 398);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel MainPanel = new JPanel();
		MainPanel.setBounds(0, 0, 0, 0);
		getContentPane().add(MainPanel);
		
		JLabel LJcgStudy = new JLabel("\uC815\uCC98\uAE30 \uC2A4\uD130\uB514 \uBC29");
		LJcgStudy.setBounds(252, 56, 99, 15);
		getContentPane().add(LJcgStudy);
		
		JLabel lp2 = new JLabel("All User Study Record");
		lp2.setBounds(159, 161, 137, 15);
		getContentPane().add(lp2);
		
		JLabel lpMe = new JLabel(LoginVo.userid.getId());
		lpMe.setBounds(159, 130, 137, 15);
		getContentPane().add(lpMe);
		
		
		btnview1 = new JButton("\uBCF4\uAE30");
		btnview1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new StudyjcgRecordMe();
			}
		});
		btnview1.setBounds(308, 126, 65, 23);
		getContentPane().add(btnview1);
		
		JButton btnview2 = new JButton("\uBCF4\uAE30");
		btnview2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new StudyjcgRecordOther();
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
				new StudyStartjcg();
			}
		});
		btnStart.setBounds(331, 288, 97, 23);
		getContentPane().add(btnStart);
	}
}
