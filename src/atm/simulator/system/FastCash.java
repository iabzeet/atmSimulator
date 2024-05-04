package atm.simulator.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{
	
	JButton deposit, withdrawl, ministmt, pinchange, fastcash, balanceenq, exit;
	String pinnumber;
	
	FastCash(String pinnumber) {
		this.pinnumber = pinnumber;
		setLocale(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
       	text.setFont(new Font("System", Font.BOLD, 16));
       	image.add(text);
       	
       	deposit = new JButton("Rs 100");
       	deposit.setBounds(150,390,150,32);
       	deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
       	withdrawl.setBounds(355,390,150,32);
       	withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Rs 1000");
       	fastcash.setBounds(150,424,150,32);
       	fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministmt = new JButton("Rs 2000");
       	ministmt.setBounds(355,424,150,32);
       	ministmt.addActionListener(this);
        image.add(ministmt);
        
        pinchange = new JButton("Rs 5000");
       	pinchange.setBounds(150,458,150,32);
       	pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenq = new JButton("Rs 10000");
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
            setVisible(true);
            new Transactions(pinnumber).setVisible(true);
        } else {
        	String amount = ((JButton)ae.getSource()).getText().substring(3);	//Rs 500
        	Conn c = new Conn();
        	try {
        		ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
        		int balance = 0;
        		while (rs.next()) {
        			if (rs.getString("type").equals("Deposit")) {
        				balance += Integer.parseInt(rs.getString("amount"));
        			} else {
        				balance -= Integer.parseInt(rs.getString("amount"));
        			}
        			
        			if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
        				JOptionPane.showMessageDialog(null, "Insufficient Balance");
        				return;
        			}
        			
        			Date date = new Date();
        			String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
        			c.s.executeUpdate(query);
        			JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
        			
        			setVisible(false);
        			new Transactions(pinnumber).setVisible(true);
        		}
        	} catch (Exception e) {
        		System.out.println(e);
        	}
        }
	}
	
	public static void main(String args[]) {
		new FastCash("");
	}
}









