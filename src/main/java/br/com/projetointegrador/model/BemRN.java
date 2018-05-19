package br.com.projetointegrador.model;

import java.util.List;

public class BemRN {

	public void gravar(Bem bem) {
			new BemDAO().insert(bem);
	}
}

