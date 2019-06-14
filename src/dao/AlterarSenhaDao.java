package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Usuario;

public class AlterarSenhaDao {
	private final Connection connection;

	public AlterarSenhaDao(Connection connection) {
		this.connection = connection;
	}

	public void mudarSenhaNoBanco(String senha) throws SQLException {
		String sql = "update admin set senha = ? where login = 'eletrica'";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, senha);
		statement.execute();
		JOptionPane.showMessageDialog(null, "Senha alterada com sucesso");
	}

	public void alterarSenha(String login, String senha, int tipoUsuario) throws SQLException {
		if (tipoUsuario == 1) {
			String sql1 = "update admin set senha = ? where login = ?";
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setString(1, senha);
			statement1.setString(2, login);
			statement1.execute();
			JOptionPane.showMessageDialog(null, "Senha alterada com sucesso");
		} else if (tipoUsuario == 2) {
			String sql1 = "update gerente set senha = ? where login = ?";
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setString(1, senha);
			statement1.setString(2, login);
			statement1.execute();
			JOptionPane.showMessageDialog(null, "Senha alterada com sucesso");
		}
	}

}
