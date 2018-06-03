package br.com.projetointegrador.web;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.projetointegrador.model.Bem;
import br.com.projetointegrador.model.BemRN;
import br.com.projetointegrador.relatorio.Relatorio;
import net.sf.jasperreports.engine.JRException;
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
		if(bem.getTurno() != 0) {
			bem.setTurno(bem.getTurno());
		}
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
	
	public void actionRelatorio(){
		System.out.println("ddddddd");
		Relatorio report = new Relatorio();
		if (listBem.size() > 0) {
			report.getRelatorio(listBem);
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não há registros!"));
		}
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
