package com.smartstoremanager;

import java.sql.Connection;
import java.sql.DriverManager;

public class Product {
	static String url="jdbc:postgresql://localhost:5432/smartstoremanager";
	static Connection conn=null;

	static void baglan() {
		try {
			conn= DriverManager.getConnection(url, "pstgres", "qwert54321");
			System.out.println("sucsess");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
