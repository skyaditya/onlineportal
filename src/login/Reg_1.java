package login;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import Default.DBCon;

import javax.swing.JPasswordField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;

public class Reg_1 extends JFrame{

	JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton btnNewButton;
	private JButton btnBack;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;

	Connection co;

	/**
	 * Create the application.
	 */
	public Reg_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 688, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setBounds(43, 34, 121, 23);
		frame.getContentPane().add(lblRegistration);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(43, 85, 56, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date Of Birth");
		lblNewLabel_1.setBounds(43, 114, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(43, 143, 56, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email ID");
		lblNewLabel_3.setBounds(43, 183, 56, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setBounds(43, 212, 56, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setBounds(43, 241, 56, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Confirm Password");
		lblNewLabel_6.setBounds(43, 270, 56, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		btnNewButton = new JButton("Confirm");
		btnNewButton.setBounds(43, 311, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(111, 82, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 140, 116, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(111, 180, 116, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(111, 209, 116, 22);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(111, 238, 116, 22);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(111, 270, 116, 22);
		frame.getContentPane().add(passwordField_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(111, 111, 42, 22);
		for(int i=01; i<=31; i++) {
			String format = String.format("%02d", i);
			comboBox.addItem(format);
		}
		frame.getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(165, 111, 73, 22);
		for(int i=1; i<=12; i++) {
			String format = String.format("%02d", i);
			comboBox_1.addItem(format);
		}
		frame.getContentPane().add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(250, 111, 56, 22);
		for(int i=1980; i<=2018; i++) {
			String format = String.format("%d", i);
			comboBox_2.addItem(i);
		}
		frame.getContentPane().add(comboBox_2);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(43, 444, 97, 25);
		frame.getContentPane().add(btnBack);
		
		theHandler h = new theHandler();
		//textField_User.addActionListener(h);
		//passwordField_UPassword.addActionListener(h);
		btnNewButton.addActionListener(h);
		btnBack.addActionListener(h);
	}
	
	private class theHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			/*String u= "";
			String p = "";
			if(e.getSource()==textField_User) {
				u = String.format("%s", e.getActionCommand());				
			}
			if(e.getSource()==passwordField_UPassword) {
				p = String.format("%s", e.getActionCommand());
			}*/
			if(e.getSource() == btnNewButton) {
				String str = "";
				if(String.valueOf(passwordField_1.getPassword()).equals(String.valueOf(passwordField.getPassword())) && !(String.valueOf(passwordField.getPassword()).equals(str))) {
					try {
						co = DBCon.getConnection();
						Statement st=co.createStatement();
			            String rs_name="", rs_passwrd="";
			            String que="select * from user_details;";
			            ResultSet rs=st.executeQuery(que);
			            int flag=1;
			            while(rs.next()) {
			            	if(textField.getText().equals(rs.getString("username")))
			            	{
			            		flag = 0;
			            		break;
			            	}
			            }
			            if(flag==0) {
							JOptionPane.showMessageDialog(frame,"Username already used ","Error",JOptionPane.ERROR_MESSAGE);
			            }
			            else {
			            	String date =comboBox_2.getItemAt(comboBox_2.getSelectedIndex())+"-"+comboBox_1.getItemAt(comboBox_1.getSelectedIndex())+"-"+comboBox.getItemAt(comboBox.getSelectedIndex());
			            	System.out.println(date);
				            String que2 = "update user_details set name='"+textField.getText()+"' username ='"+textField_4.getText()+"' password= '"+String.valueOf(passwordField_1.getPassword())+"' dob='"+date+"' email='"+textField_3.getText()+"' address='"+textField_2.getText()+"' ;";                                                         
				            Statement s =st;
				            ResultSet rs1 = s.executeQuery(que2); 
			            }
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					frame.hide();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Login_Details window = new Login_Details();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			}
			
			if(e.getSource() == btnBack) {
				frame.hide();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Login_Details window = new Login_Details();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		}
	}
}
