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
	private JButton btnConfirm;
	private JButton btnCart;
	private JComboBox location;
	private JComboBox ind;
	private JComboBox inm;
	private JComboBox iny;
	private JComboBox room;
	private JComboBox people;
	private JComboBox outd;
	private JComboBox inm_1;
	private JComboBox iny_1;
	
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
		
		JLabel lblNewLabel_1 = new JLabel("Location");
		lblNewLabel_1.setBounds(36, 76, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Check In:");
		lblNewLabel_2.setBounds(36, 105, 56, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Check out:");
		lblNewLabel_3.setBounds(36, 134, 56, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("No of Rooms");
		lblNewLabel_4.setBounds(36, 163, 56, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("No. of People");
		lblNewLabel_5.setBounds(36, 194, 56, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		room = new JComboBox();
		room.setBounds(104, 160, 56, 22);
		for(int i=0; i<=6; i++) {
			room.addItem(i);
		}
		frame.getContentPane().add(room);
		
		people = new JComboBox();
		people.setBounds(104, 191, 56, 22);
		for(int i=0; i<=6; i++) {
			people.addItem(i);
		}
		frame.getContentPane().add(people);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(36, 253, 97, 25);
		frame.getContentPane().add(btnConfirm);
		
		btnCart = new JButton("Cart");
		btnCart.setBounds(36, 313, 97, 25);
		frame.getContentPane().add(btnCart);
		
		location = new JComboBox();
		location.setBounds(102, 74, 118, 20);
		location.addItem("hyderabad");
		location.addItem("pillani");
		location.addItem("goa");		
		frame.getContentPane().add(location);
		
		ind = new JComboBox();
		ind.setBounds(102, 103, 39, 20);
		for(int i=01; i<=31; i++) {
			String format = String.format("%02d", i);
			ind.addItem(format);
		}
		frame.getContentPane().add(ind);
		
		inm = new JComboBox();
		inm.setBounds(145, 103, 44, 20);
		for(int i=01; i<=12; i++) {
			String format = String.format("%02d", i);
			inm.addItem(format);
		}
		frame.getContentPane().add(inm);
		
		iny = new JComboBox();
		iny.setBounds(208, 103, 62, 20);
		for(int i=2018; i<=2020; i++) {
			String format = String.format("%02d", i);
			iny.addItem(format);
		}
		frame.getContentPane().add(iny);
		
		outd = new JComboBox();
		outd.setBounds(102, 132, 39, 20);
		for(int i=01; i<=31; i++) {
			String format = String.format("%02d", i);
			outd.addItem(format);
		}
		frame.getContentPane().add(outd);
		
		inm_1 = new JComboBox();
		inm_1.setBounds(145, 132, 44, 20);
		for(int i=01; i<=12; i++) {
			String format = String.format("%02d", i);
			inm_1.addItem(format);
		}
		frame.getContentPane().add(inm_1);
		
		iny_1 = new JComboBox();
		iny_1.setBounds(208, 132, 62, 20);
		for(int i=2018; i<=2020; i++) {
			String format = String.format("%02d", i);
			iny_1.addItem(format);
		}
		frame.getContentPane().add(iny_1);
		
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
