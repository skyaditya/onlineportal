package login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Booking.Checkin_out;
import Default.DBCon;

public class Login_Details extends JFrame{

	public JFrame frame;
	private JTextField textField_User;
	private JPasswordField passwordField_UPassword;
	private JButton btnSign_Up;
	private JButton btnLogin;
	Connection co = null;
	/**
	 * Create the application.
	 */
	public Login_Details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 567, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin_Details = new JLabel("OPPO ROOMS");
		lblLogin_Details.setFont(new Font("GoodPro-CondMedium", Font.BOLD, 48));
		lblLogin_Details.setBounds(45, 36, 346, 62);
		frame.getContentPane().add(lblLogin_Details);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(45, 151, 56, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(45, 203, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_User = new JTextField();
		textField_User.setBounds(123, 148, 116, 22);
		frame.getContentPane().add(textField_User);
		textField_User.setColumns(10);
		
		passwordField_UPassword = new JPasswordField();
		passwordField_UPassword.setBounds(123, 200, 116, 19);
		frame.getContentPane().add(passwordField_UPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(45, 248, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		btnSign_Up = new JButton("Sign UP");
		btnSign_Up.setBounds(45, 299, 97, 22);
		frame.getContentPane().add(btnSign_Up);
	
		theHandler h = new theHandler();
		textField_User.addActionListener(h);
		passwordField_UPassword.addActionListener(h);
		btnLogin.addActionListener(h);
		btnSign_Up.addActionListener(h);
	
	}
	
	private class theHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==textField_User) {
			}
			if(e.getSource()==passwordField_UPassword) {
			}
			if(e.getSource() == btnSign_Up) {
				frame.hide();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Reg_1 window = new Reg_1();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			if(e.getSource() == btnLogin) {
				try {
					String u= textField_User.getText();
					String p = String.valueOf(passwordField_UPassword.getPassword());
					co = DBCon.getConnection();
					Statement st=co.createStatement();
		            String rs_name="", rs_passwrd="";
		            String que="select * from user_details where username=\""+u+"\" and password=\""+p+"\""+";";
		            ResultSet rs=st.executeQuery(que);
		            while(rs.next())
		            {
		                rs_name=rs.getString("username");
		               rs_passwrd=rs.getString("password");
		           }
		             System.out.println("connection passed");
		             if (u.equals(rs_name) && p.equals(rs_passwrd)) {
		            	 frame.hide();
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										Checkin_out window = new Checkin_out();
										window.frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
		             }
					else {
						JOptionPane.showMessageDialog(frame,"Invalid Username or Password! ","Error",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}

	}
	
}
