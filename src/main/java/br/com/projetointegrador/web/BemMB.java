package br.com.projetointegrador.web;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
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
	
	private boolean isValidar(Bem bem) {
		Calendar t = Calendar.getInstance();
		Calendar c = Calendar.getInstance();
		Date now = new Date();
		Date compra = (Date) bem.getDt_adiquicao();
		c.setTime(compra);
		
		int dia = c.get(Calendar.DAY_OF_MONTH);
		
		int mes = c.get(Calendar.MONTH);
		
		int ano = c.get(Calendar.YEAR);
		
		int dia2 = t.get(Calendar.DAY_OF_MONTH);

		int mes2 = t.get(Calendar.MONTH);
		
		int ano2 = t.get(Calendar.YEAR);
		
		int somainput = 0;
		somainput = ((mes * 30) + dia + ano);
		
		int somadataatual = 0;
		somadataatual = ((mes2 * 30) + dia2 + ano2);
		
		if (somainput <= somadataatual) {
			System.out.println("passou aqui--");
					return true;
			}
		else {
		return false;
		}
	}
	
	private boolean isValidarUpdate(Bem bem) {
		Calendar t = Calendar.getInstance();
		Calendar c = Calendar.getInstance();
		Calendar v = Calendar.getInstance();
		Date compra = (Date) bem.getDt_adiquicao();
		c.setTime(compra);
		Date venda = (Date) bem.getDt_venda();
		v.setTime(venda);
		
		int dia = c.get(Calendar.DAY_OF_MONTH);
		
		int mes = c.get(Calendar.MONTH);
		
		int ano = c.get(Calendar.YEAR);
		
		int dia2 = t.get(Calendar.DAY_OF_MONTH);

		int mes2 = t.get(Calendar.MONTH);
		
		int ano2 = t.get(Calendar.YEAR);
		
		int diav = v.get(Calendar.DAY_OF_MONTH);

		int mesv = v.get(Calendar.MONTH);
		
		int anov = v.get(Calendar.YEAR);
		
		int somainput = 0;
		somainput = ((mes * 30) + dia + ano);
		
		int somadataatual = 0;
		somadataatual = ((mes2 * 30) + dia2 + ano2);
		
		int somadatavenda = 0;
		somadatavenda= ((mesv * 30) + diav + anov);
		
		if(somadatavenda <= somadataatual && somainput <= somadataatual && somadatavenda >= somainput) {
			return true;
		}
		
		else {
		return false;
		}
	}
	
	public String actionGravar() {
		if (isValidar(bem)==true) {
			new BemRN().gravar(bem);
			System.out.println("passou aqui");
			return "relatorio";
		}else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("msgErroData", new FacesMessage("Data inválida!"));
			return "cadastro";
		}
	}
	
	public String actionUpdate() {
		if (isValidarUpdate(bem)==true) {
		if(bem.getTurno() != 0) {
			bem.setTurno(bem.getTurno());
		}
		new BemRN().update(bem);
		return "relatorio";
		}
		else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("msgErroData", new FacesMessage("Data inválida! Verifique as datas e tente novamente"));
			return null;
		}
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
