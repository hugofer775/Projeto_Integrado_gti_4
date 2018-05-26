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
	private List<Bem> listBem = null;
	
	public String actionGravar() {
		new BemRN().gravar(bem);
		return "relatorio";
	}
	
	public String actionUpdate() {
		new BemRN().update(bem);
		return "relatorio";
	}
	
	public String actionExcluir() {
		new BemRN().excluir(bem);
		this.listBem = null;
		return "relatorio";
	}
	
	public List<Bem> getSelectAll(){
		if (this.listBem == null) {
		    this.listBem =  new BemRN().selectAll();
		}
		return this.listBem;
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
