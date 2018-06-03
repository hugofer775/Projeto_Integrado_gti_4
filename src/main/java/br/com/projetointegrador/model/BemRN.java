package br.com.projetointegrador.model;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.projetointegrador.web.BemMB;

public class BemRN {
	
	public void gravar(Bem bem) {
			if (bem.getId() == null) {
				new BemDAO().insert(bem);
			} else {
				new BemDAO().update(bem);
			}
	}
	
	public void excluir(Bem bem) {
		new BemDAO().delete(bem);
	}
	
	
	
	public void update(Bem bem) {
			new BemDAO().update(bem);
	}
	
	public List<Bem> selectAll() {
		return new BemDAO().selectAll();
	}
	
	public static String da(Bem bem) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		DecimalFormat formato = new DecimalFormat("0.00", dfs);
		Calendar c = Calendar.getInstance();
		Date venda = (Date) bem.getDt_venda();
		Date compra = (Date) bem.getDt_adiquicao();
		c.setTime(compra);
		int count = 0;
		Double valor_taxa = null;
		
		Double usa = (bem.getVida_util() - bem.getUsado());
		System.out.println("-----"+ usa);
		Double vu = (bem.getVida_util() / 2);
		System.out.println("---"+ usa);
		
		if(usa > vu) {
			valor_taxa = usa;
		}
		
		if(usa < vu) {
			valor_taxa = vu;
		}
		
		if(usa == vu) {
			valor_taxa = vu;
		}
		
		if(bem.getUsado()  == 0) {
			valor_taxa = bem.getVida_util();
		}
		
		
		System.out.println("aqi >" + valor_taxa);
		
		Calendar v = Calendar.getInstance();
			
		if(venda != null) {
		
		v.setTime(venda);
		
		int dia = c.get(Calendar.DAY_OF_MONTH);
		
		int mes = c.get(Calendar.MONTH);
		
		int ano = c.get(Calendar.YEAR);
		
		int dia2 = v.get(Calendar.DAY_OF_MONTH);

		int mes2 = v.get(Calendar.MONTH);
		
		int ano2 = v.get(Calendar.YEAR);
		
		if(dia <= 15 ) {
			count = count + 1;
			System.out.println(count);
		}
		
		else {
			count = count;
		}
		
		count = count + ((12 - 1) - mes);
		System.out.println(count);
		
		int calano = ((ano2 - 1) - ano) * 12;
		
		count = count + calano;
		System.out.println(count);
		
		if(dia2 > 15) {
			count = count + 1;
			System.out.println(count);
			
		}
		else {
			count = count;
			System.out.println(count);
			
		}
		
		count = count + mes2;
		System.out.println(count);
		
		//System.err.println(count);
		}
		else {
			v = Calendar.getInstance();
			
			int dia = c.get(Calendar.DAY_OF_MONTH);
			
			int mes = c.get(Calendar.MONTH);
			
			int ano = c.get(Calendar.YEAR);
			
			int dia2 = v.get(Calendar.DAY_OF_MONTH);

			int mes2 = v.get(Calendar.MONTH);
			
			int ano2 = v.get(Calendar.YEAR);
			
			if(dia <= 15 ) {
				count = count + 1;
				System.out.println(count);
			}
			
			else {
				count = count;
			}
			
			count = count + ((12 - 1) - mes);
			System.out.println(count);
			
			int calano = ((ano2 - 1) - ano) * 12;
			
			count = count + calano;
			System.out.println(count);
			
			if(dia2 > 15) {
				count = count + 1;
				System.out.println(count);
				
			}
			else {
				count = count;
				System.out.println(count);
				
			}
			
			count = count + mes2;
			System.out.println(count);
			
			//System.err.println(count);
		}
		
		if(bem.getTurno()== 2) {
		double taxa = (100/ valor_taxa) * 1.5;
		System.out.println(taxa);
		double calvl_residual = bem.getValor_compra() * (bem.getValor_residual() /100);
		System.out.println(calvl_residual);
		double da = (((bem.getValor_compra() - calvl_residual) * (taxa/ 100))/12)* count;
		
		System.out.println(da);
		
		double prv_bug = (bem.getVida_util() / 1.5) * 12;
		System.out.println(prv_bug);
		
		double p = (valor_taxa * 1.5) * 12;
		
		
		
		if(prv_bug < count || p < count || da > bem.getValor_compra()) {
			bem.setDa(calvl_residual);
			
		}
		else {
		
		bem.setDa(da);
		}
		
		double vc = bem.getValor_compra() - da;
		
		if(prv_bug < count || p < count || da > bem.getValor_compra()) {
			bem.setVc(calvl_residual);
		}
		else {
		bem.setVc(Double.valueOf(formato.format(vc)));
		}
		
		if(bem.getValor_venda() != null) {
			double gp;
			
			gp = bem.getValor_venda() - bem.getVc();
			bem.setGoup(Double.valueOf(formato.format(gp)));
		}if(bem.getValor_venda() == null ||bem.getValor_venda() == 0) {
			bem.setGoup(null);
		}
		
		if(bem.getDt_venda() != null){
			bem.setStatus("Baixado");
		}
		if(bem.getDt_venda() == null) {
			bem.setStatus("Ativo");
		}
		return null;
		}
		
		if(bem.getTurno()== 3) {
			System.out.println("bem aqui " + valor_taxa);
			double taxa = (100/ valor_taxa) * 2;
			System.out.println(taxa);
			double calvl_residual = bem.getValor_compra() * (bem.getValor_residual() /100);
			System.out.println(calvl_residual);
			
			double da = (((bem.getValor_compra() - calvl_residual) * (taxa/ 100))/12)* count;
			
			System.out.println("eu sei" + da);
			
			double prv_bug = (bem.getVida_util() / 2) * 12;
			System.out.println(prv_bug);
			
			double p = (valor_taxa * 2) * 12;
			System.out.println("aqui - > " + p);
			
			if(prv_bug < count || p < count || da > bem.getValor_compra()) {
				bem.setDa(calvl_residual);
				
			}
			else {
			
			bem.setDa(Double.valueOf(formato.format(da)));
			}
			
			double vc = bem.getValor_compra() - da;
			
			if(prv_bug < count || p < count || da > bem.getValor_compra()) {
				bem.setVc(calvl_residual);
			}
			else {
			bem.setVc(Double.valueOf(formato.format(vc)));
			}
			
			if(bem.getValor_venda() != null) {
				double gp;
				
				gp = bem.getValor_venda() - bem.getVc();
				bem.setGoup(Double.valueOf(formato.format(gp)));
			}if(bem.getValor_venda() == null ||bem.getValor_venda() == 0) {
				bem.setGoup(null);
			}
			
			if(bem.getDt_venda() != null){
				bem.setStatus("Baixado");
			}
			if(bem.getDt_venda() == null) {
				bem.setStatus("Ativo");
			}
			
			return null;
			}
		else {
			double taxa = 100/ valor_taxa;
			System.out.println(taxa);
			double calvl_residual = bem.getValor_compra() * (bem.getValor_residual() /100);
			System.out.println(calvl_residual);
			double da = (((bem.getValor_compra() - calvl_residual) * (taxa/ 100))/12)* count;
			
			System.out.println(da);
			
			double prv_bug = bem.getVida_util() * 12;
			System.out.println(prv_bug);
			
			if(prv_bug < count) {
				bem.setDa(calvl_residual);
				
			}
			else {
			
			bem.setDa(Double.valueOf(formato.format(da)));
			}
			
			double vc = bem.getValor_compra() - da;
			
			if(prv_bug < count) {
				bem.setVc(calvl_residual);
			}
			else {
			bem.setVc(Double.valueOf(formato.format(vc)));
			}
			
			if(bem.getValor_venda() != null) {
				double gp;
				
				gp = bem.getValor_venda() - bem.getVc();
				bem.setGoup(Double.valueOf(formato.format(gp)));
			}if(bem.getValor_venda() == null ||bem.getValor_venda() == 0) {
				bem.setGoup(null);
			}
			
			if(bem.getDt_venda() != null){
				bem.setStatus("Baixado");
			}
			else {
				bem.setStatus("Ativo");
			}
					
			return null;
		}
	}
}

