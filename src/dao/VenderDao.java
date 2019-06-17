package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Produto;

public class VenderDao {

	private final Connection connection;	
	
	public VenderDao(Connection connection) {
		this.connection = connection;	
	}
	
	public Produto pegarProduto(int codigoProduto, int qtdComprada) throws SQLException {
		
		String sql =  "select * from produtos where codigo ="+codigoProduto+"";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		while(resultado.next()) {
			Produto produto = new Produto();
			produto.setCodigo(resultado.getInt(1));
			produto.setNome(resultado.getString(2));
			produto.setFabricante(resultado.getString(3));
			produto.setTamanho(resultado.getString(4));
			produto.setTipo(resultado.getString(5));
			produto.setQuantidade(qtdComprada);
			produto.setPreco(qtdComprada * resultado.getDouble(7));
			if(qtdComprada > resultado.getInt(6)) {
				return null;
			}
			else {
				return produto;
			}
		}
		return null;
			
	}
	
	//VERIFICA SE O CPF (CLIENTE) ESTÁ CADASTRADO
	public boolean autenticarCpf(String cpf) throws SQLException {
		String sql = "select * from cliente where cpf = '"+cpf+"'";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
		ResultSet resultado = statement.getResultSet();
		return resultado.next();
	}

}
