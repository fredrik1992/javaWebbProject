package connector;

import beans.AFeedBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SqlConnection {
	static Connection conn = null;
	static PreparedStatement stmt = null;
	static ResultSet rs = null;

	public static boolean connectSQL(String serverName) {// call this from servlet to see if we have established connection

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // kolla vad denna gör tror denna kollar så att vi har en driver
														// uppe

		} catch (Exception ex) {
			System.out.print("Driver expection:" + ex);
			return false;
		}

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ "+serverName+"?serverTimezone=UTC", "root", "");

			return true;

		} catch (SQLException ex) {
			System.out.print("SQLExepection" + ex.getMessage());
			System.out.print("SQLState:" + ex.getSQLState());
			System.out.print("VendorError:" + ex.getErrorCode());
			return false;

		}

	}

	public static boolean userValidatorAgainstDatabase(String username, String password) {
		// check if username and password exists in database call this from bean

		try {
			String requestQuerry = "SELECT * FROM `users` WHERE `username` like ? ";

			stmt = conn.prepareStatement(requestQuerry); // får null

			stmt.setString(1, "%" + username + "%"); // kan sätta värden som tex string format

			rs = stmt.executeQuery();

			boolean validated = false;

			while (rs.next()) {
				if (rs.getString(1).equals(username) && rs.getString(2).equals(password)) {
					validated = true;
				}

			}

			conn.endRequest();
			conn.close();

			if (validated) {

				return true;
			} else {

				return false;
			}

		} catch (SQLException ex) {
			System.out.print("SQLExepection" + ex.getMessage());
			System.out.print("SQLState:" + ex.getSQLState());
			System.out.print("VendorError:" + ex.getErrorCode());

			return false;
		}

	}
	
	public static String getAllFeeds() {
		connectSQL("feed"); // changes server connection
		
		try {
			//ArrayList<AFeedBean> allFeeds = new ArrayList<>();
			String allFeeds = "";
			 String requstQuerry = "SELECT `textLine`,`tag` FROM `allfeed` ";
			 stmt = conn.prepareStatement(requstQuerry );
			 rs = stmt.executeQuery();

			 while(rs.next()){
				 allFeeds += rs.getString(1) + ";";
				 allFeeds += rs.getString(2) + ";";
				 
			 }return allFeeds;

		}catch (SQLException ex) {
			System.out.print("SQLExepection" + ex.getMessage());
			System.out.print("SQLState:" + ex.getSQLState());
			System.out.print("VendorError:" + ex.getErrorCode());


		}
		
		// get all om them and save them as a loooooong string maby ? then send it back to controller
		return null;
		
	}

}