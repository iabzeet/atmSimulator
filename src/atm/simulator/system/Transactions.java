package atm.simulator.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposit, withdrawl, ministmt, pinchange, fastcash, balanceenq, exit;
	String pinnumber;
	
	Transactions(String pinnumber) {
		this.pinnumber = pinnumber;
		setLocale(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Please Select Your Transaction");
		text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
       	text.setFont(new Font("System", Font.BOLD, 16));
       	image.add(text);
       	
       	deposit = new JButton("Deposit");
       	deposit.setBounds(150,390,150,32);
       	deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
       	withdrawl.setBounds(355,390,150,32);
       	withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
       	fastcash.setBounds(150,424,150,32);
       	fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministmt = new JButton("Mini Statement");
       	ministmt.setBounds(355,424,150,32);
       	ministmt.addActionListener(this);
        image.add(ministmt);
        
        pinchange = new JButton("Pin Change");
       	pinchange.setBounds(150,458,150,32);
       	pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenq = new JButton("Balance Enquiry");
       	balanceenq.setBounds(355,458,150,32);
       	balanceenq.addActionListener(this);
        image.add(balanceenq);
        
        exit = new JButton("Exit");
       	exit.setBounds(355,492,150,32);
       	exit.addActionListener(this);
        image.add(exit);
		
        
		setSize(900, 900);
		setLocation(300, 0);
		//setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit){ 
            System.exit(0);
        } else if (ae.getSource() == deposit) {
        	setVisible(false);
        	new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
        	setVisible(false);
        	new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
        	setVisible(false);
        	new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange) {
        	setVisible(false);
        	new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceenq) {
        	setVisible(false);
        	new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == ministmt) {
        	new MiniStatement(pinnumber).setVisible(true);
        }
	}
	
	public static void main(String args[]) {
		new Transactions("");
	}
}
