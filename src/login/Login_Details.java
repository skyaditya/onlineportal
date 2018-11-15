package login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Booking.Checkin_out;
import Default.DBCon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.UIManager;

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
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(100, 149, 237));
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin_Details = new JLabel("ONLINE HOTEL");
		lblLogin_Details.setForeground(Color.WHITE);
		lblLogin_Details.setFont(new Font("Gotham Book", Font.PLAIN, 48));
		lblLogin_Details.setBounds(78, 184, 394, 72);
		frame.getContentPane().add(lblLogin_Details);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("GoodPro-Book", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(817, 169, 113, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("GoodPro-Book", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(817, 213, 113, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_User = new JTextField();
		textField_User.setBounds(942, 169, 206, 31);
		frame.getContentPane().add(textField_User);
		textField_User.setColumns(10);
		
		passwordField_UPassword = new JPasswordField();
		passwordField_UPassword.setBounds(942, 214, 206, 31);
		frame.getContentPane().add(passwordField_UPassword);
		
		btnLogin = new JButton("Log In");
		btnLogin.setFont(new Font("Gotham Bold", Font.PLAIN, 20));
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(1035, 273, 113, 42);
		frame.getContentPane().add(btnLogin);
		
		btnSign_Up = new JButton("Sign Up");
		btnSign_Up.setBackground(Color.WHITE);
		btnSign_Up.setForeground(Color.DARK_GRAY);
		btnSign_Up.setFont(new Font("Gotham Bold", Font.PLAIN, 20));
		btnSign_Up.setBounds(1035, 373, 113, 42);
		frame.getContentPane().add(btnSign_Up);
		
		JLabel lblBookingPortal = new JLabel("BOOKING PORTAL");
		lblBookingPortal.setForeground(Color.WHITE);
		lblBookingPortal.setFont(new Font("Gotham Book", Font.PLAIN, 48));
		lblBookingPortal.setBounds(77, 243, 477, 72);
		frame.getContentPane().add(lblBookingPortal);
		
		JLabel lblWelcomeTo = new JLabel("Welcome, to");
		lblWelcomeTo.setForeground(Color.WHITE);
		lblWelcomeTo.setFont(new Font("Gotham Book", Font.PLAIN, 40));
		lblWelcomeTo.setBounds(78, 128, 269, 72);
		frame.getContentPane().add(lblWelcomeTo);
		
		JLabel lblNewUser = new JLabel("New User?");
		lblNewUser.setForeground(Color.WHITE);
		lblNewUser.setFont(new Font("GoodPro-Book", Font.PLAIN, 20));
		lblNewUser.setBounds(942, 379, 121, 31);
		frame.getContentPane().add(lblNewUser);
		
	
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
