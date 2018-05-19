package br.com.projetointegrador.model;


import java.io.Serializable;
import java.util.Date;

public class Bem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Date dt_adiquicao;
	private Double valor_compra;
	private int turno;
	private int vida_util;
	private Date dt_venda;
	private Double valor_venda;
	private Double usado;
	private Long id_usuario;
	
	
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
	public int getVida_util() {
		return vida_util;
	}
	public void setVida_util(int vida_util) {
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
}
