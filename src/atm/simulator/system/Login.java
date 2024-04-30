package atm.simulator.system;

import java.awt.ActiveEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	Login() {
		setTitle("AUTOMATED TELLER MACHINE");
		
		setLayout(null);		//allow custom layout and disable border layout
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 =  new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward", Font.BOLD, 38));
		text.setBounds(200, 40, 400, 40);
		add(text);
		
		JLabel cardNo = new JLabel("Card No:");
		cardNo.setFont(new Font("Railway", Font.BOLD, 28));
		cardNo.setBounds(120, 150, 150, 30);
		add(cardNo);
		
		JTextField cardTextField = new JTextField();
		cardTextField.setBounds(300, 150, 230, 30);
		add(cardTextField);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Railway", Font.BOLD, 28));
		pin.setBounds(120, 220, 250, 30);
		add(pin);
		
		JTextField pinTextField = new JTextField();
		pinTextField.setBounds(300, 220, 230, 30);
		add(pinTextField);
		
		JButton login = new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		add(login);
		
		JButton clear = new JButton("CLEAR");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		add(clear);
		
		JButton signUp = new JButton("SIGN UP");
		signUp.setBounds(300, 350, 230, 30);
		signUp.setBackground(Color.BLACK);
		signUp.setForeground(Color.WHITE);
		add(signUp);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800, 480);
		setVisible(true);
		setLocation(350, 250);
	}
	
	public void actionPerformed(ActiveEvent ae) {
		
	}

	public static void main(String[] args) {
		new Login();

	}

}
