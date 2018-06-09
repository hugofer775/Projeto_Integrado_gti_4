package br.com.projetointegrador.model;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import br.com.projetointegrador.web.BemMB;

public class Bem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Date dt_adiquicao;
	private Double valor_compra;
	private int turno;
	private Double vida_util;
	private Date dt_venda;
	private Double valor_venda;
	private Double usado;
	private Double valor_residual;
	private String tipo_baixa;
	private Long id_usuario;
	private Double da;
	private Double vc;
	private Double goup;
	private String status;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDt_adiquicao() {
		return dt_adiquicao;
	}
	public void setDt_adiquicao(Date dt_adiquicao) {
		this.dt_adiquicao = dt_adiquicao;
	}
	public Double getValor_compra() {
		return valor_compra;
	}
	public void setValor_compra(Double valor_compra) {
		this.valor_compra = valor_compra;
	}
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	public Double getVida_util() {
		return vida_util;
	}
	public void setVida_util(Double vida_util) {
		this.vida_util = vida_util;
	}
	public Date getDt_venda() {
		return dt_venda;
	}
	public void setDt_venda(Date dt_venda) {
		this.dt_venda = dt_venda;
	}
	public Double getValor_venda() {
		return valor_venda;
	}
	public void setValor_venda(Double valor_venda) {
		this.valor_venda = valor_venda;
	}
	public Double getUsado() {
		return usado;
	}
	public void setUsado(Double usado) {
		this.usado = usado;
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Double getValor_residual() {
		return valor_residual;
	}
	public void setValor_residual(Double valor_residual) {
		this.valor_residual = valor_residual;
	}
	public Double getDa() {
		return da;
	}
	public void setDa(Double da) {
		this.da = da;
	}
	public Double getVc() {
		return vc;
	}
	public void setVc(Double vc) {
		this.vc = vc;
	}
	public Double getGoup() {
		return goup;
	}
	public void setGoup(Double goup) {
		this.goup = goup;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTipo_baixa() {
		return tipo_baixa;
	}
	public void setTipo_baixa(String tipo_baixa) {
		this.tipo_baixa = tipo_baixa;
	}
	
	
}
