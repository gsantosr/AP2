package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Cliente;



public class ClienteDao {
	private final Connection connection;
	
	public ClienteDao(Connection connection) {
		this.connection = connection;
	}
	
	public void addCliente(Cliente cliente) throws SQLException{
		String sql = "insert into cliente(nome, cpf, telefone, email) values (?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getCpf());
		statement.setString(3, cliente.getTelefone());
		statement.setString(4, cliente.getEmail());
		statement.execute();
	}

}