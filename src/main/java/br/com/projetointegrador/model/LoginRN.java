package br.com.projetointegrador.model;

import br.com.projetointegrador.web.LoginMB;
import br.com.projetointegrador.model.Login;

public class LoginRN {

	public void login(String login, String senha) {
		new LoginDAO().getLogin(login, senha);
	}

}
