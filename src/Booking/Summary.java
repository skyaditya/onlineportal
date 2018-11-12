package Booking;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import login.Login_Details;

import javax.swing.JButton;

public class Summary {

	JFrame frame;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Summary window = new Summary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Summary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 694, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(39, 51, 56, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(39, 120, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(39, 149, 56, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(39, 180, 56, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(39, 209, 56, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnCancelBooking = new JButton("Cancel Booking");
		btnCancelBooking.setBounds(39, 261, 119, 25);
		frame.getContentPane().add(btnCancelBooking);
		
		JButton btnModify = new JButton("Modify");
		btnModify.setBounds(39, 299, 97, 25);
		frame.getContentPane().add(btnModify);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(39, 348, 97, 25);
		frame.getContentPane().add(btnBack);
		

		theHandler h = new theHandler();
		//textField_User.addActionListener(h);
		//passwordField_UPassword.addActionListener(h);
		///btnNewButton.addActionListener(h);
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
			/*if(e.getSource() == btnNewButton) {
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
			}*/
			if(e.getSource() == btnBack) {
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
		}
	}
}
