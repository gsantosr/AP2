package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Funcionario;

public class FuncionariosDao {
	private final Connection connection;
	
	public FuncionariosDao(Connection conexao) {
		this.connection = conexao;
	}
	
	//métodos de busca de funcionários
	//o primeiro retorna um ArrayList com todos os funcionarios
	public ArrayList<Funcionario> exibirFuncionarios() throws SQLException {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		String sql = "select * from funcionario";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		while(resultado.next()) {
			Funcionario funcionario = new Funcionario();
			funcionario.setNome(resultado.getString(1));
			funcionario.setCpf(resultado.getString(2));
			funcionario.setEmail(resultado.getString(3));
			funcionario.setTelefone(resultado.getString(4));
			funcionario.setSalario(resultado.getDouble(7));
			funcionario.setComissao(resultado.getDouble(8));

			funcionarios.add(funcionario);
		}
		return funcionarios;	
	}
	
	//o segundo retorna uma ArrayList com os resultados da busca feita em FuncionariosView
	public ArrayList<Funcionario> buscarFuncionario(int criterioDeBusca, String informacaoDigitada) throws SQLException {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		String sql;
		if(criterioDeBusca == 0) {
			sql =  "select * from funcionario where nome like '%"+ informacaoDigitada +"%'";
		}
		else {
			sql =  "select * from funcionario where cpf like '%"+ informacaoDigitada +"%'";
		}
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		while(resultado.next()) {
			Funcionario funcionario = new Funcionario();
			funcionario.setNome(resultado.getString(1));
			funcionario.setCpf(resultado.getString(2));
			funcionario.setEmail(resultado.getString(3));
			funcionario.setTelefone(resultado.getString(4));
			funcionario.setSalario(resultado.getDouble(7));
			funcionario.setComissao(resultado.getDouble(8));
			
			funcionarios.add(funcionario);
			
		}
		
		return funcionarios;		
	}
	//fim dos métodos de busca de funcionários
	
}
