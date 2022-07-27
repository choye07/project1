package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class DatePick2 {
	int DATE_MONTH = Calendar.getInstance().get(Calendar.MONTH);
	int DATE_YEAR = Calendar.getInstance().get(Calendar.YEAR);;
	JLabel J_Label = new JLabel("", JLabel.CENTER);
	String DATE_DAY = "";
	JDialog J_Dialog;
	JButton[] J_Button = new JButton[49];

	public DatePick2(JFrame J_Frame_Parent) {
		J_Dialog = new JDialog();
		J_Dialog.setModal(true);
		String[] Header = { "일", "월", "화", "수", "목", "금", "토" };
		JPanel J_Panel1 = new JPanel(new GridLayout(7, 7));
		J_Panel1.setPreferredSize(new Dimension(400, 400));

		for (int i = 0; i < J_Button.length; i++) {
			final int selection = i;
			J_Button[i] = new JButton();
			J_Button[i].setFocusPainted(false);
			J_Button[i].setBackground(Color.white);
			if (i > 6)
				J_Button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						DATE_DAY = J_Button[selection].getActionCommand();
						J_Dialog.dispose();
					}
				});
			if (i < 7) {
				J_Button[i].setText(Header[i]);
				if (i == 0) {
					J_Button[i].setForeground(Color.red);
				} else if (i == 6) {
					J_Button[i].setForeground(Color.blue);
				} else
					J_Button[i].setForeground(Color.black);
			}
			J_Panel1.add(J_Button[i]);
		}
		JPanel J_Panel2 = new JPanel(new GridLayout(1, 3));
		JButton Previous_Button = new JButton("<< Previous");
		Previous_Button.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent ae) {
				DATE_MONTH--;
				Display_Date();
			}
		});
		J_Panel2.add(Previous_Button);
		J_Panel2.add(J_Label);
		JButton Next_Button = new JButton("Next >>");
		Next_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				DATE_MONTH++;
				Display_Date();
			}
		});
		J_Panel2.add(Next_Button);
		J_Dialog.add(J_Panel1, BorderLayout.CENTER);
		J_Dialog.add(J_Panel2, BorderLayout.SOUTH);
		J_Dialog.pack();
		J_Dialog.setLocationRelativeTo(J_Frame_Parent);
		Display_Date();
		J_Dialog.setVisible(true);
	}

	public void Display_Date() {
		for (int i = 7; i < J_Button.length; i++)
			J_Button[i].setText("");
		SimpleDateFormat Simple_Date_Format = new SimpleDateFormat("MMMM yyyy");
		Calendar Calendar = java.util.Calendar.getInstance();
		Calendar.set(DATE_YEAR, DATE_MONTH, 1);
		int Day_Of_Week = Calendar.get(java.util.Calendar.DAY_OF_WEEK);
		int Days_In_Month = Calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		for (int i = 6 + Day_Of_Week, Day = 1; Day <= Days_In_Month; i++, Day++)
			J_Button[i].setText("" + Day);
		J_Label.setText(Simple_Date_Format.format(Calendar.getTime()));
		J_Dialog.setTitle("Date Picker");
	}

	public String Set_Picked_Date() {
		if (DATE_DAY.equals(""))
			return DATE_DAY;
		SimpleDateFormat Simple_Date_Format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar Calendar = java.util.Calendar.getInstance();
		Calendar.set(DATE_YEAR, DATE_MONTH, Integer.parseInt(DATE_DAY));
		return Simple_Date_Format.format(Calendar.getTime());
	}
}

public class StudyStartjcg extends JFrame {
	private JTextField jcgStudy1;
	private JTextField jcgstdt;
	private JTextField jcgstt;
	private JTextField jcgStudy2;
	private JTextField jcgStudy3;
	private StudyStartjcgDao cdao;
	private JTextField Sname;


	public StudyStartjcg() {
		
		cdao = new StudyStartjcgDao();
		JLabel J_LToday = new JLabel("Today : ");
		J_LToday.setBounds(120, 90, 48, 15);
		 jcgstdt = new JTextField(20);
		jcgstdt.setBounds(173, 87, 226, 21);
		JButton J_Button = new JButton("날짜 선택하기");
		J_Button.setBounds(404, 86, 118, 23);
		setLocationRelativeTo(null);
		
		JPanel jcgMainpanel = new JPanel();
		jcgMainpanel.setLayout(null);
		jcgMainpanel.add(J_LToday);
		jcgMainpanel.add(jcgstdt);
		jcgMainpanel.add(J_Button);
	 JFrame J_Frame = new JFrame();
		getContentPane().add(jcgMainpanel);
		
		JLabel J_LStudy = new JLabel("Study :");
		J_LStudy.setBounds(120, 139, 48, 18);
		jcgMainpanel.add(J_LStudy);
		
		JLabel J_LStudytime = new JLabel("StudyTime :");
		J_LStudytime.setBounds(92, 224, 76, 15);
		jcgMainpanel.add(J_LStudytime);
		
		jcgstt = new JTextField(20);
		jcgstt.setBounds(173, 221, 226, 21);
		jcgMainpanel.add(jcgstt);
		
		JButton btnSW = new JButton("\uC2A4\uD1B1\uC6CC\uCE58");
		btnSW.setBounds(404, 138, 118, 104);
		jcgMainpanel.add(btnSW);
		btnSW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String urlLink ="https://vclock.kr/stopwatch/";
			
			try {
				Desktop.getDesktop().browse(new URI(urlLink));
			}catch(IOException e1) {
				e1.printStackTrace();
			}catch(URISyntaxException e1) {
				e1.printStackTrace();
			}
			
			}
		});
		
		setVisible(true);
		
		
		JButton btnSave = new JButton("\uC800\uC7A5");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jcgstdt.getText().equals("")){
					JOptionPane.showMessageDialog(null, "날짜를 골라주세요", "Message", JOptionPane.ERROR_MESSAGE);
					} else if (Sname.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "서버이름을 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
					} else if (jcgStudy1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "공부할 내용 1을 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
					}else if (jcgStudy2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "공부할 내용 2를 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
					}else if (jcgStudy3.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "공부할 내용 3을 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
					} else if (jcgstt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "공부한 시간을 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
					} else {
					StudyStartjcgVo vo = new StudyStartjcgVo(Sname.getText(),jcgstdt.getText(), jcgStudy1.getText(),jcgStudy2.getText(),jcgStudy3.getText(),
					jcgstt.getText());
										System.out.println(vo.toString());

										boolean b = cdao.slist(vo);
										JOptionPane.showMessageDialog(null, "공부 내용이 기록되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
										setVisible(false);
										new Studyjcg();
									}
								}
							});
		btnSave.setBounds(270, 310, 92, 29);
		jcgMainpanel.add(btnSave);
		
		jcgStudy1 = new JTextField(20);
		jcgStudy1.setBounds(173, 138, 226, 21);
		jcgMainpanel.add(jcgStudy1);
		
		jcgStudy2 = new JTextField(20);
		jcgStudy2.setBounds(173, 164, 226, 21);
		jcgMainpanel.add(jcgStudy2);
		
		jcgStudy3 = new JTextField(20);
		jcgStudy3.setBounds(173, 190, 226, 21);
		jcgMainpanel.add(jcgStudy3);
		
		JLabel lblNewLabel = new JLabel(LoginVo.userid.getId());
		lblNewLabel.setBounds(25, 26, 76, 15);
		jcgMainpanel.add(lblNewLabel);
		
		JLabel lstudyname = new JLabel("\uC815\uCC98\uAE30 \uC2A4\uD130\uB514");
		lstudyname.setBounds(287, 26, 92, 15);
		jcgMainpanel.add(lstudyname);
		
		JLabel J_LServer = new JLabel("Server name : ");
		J_LServer.setBounds(84, 115, 84, 15);
		jcgMainpanel.add(J_LServer);
		
		Sname = new JTextField(20);
		Sname.setBounds(173, 112, 226, 21);
		jcgMainpanel.add(Sname);
		
		setLocationRelativeTo(null);
		setVisible(true);
		setSize(683,400);
		J_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jcgstdt.setText(new DatePick(J_Frame).Set_Picked_Date());

			}
		});
	
	}
	public static void main(String[] args) {
		new StudyStartjcg();
	}
}