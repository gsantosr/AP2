package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class RemoverDao {

	private Connection connection;
	
	public RemoverDao(Connection conexao) {
		this.connection = conexao;
	}
	
	public void removerFuncionario (String cpf) throws SQLException {
		String sql = "delete from funcionario where cpf = '"+cpf+"'";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
		connection.close();
		
	}
	
	public void removerGerente (String cpf) throws SQLException {
		String sql = "delete from gerente where cpf = '"+cpf+"'";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
		connection.close();
		
	}
	public void removerCliente(String cpf) {
		String sql = "delete from cliente where cpf = '" + cpf + "'";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados", "Erro SQL", JOptionPane.ERROR_MESSAGE);
		}

	}


	//esse método remove o produto do banco de dados
	public void removerProduto(int codigoProduto) {
		String sql = "delete from produtos where codigo = " + codigoProduto + "";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados", "Erro SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
}


