package br.com.projetointegrador.web;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.projetointegrador.model.Bem;
import br.com.projetointegrador.model.BemRN;
@ManagedBean (name = "bemMB")
@RequestScoped
public class BemMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Bem bem = new Bem();
	
	public String actionGravar() {
		new BemRN().gravar(bem);
		return "relatorio";
	}
	
	public String actionNovo() {
		this.bem = new Bem();
		return "relatorio";
	}
	
	public Bem getBem() {
		return bem;
	}

	public void setBem(Bem bem) {
		this.bem = bem;
	}

}
