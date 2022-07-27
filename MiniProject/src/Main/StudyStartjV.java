package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

class DatePick {
	int DATE_MONTH = Calendar.getInstance().get(Calendar.MONTH);
	int DATE_YEAR = Calendar.getInstance().get(Calendar.YEAR);;
	JLabel J_Label = new JLabel("", JLabel.CENTER);
	String DATE_DAY = "";
	JDialog J_Dialog;
	JButton[] J_Button = new JButton[49];

	public DatePick(JFrame J_Frame_Parent) {
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
public class StudyStartjV  extends JFrame {
	private JTextField textField_2;
	private JTextField tfStudy1;
	private JTextField tfStudy2;
	private JTextField tfStudy3;

	public StudyStartjV() {
		JLabel J_Label = new JLabel("Today : ");
		J_Label.setBounds(120, 90, 48, 15);
		final JTextField J_Text_Field = new JTextField(20);
		J_Text_Field.setBounds(173, 87, 226, 21);
		JButton J_Button = new JButton("날짜 선택하기");
		J_Button.setBounds(404, 86, 118, 23);
		setLocationRelativeTo(null);
		JPanel J_Panel = new JPanel();
		J_Panel.setLayout(null);
		J_Panel.add(J_Label);
		J_Panel.add(J_Text_Field);
		J_Panel.add(J_Button);
		final JFrame J_Frame = new JFrame();
		J_Frame.getContentPane().add(J_Panel);
		
		JLabel J_Label_1 = new JLabel("Study :");
		J_Label_1.setBounds(120, 139, 48, 18);
		J_Panel.add(J_Label_1);
		
		JLabel J_Label_1_2 = new JLabel("StudyTime :");
		J_Label_1_2.setBounds(92, 224, 76, 15);
		J_Panel.add(J_Label_1_2);
		
		textField_2 = new JTextField(20);
		textField_2.setBounds(173, 221, 226, 21);
		J_Panel.add(textField_2);
		
		JButton btnSW = new JButton("\uC2A4\uD1B1\uC6CC\uCE58");
	
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
		btnSW.setBounds(404, 138, 118, 104);
		J_Panel.add(btnSW);
		
		JButton btnSHome = new JButton("홈");
		btnSHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Studyjv();
				J_Frame.setVisible(false);
			}
		});
		btnSHome.setBounds(186, 310, 92, 29);
		J_Panel.add(btnSHome);
		
		JButton btnSave = new JButton("\uC800\uC7A5");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSave.setBounds(412, 310, 92, 29);
		J_Panel.add(btnSave);
		
		tfStudy1 = new JTextField(20);
		tfStudy1.setBounds(173, 138, 226, 21);
		J_Panel.add(tfStudy1);
		
		tfStudy2 = new JTextField(20);
		tfStudy2.setBounds(173, 164, 226, 21);
		J_Panel.add(tfStudy2);
		
		tfStudy3 = new JTextField(20);
		tfStudy3.setBounds(173, 190, 226, 21);
		J_Panel.add(tfStudy3);
		
		JLabel lblNewLabel_1 = new JLabel(LoginVo.userid.getId());
		lblNewLabel_1.setBounds(25, 26, 76, 15);
		J_Panel.add(lblNewLabel_1);
//		J_Frame.pack();
		J_Frame.setLocationRelativeTo(null);
		J_Frame.setVisible(true);
		J_Frame.setSize(683,400);
		J_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				J_Text_Field.setText(new DatePick(J_Frame).Set_Picked_Date());
			}
		});

		
	}
	public static void main(String[] args) {
		new StudyStartjV();
	}

}
