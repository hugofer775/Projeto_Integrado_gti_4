package br.com.projetointegrador.web;

import java.io.Serializable;
import java.time.Period;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.projetointegrador.model.Login;
import br.com.projetointegrador.model.LoginDAO;
import br.com.projetointegrador.model.LoginRN;
@ManagedBean (name = "loginMB")
@RequestScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Login login = new Login();
	//private List<Equipamento> listEquipamentos = null;
	
	public String actionLogar() {
		new LoginRN().login(login.getLogin(), login.getSenha());
		int a = 0;
		
		if(Login.getCerto() != 0) {
			login.setCerto((double) 0);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login realizado com sucesso!"));
			return "cadastro";
			
		}
		
		return null;
	}
	
	public static String actionPage() {
		return "cadastro";
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
}
