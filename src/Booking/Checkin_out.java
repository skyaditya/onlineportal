package Booking;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import login.Login_Details;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

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
	private JComboBox outm;
	private JComboBox outy;
	
	Connection co;
	
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
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Booking Details");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Gotham Bold", Font.BOLD, 40));
		lblNewLabel.setBounds(38, 41, 335, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Location");
		lblNewLabel_1.setFont(new Font("GoodPro-Book", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(38, 136, 122, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Check In Date");
		lblNewLabel_2.setFont(new Font("GoodPro-Book", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(38, 192, 178, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Check out Date");
		lblNewLabel_3.setFont(new Font("GoodPro-Book", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(38, 245, 190, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("No. of Rooms");
		lblNewLabel_4.setFont(new Font("GoodPro-Book", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(38, 301, 178, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("No. of People");
		lblNewLabel_5.setFont(new Font("GoodPro-Book", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(38, 352, 165, 30);
		frame.getContentPane().add(lblNewLabel_5);
		
		room = new JComboBox();
		room.setBounds(236, 301, 70, 30);
		for(int i=0; i<=6; i++) {
			room.addItem(i);
		}
		frame.getContentPane().add(room);
		
		people = new JComboBox();
		people.setBounds(236, 352, 70, 30);
		for(int i=0; i<=6; i++) {
			people.addItem(i);
		}
		frame.getContentPane().add(people);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Gotham Bold", Font.BOLD, 25));
		btnConfirm.setBounds(38, 429, 141, 41);
		frame.getContentPane().add(btnConfirm);
		
		btnCart = new JButton("Cart");
		btnCart.setBackground(Color.LIGHT_GRAY);
		btnCart.setFont(new Font("Gotham Bold", Font.PLAIN, 25));
		btnCart.setBounds(1049, 586, 141, 41);
		frame.getContentPane().add(btnCart);
		
		location = new JComboBox();
		location.setBackground(Color.LIGHT_GRAY);
		location.setBounds(164, 136, 282, 30);
		location.addItem("hyderabad");
		location.addItem("pillani");
		location.addItem("goa");		
		frame.getContentPane().add(location);
		
		ind = new JComboBox();
		ind.setBounds(236, 192, 62, 29);
		for(int i=01; i<=31; i++) {
			String format = String.format("%02d", i);
			ind.addItem(format);
		}
		frame.getContentPane().add(ind);
		
		inm = new JComboBox();
		inm.setBounds(310, 192, 56, 29);
		for(int i=01; i<=12; i++) {
			String format = String.format("%02d", i);
			inm.addItem(format);
		}
		frame.getContentPane().add(inm);
		
		iny = new JComboBox();
		iny.setBounds(378, 192, 68, 29);
		for(int i=2018; i<=2020; i++) {
			String format = String.format("%02d", i);
			iny.addItem(format);
		}
		frame.getContentPane().add(iny);
		
		outd = new JComboBox();
		outd.setBounds(236, 245, 62, 29);
		for(int i=01; i<=31; i++) {
			String format = String.format("%02d", i);
			outd.addItem(format);
		}
		frame.getContentPane().add(outd);
		
		outm = new JComboBox();
		outm.setBounds(310, 245, 56, 29);
		for(int i=01; i<=12; i++) {
			String format = String.format("%02d", i);
			outm.addItem(format);
		}
		frame.getContentPane().add(outm);
		
		outy = new JComboBox();
		outy.setBounds(378, 245, 68, 29);
		for(int i=2018; i<=2020; i++) {
			String format = String.format("%02d", i);
			outy.addItem(format);
		}
		frame.getContentPane().add(outy);
		
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
            	String in =iny.getItemAt(iny.getSelectedIndex())+"-"+inm.getItemAt(inm.getSelectedIndex())+"-"+ind.getItemAt(ind.getSelectedIndex());
            	String out =outy.getItemAt(outy.getSelectedIndex())+"-"+outm.getItemAt(outm.getSelectedIndex())+"-"+outd.getItemAt(outd.getSelectedIndex());
            	
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
