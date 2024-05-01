package atm.simulator.system;
import java.sql.*;
/**
 * 5 steps in JDBC
 * Register the Driver
 * Create Connection
 * Create Statement
 * Execute Query
 * Close Connection
 */

public class Conn {
	
	Connection c;
	Statement s;
	public Conn() {
		try {
			//register driver -- driver will get registered from classpath library
			//Class.forName(com.mysql.cj.jdbc.Driver);
			
			//create connection
			c = DriverManager.getConnection("jdbc:mysql:///atmsimulatorsystem", "root", "abhijeet");
			
			//create statement
			s = c.createStatement();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
