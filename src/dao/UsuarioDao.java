package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDao {
	private final Connection connection;
	
	public UsuarioDao(Connection connection) {
		this.connection = connection;	
	}

	public int autenticarUsuario(Usuario usuario) throws SQLException {
		String sql1 = "select * from admin where login = ? and senha = ?";
		PreparedStatement statement1 = connection.prepareStatement(sql1);
		statement1.setString(1, usuario.getLogin());
		statement1.setString(2, usuario.getSenha());
		statement1.execute();
		ResultSet resultado1 = statement1.getResultSet();
		if(resultado1.next() == true) {
			connection.close();
			return 1;
		}
		String sql2 = "select * from gerente where login = ? and senha = ?";
		
		PreparedStatement statement2 = connection.prepareStatement(sql2);
		statement2.setString(1, usuario.getLogin());
		statement2.setString(2, usuario.getSenha());
		statement2.execute();
		ResultSet resultado2 = statement2.getResultSet();
		if(resultado2.next() == true) {
			connection.close();
			return 2;
		}
		String sql3 = "select * from funcionario where login = ? and senha = ?";
		PreparedStatement statement3 = connection.prepareStatement(sql3);
		statement3.setString(1, usuario.getLogin());
		statement3.setString(2, usuario.getSenha());
		statement3.execute();
		ResultSet resultado3 = statement3.getResultSet();
		if(resultado3.next() == true) {
			connection.close();
			return 3;
		}
		connection.close();
		return 0;
	}
	

}
