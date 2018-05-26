package br.com.projetointegrador.model;

import java.sql.Date;
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
		if (bem.getId() == null) {
			new BemDAO().insert(bem);
		} else {
			new BemDAO().update(bem);
		}
	}
	
	public List<Bem> selectAll() {
		return new BemDAO().selectAll();
	}
	
	public static String da(Bem bem) {
		Calendar c = Calendar.getInstance();
		Date venda = (Date) bem.getDt_venda();
		Date compra = (Date) bem.getDt_adiquicao();
		c.setTime(compra);
		int count = 0;
		Double valor_taxa = null;
		
		Double usa = (double) (bem.getVida_util() - bem.getUsado());
		Double vu = (double) (bem.getVida_util() / 2);
		
		if(usa > vu) {
			valor_taxa = usa;
		}
		if(usa < vu) {
			valor_taxa = vu;
		}
		if(bem.getUsado()  == 0) {
			valor_taxa = (double) bem.getVida_util();
		}
		
		System.out.println(valor_taxa);
		
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
		
		double prv_bug = bem.getVida_util() * 12;
		System.out.println(prv_bug);
		
		if(prv_bug < count) {
			bem.setDa(calvl_residual);
			
		}
		else {
		
		bem.setDa(da);
		}
		
		double vc = bem.getValor_compra() - da;
		
		if(prv_bug < count) {
			bem.setVc(calvl_residual);
		}
		else {
		bem.setVc(vc);
		}
				
		return null;
		}
		
		if(bem.getTurno()== 3) {
			double taxa = (100/ valor_taxa) * 2;
			System.out.println(taxa);
			double calvl_residual = bem.getValor_compra() * (bem.getValor_residual() /100);
			System.out.println(calvl_residual);
			double da = (((bem.getValor_compra() - calvl_residual) * (taxa/ 100))/12)* count;
			
			System.out.println(da);
			
			double prv_bug = bem.getVida_util() * 12;
			
			if(prv_bug < count) {
				bem.setDa(calvl_residual);
			}
			else {
			
			bem.setDa(da);
			}
			
			double vc = bem.getValor_compra() - da;
			
			if(prv_bug < count) {
				bem.setVc(calvl_residual);
			}
			else {
			bem.setVc(vc);
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
			
			bem.setDa(da);
			}
			
			double vc = bem.getValor_compra() - da;
			
			if(prv_bug < count) {
				bem.setVc(calvl_residual);
			}
			else {
			bem.setVc(vc);
			}
					
			return null;
		}
	}
}
