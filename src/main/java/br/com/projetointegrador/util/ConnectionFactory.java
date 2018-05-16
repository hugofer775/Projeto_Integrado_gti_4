package br.com.projetointegrador.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/db_projetointegrador";
	private static final String USER = "postgres";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch(Exception e) {
			System.err.println("----------------");
			System.err.println("Erro na conexão");
			e.printStackTrace();
		}
		return null;
		
	}
}
