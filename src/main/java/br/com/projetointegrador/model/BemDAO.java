package br.com.projetointegrador.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.sun.corba.se.impl.ior.GenericTaggedComponent;

import br.com.projetointegrador.util.ConnectionFactory;

public class BemDAO extends ConnectionFactory {

	private static final long serialVersionUID = 1L;
	
	public void insert(Bem bem) {
		
		String sql = "INSERT INTO bem(nome, dt_adiquicao, valor_compra, turno, vida_util, usado, valor_residual, id_usuario)" + 
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection con = open();
		PreparedStatement ps = null;
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, bem.getNome());
			TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo")); 
			ps.setDate(2, new java.sql.Date(bem.getDt_adiquicao().getTime()));
			System.err.println("aqui2");
			ps.setDouble(3, bem.getValor_compra());
			System.err.println("aqui3");
			ps.setInt(4, bem.getTurno());
			ps.setDouble(5, bem.getVida_util());
			System.err.println("aqui2");
			ps.setDouble(6, bem.getUsado());
			ps.setDouble(7, bem.getValor_residual());
			ps.setLong(8, Login.getId());
			System.err.println("aqui");
			ps.executeUpdate();
			System.err.println("dsds");
		} catch (Exception e) {
			System.err.println("Erro no insert do DAO: " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(con, ps);
		}
	}
	
	public List<Bem> selectAll(){
		List<Bem> lsBem = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, nome, dt_adiquicao, valor_compra, turno, vida_util, dt_baixa, valor_venda, usado, valor_residual, tipo_baixa, id_usuario FROM bem ORDER BY id";
		
		try {
			con = open();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			lsBem = new ArrayList<Bem>();
			while (rs.next()) {
				Bem e = new Bem();
				e.setId(rs.getLong("id"));
				e.setNome(rs.getString("nome"));
				e.setDt_adiquicao(rs.getDate("dt_adiquicao"));
				e.setValor_compra(rs.getDouble("valor_compra"));
				e.setTurno(rs.getInt("turno"));
				e.setVida_util(rs.getDouble("vida_util"));
				e.setDt_venda(rs.getDate("dt_baixa"));
				e.setValor_venda(rs.getDouble("valor_venda"));
				e.setUsado(rs.getDouble("usado"));
				e.setValor_residual(rs.getDouble("valor_residual"));
				e.setTipo_baixa(rs.getString("tipo_baixa"));
				e.setId_usuario(rs.getLong("id_usuario"));
				//BemDAO.da(rs.getDate("dt_adiquicao"), rs.getDate("dt_venda") );
				BemRN.da(e);
				lsBem.add(e);
			}
		} catch (Exception e) {
			System.err.println("Erro no selectAll do DAO: " + e.getMessage());
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		
		return lsBem;
	}
	
	public void update(Bem bem) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql= "UPDATE bem SET nome = ?, dt_adiquicao = ?, valor_compra = ?, turno = ?, vida_util = ?, dt_baixa = ?, valor_venda = ?, usado = ?, valor_residual = ?, tipo_baixa = ?" + 
				"WHERE id = ?";
		
		try { 
			con = open();
			ps = con.prepareStatement(sql);
			ps.setString(1, bem.getNome());
			ps.setDate(2, new java.sql.Date(bem.getDt_adiquicao().getTime()));
			ps.setDouble(3, bem.getValor_compra());
			ps.setInt(4, bem.getTurno());
			ps.setDouble(5, bem.getVida_util());
			
			if(bem.getDt_venda() != null) {
			ps.setDate(6, new java.sql.Date(bem.getDt_venda().getTime()));
			}else {
				ps.setDate(6, (Date) bem.getDt_venda());
			}
			ps.setDouble(7, bem.getValor_venda());
			ps.setDouble(8, bem.getUsado());
			ps.setDouble(9, bem.getValor_residual());
			ps.setString(10, bem.getTipo_baixa());
			ps.setLong(11, bem.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("Erro no insert do DAO: " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(con, ps);
		}
	}
	
	public void delete(Bem bem) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM bem WHERE id = ?";
		try {
			con = open();
			ps = con.prepareStatement(sql);
			ps.setLong(1, bem.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("Erro no delete do DAO: " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(con, ps);
		}
	}
	
}
					
