package br.com.projetointegrador.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.projetointegrador.util.ConnectionFactory;
import br.com.projetointegrador.web.LoginMB;

public class LoginDAO extends ConnectionFactory {

	private static final long serialVersionUID = 1L;
	
	public String getLogin(String login, String senha) {
		try {
			Connection con = getConnection();
			String sql = "SELECT id, login, senha FROM usuario WHERE login = ? AND senha = ?";
            PreparedStatement instrucao = con.prepareStatement(sql);
            instrucao.setString(1, login);
            instrucao.setString(2, senha);
            ResultSet rs = instrucao.executeQuery();
          if (rs.next()) {
        	  Login logi = new Login();
        	  logi.setId(rs.getLong("id"));
        	  logi.setLogin(rs.getString("login"));
        	  logi.setSenha(rs.getString("senha"));
        	  LoginMB.actionPage();
        	  System.err.println("---");
        	  logi.setCerto(rs.getDouble("id"));
        	  return null;
             }
		} catch (Exception e) {
			System.err.println("Erro no insert do DAO: " + e.getMessage());
			System.err.println();
			e.printStackTrace();
		}
		return null;
	}
	
		
	}
	

