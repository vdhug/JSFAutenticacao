package br.auth.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {
	
	//Classe para conectar com banco de dados
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/loginjsf", "root", "root");
			return con;
		} catch (Exception ex) {
			System.out.println("Erro : Database.getConnection()  -->"
					+ ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}