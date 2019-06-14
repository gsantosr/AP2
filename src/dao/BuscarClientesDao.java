package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;
import model.Funcionario;

public class BuscarClientesDao {
	private final Connection connection;
	
	public BuscarClientesDao(Connection conexao) {
		this.connection = conexao;
	}
	
	//MÉTODOS DE BUSCA DE CLIENTES
	//o primeiro retorna uma ArrayList com todos os clientes
	public ArrayList<Cliente> exibirClientes() throws SQLException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "select * from cliente";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		while(resultado.next()) {
			Cliente cliente = new Cliente();
			cliente.setNome(resultado.getString(1));
			cliente.setCpf(resultado.getString(2));
			cliente.setEmail(resultado.getString(3));
			cliente.setTelefone(resultado.getString(4));
			cliente.setTotalGasto(resultado.getDouble(5));

			clientes.add(cliente);
		}
		return clientes;	
	}
	
	//o segundo retorna os resultados da busca
	public ArrayList<Cliente> buscarClientes(int criterioDeBusca, String informacaoDigitada) throws SQLException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		String sql;
		if(criterioDeBusca == 0) {
			sql =  "select * from cliente where nome like '%"+ informacaoDigitada +"%'";
		}
		else {
			sql =  "select * from cliente where cpf like '%"+ informacaoDigitada +"%'";
		}
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		while(resultado.next()) {
			Cliente cliente = new Cliente();
			cliente.setNome(resultado.getString(1));
			cliente.setCpf(resultado.getString(2));
			cliente.setEmail(resultado.getString(3));
			cliente.setTelefone(resultado.getString(4));
			cliente.setTotalGasto(resultado.getDouble(5));

			clientes.add(cliente);
		}
		
		return clientes;		
	}
	//FIM DOS MÉTODOS DE BUSCA
}
