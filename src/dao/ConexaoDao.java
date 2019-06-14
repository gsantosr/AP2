package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDao {
	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/loja?useTimezone=true&serverTimezone=UTC";
		Connection conexao = DriverManager.getConnection(url,"root","admin");
		return conexao;
	}
}