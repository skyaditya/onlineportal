package Default;

import java.awt.EventQueue;

import javax.swing.JFrame;

import login.Login_Details;

public class Login extends JFrame {
	
	public static void main(String[] args) {
		System.out.print("wtf");
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

