package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Gerente;

public class AdicionarGerenteDao {

	private Gerente gerente;
	private Connection connection;
	
	public AdicionarGerenteDao(Connection conexao) {
		this.connection = conexao;
	}
	
	public void addGerente (Gerente gerente) throws SQLException {
		String sql = "insert into gerente(nome, cpf, telefone, email, login, senha, salario) values (?, ?, ?, ?, ?, ?, 5000)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, gerente.getNome());
		statement.setString(2, gerente.getCpf());
		statement.setString(3, gerente.getTelefone());
		statement.setString(4, gerente.getEmail());
		statement.setString(5, gerente.getUsuario().getLogin());
		statement.setString(6, gerente.getUsuario().getSenha());
		statement.execute();

	}
	
}