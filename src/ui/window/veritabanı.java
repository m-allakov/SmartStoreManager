package ui.window;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class veritabanı {
	static String url="jdbc:postgresql://localhost:5432/smartstoremanager";
	static Connection conn=null;

	static void baglan() {
		try {
			conn= DriverManager.getConnection(url, "postgres", "qwert54321");
			System.out.println("sucsess");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	static ResultSet listele(String sorgu) {
		try {
			Statement st= conn.createStatement();
			ResultSet rs = st.executeQuery(sorgu);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}