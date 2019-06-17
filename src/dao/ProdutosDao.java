package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Funcionario;
import model.Produto;
import model.Usuario;

public class ProdutosDao {
	private final Connection connection;
	// private JanelaAddProdutos janelaAddProdutos;

	public ProdutosDao(Connection connection) {
		this.connection = connection;
	}

	// métodos de busca de produtos
	public ArrayList<Produto> exibirProdutos() throws SQLException, Exception {
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		String sql = "select * from produtos";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		while (resultado.next()) {
			Produto produto = new Produto();
			produto.setCodigo(resultado.getInt(1));
			produto.setNome(resultado.getString(2));
			produto.setFabricante(resultado.getString(3));
			produto.setTamanho(resultado.getString(4));
			produto.setTipo(resultado.getString(5));
			produto.setQuantidade(resultado.getInt(6));
			produto.setPreco(resultado.getDouble(7));

			produtos.add(produto);
		}
		return produtos;
	}

	public ArrayList<Produto> buscarProduto(int criterioDeBusca, String informacaoDigitada) throws SQLException {
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		String sql;
		if (criterioDeBusca == 0) {
			sql = "select * from produtos where nome like '%" + informacaoDigitada + "%'";
		} else {
			int codigo = Integer.parseInt(informacaoDigitada);
			sql = "select * from produtos where codigo =" + codigo + "";
		}
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		while (resultado.next()) {
			Produto produto = new Produto();
			produto.setCodigo(resultado.getInt(1));
			produto.setNome(resultado.getString(2));
			produto.setFabricante(resultado.getString(3));
			produto.setTamanho(resultado.getString(4));
			produto.setTipo(resultado.getString(5));
			produto.setQuantidade(resultado.getInt(6));
			produto.setPreco(resultado.getDouble(7));

			produtos.add(produto);

		}

		return produtos;
	}

	public void adicionarProduto(Produto produto) throws SQLException {
		String sql = "insert into produtos(nome, fabricante, tamanho, tipo, quantidade, preco) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, produto.getNome());
		statement.setString(2, produto.getFabricante());
		statement.setString(3, produto.getTamanho());
		statement.setString(4, produto.getTipo());
		statement.setInt(5, produto.getQuantidade());
		statement.setDouble(6, produto.getPreco());
		statement.execute();
	}
	
	public void removerEstoque(int codigoProduto, int qtdComprada) throws SQLException {		
		String sql =  "update produtos set quantidade = quantidade - "+qtdComprada+" where codigo ="+codigoProduto+"";
	
	PreparedStatement statement = connection.prepareStatement(sql);
	statement.execute();
		
	}
	

	public void atualizarEstoque(int codigoProduto, int qtdNova) throws SQLException {	
		System.out.println("sql");
		System.out.println(codigoProduto);
		System.out.println(qtdNova);
		String sql =  "update produtos set quantidade = "+qtdNova+" where codigo ="+codigoProduto+"";
	
	PreparedStatement statement = connection.prepareStatement(sql);
	statement.execute();
	}
	
}
