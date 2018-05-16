package br.com.projetointegrador.model;


import java.io.Serializable;

public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String login;
	private String nome;
	private String senha;
	private static Double certo;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static Double getCerto() {
		return certo;
	}

	public void setCerto(Double certo) {
		this.certo = certo;
	}
	
	
}
