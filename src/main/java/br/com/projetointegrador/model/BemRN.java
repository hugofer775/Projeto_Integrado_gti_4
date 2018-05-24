package br.com.projetointegrador.model;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.projetointegrador.web.BemMB;

public class BemRN {
	
	public void gravar(Bem bem) {
			new BemDAO().insert(bem);
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
		double taxa = (100/ bem.getVida_util()) * 1.5;
		System.out.println(taxa);
		double calvl_residual = bem.getValor_compra() * (bem.getValor_residual() /100);
		System.out.println(calvl_residual);
		double da = (((bem.getValor_compra() - calvl_residual) * (taxa/ 100))/12)* count;
		
		System.out.println(da);
		
		bem.setDa(da);
		
		double vc = bem.getValor_compra() - da;
		
		bem.setVc(vc);
				
		return null;
		}
		
		if(bem.getTurno()== 3) {
			double taxa = (100/ bem.getVida_util()) * 2;
			System.out.println(taxa);
			double calvl_residual = bem.getValor_compra() * (bem.getValor_residual() /100);
			System.out.println(calvl_residual);
			double da = (((bem.getValor_compra() - calvl_residual) * (taxa/ 100))/12)* count;
			
			System.out.println(da);
			
			bem.setDa(da);
			
			double vc = bem.getValor_compra() - da;
			
			bem.setVc(vc);
					
			return null;
			}
		else {
			double taxa = 100/ bem.getVida_util();
			System.out.println(taxa);
			double calvl_residual = bem.getValor_compra() * (bem.getValor_residual() /100);
			System.out.println(calvl_residual);
			double da = (((bem.getValor_compra() - calvl_residual) * (taxa/ 100))/12)* count;
			
			System.out.println(da);
			
			bem.setDa(da);
			
			double vc = bem.getValor_compra() - da;
			
			bem.setVc(vc);
					
			return null;
		}
	}
}

