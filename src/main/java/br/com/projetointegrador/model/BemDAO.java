package br.com.projetointegrador.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.impl.ior.GenericTaggedComponent;

import br.com.projetointegrador.util.ConnectionFactory;

public class BemDAO extends ConnectionFactory {

	private static final long serialVersionUID = 1L;
	
	public void insert(Bem bem) {
		
		String sql = "INSERT INTO bem(nome, dt_adiquicao, valor_compra, turno, vida_util, usado, id_usuario)" + 
				"VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection con = open();
		PreparedStatement ps = null;
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, bem.getNome());
			ps.setDate(2, new java.sql.Date(bem.getDt_adiquicao().getTime()));
			System.err.println("aqui2");
			ps.setDouble(3, bem.getValor_compra());
			System.err.println("aqui3");
			ps.setInt(4, bem.getTurno());
			ps.setInt(5, bem.getVida_util());
			System.err.println("aqui2");
			ps.setDouble(6, bem.getUsado());
			ps.setLong(7, Login.getId());
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
		String sql = "SELECT id, nome, dt_adiquicao, valor_compra, turno, vida_util, dt_venda, valor_venda, usado, id_usuario FROM bem";
		
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
				e.setVida_util(rs.getInt("vida_util"));
				e.setDt_venda(rs.getDate("dt_venda"));
				e.setValor_venda(rs.getDouble("valor_venda"));
				e.setUsado(rs.getDouble("usado"));
				e.setId_usuario(rs.getLong("id_usuario"));
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
}
