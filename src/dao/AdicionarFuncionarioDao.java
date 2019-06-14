package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Funcionario;

public class AdicionarFuncionarioDao {
	private Funcionario funcionario;
	private Connection connection;
	
	public AdicionarFuncionarioDao(Connection conexao) {
		this.connection = conexao;
	}
	
	public void addFuncionario (Funcionario funcionario) throws SQLException {
		String sql = "insert into Funcionario(nome, cpf, telefone, email, login, senha, salario) values (?, ?, ?, ?, ?, ?, 1500)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, funcionario.getNome());
		statement.setString(2, funcionario.getCpf());
		statement.setString(3, funcionario.getTelefone());
		statement.setString(4, funcionario.getEmail());
		statement.setString(5, funcionario.getUsuario().getLogin());
		statement.setString(6, funcionario.getUsuario().getSenha());
		statement.execute();
	}
}
