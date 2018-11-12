package Booking;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import login.Login_Details;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class Checkin_out extends JFrame{

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnConfirm;
	private JButton btnCart;
	
	/**
	 * Create the application.
	 */
	public Checkin_out() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 694, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(36, 32, 56, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(36, 76, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(36, 105, 56, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(36, 134, 56, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(36, 163, 56, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(36, 194, 56, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(104, 73, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(104, 102, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(104, 131, 116, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(104, 160, 56, 22);
		for(int i=0; i<=6; i++) {
			comboBox.addItem(i);
		}
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(104, 191, 56, 22);
		for(int i=0; i<=6; i++) {
			comboBox_1.addItem(i);
		}
		frame.getContentPane().add(comboBox_1);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(36, 253, 97, 25);
		frame.getContentPane().add(btnConfirm);
		
		btnCart = new JButton("Cart");
		btnCart.setBounds(36, 313, 97, 25);
		frame.getContentPane().add(btnCart);
		
		theHandler h = new theHandler();
		//textField_User.addActionListener(h);
		//passwordField_UPassword.addActionListener(h);
		btnConfirm.addActionListener(h);
		btnCart.addActionListener(h);
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
			if(e.getSource() == btnConfirm) {
				frame.hide();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Hotel_name window = new Hotel_name();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			if(e.getSource() == btnCart) {
				frame.hide();
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
		}
	}
}
