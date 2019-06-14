package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controllerHelper.BuscarHelper;
import dao.ProdutosDao;
import dao.RemoverDao;
import dao.ConexaoDao;
import model.Produto;
import view.BuscarView;
import view.NovoAddProdutoView;
import view.NovoEstoqueView;

public class BuscarController {
	
	private BuscarView janelaBuscar;
	private NovoEstoqueView janelaEstoque;
	private BuscarHelper helper;
	
	public BuscarController(BuscarView janelaBuscar) {
		this.janelaBuscar = janelaBuscar;
		helper = new BuscarHelper(janelaBuscar);
	}
	
	public BuscarController(NovoEstoqueView janelaEstoque) {
		this.janelaEstoque = janelaEstoque;
		helper = new BuscarHelper(janelaEstoque);
	}
	
	//MÉTODOS DE BUSCA DE UMA NOVA COMPRA (BuscarView)
	//metodo chamado quando a janela de busca é aberta ou quando é necessário exibir todos os produtos
	//tabela será preenchida com todos os produtos
	public void preencherTudo() {
		Connection conexao;
		try {
			conexao = new ConexaoDao().getConnection();
			ProdutosDao buscarDao = new ProdutosDao(conexao);
			ArrayList<Produto> produtos = buscarDao.exibirProdutos();
			helper.preencher(produtos);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//método chamado quando o botão busca é apertado
	//tabela será preenchida com os resultados da pesquisa

	public void preencherResultados() {
		Connection conexao;
		try {
			conexao = new ConexaoDao().getConnection();
			ProdutosDao buscarDao = new ProdutosDao(conexao);
			ArrayList<Produto> produtos = buscarDao.buscarProduto(janelaBuscar.getCriterioDeBusca().getSelectedIndex(),
					janelaBuscar.getTextBusca().getText());
			helper.preencher(produtos);
		} 
		catch(SQLSyntaxErrorException e) {
			helper.apagarTabela();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	//FIM DOS MÉTODOS DE BUSCA DE UMA NOVA COMPRA (BuscarView)
	
	//MÉTODOS DE BUSCA EM ESTOQUE (NovoEstoqueView)
	public void preencherTudoEstoque() {
		Connection conexao;
		try {
			conexao = new ConexaoDao().getConnection();
			ProdutosDao buscarDao = new ProdutosDao(conexao);
			ArrayList<Produto> produtos = buscarDao.exibirProdutos();
			helper.preencherEstoque(produtos);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void preencherResultadosEstoque() {
		Connection conexao;
		try {
			conexao = new ConexaoDao().getConnection();
			ProdutosDao buscarDao = new ProdutosDao(conexao);
			ArrayList<Produto> produtos = buscarDao.buscarProduto(janelaEstoque.getComboBox().getSelectedIndex(), janelaEstoque.getTextBusca().getText());
			helper.preencherEstoque(produtos);
		} 
		catch(SQLSyntaxErrorException e) {
			helper.apagarTabela();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	//FIM MÉTODOS DE BUSCA EM ESTOQUE (NovoEstoqueView)
	
	//Método para a modificação da quantidade de produto em estoque
	public void attQuantidade() {
		int novaQtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade desse produto"));
		int linhaSelecionada = janelaEstoque.getTabelaEstoque().getSelectedRow();
		int codigoProduto = (int) janelaEstoque.getTabelaEstoque().getValueAt(linhaSelecionada, 0);
		System.out.println("agora");
		System.out.println(codigoProduto);
		Connection conexao;
		try {
			conexao = new ConexaoDao().getConnection();
			ProdutosDao buscarDao = new ProdutosDao(conexao);
			if(novaQtd >= 0) {
				buscarDao.atualizarEstoque(codigoProduto, novaQtd);
			}
			else {
				JOptionPane.showMessageDialog(null, "Digite um valor positivo", "Erro de validação", JOptionPane.ERROR_MESSAGE);
			}
			ArrayList<Produto> produtos = buscarDao.exibirProdutos();
			helper.preencherEstoque(produtos);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//APAGA O PRODUTO QUANDO VOCÊ CLICA NO BOTÃO REMOVER EM NovoEstoqueView
	public void removerDeVez() {
		int linhaSelecionada = janelaEstoque.getTabelaEstoque().getSelectedRow();
		if (linhaSelecionada != -1) {
			janelaEstoque.getTableModel().removeRow(linhaSelecionada);
			try{
				Connection conexao = new ConexaoDao().getConnection();
				RemoverDao removerDao = new RemoverDao(conexao);
				removerDao.removerProduto(linhaSelecionada);
				preencherResultadosEstoque();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Você deve selecionar uma linha antes.");
		}
	}
	
	//MÉTODO QUE ADICIONA UM NOVO PRODUTO
	public void adicionarProdutos(NovoAddProdutoView addProduto) {
		
		Connection conexao;	
			if(!addProduto.getTextNome().getText().trim().isEmpty() 
				&& !addProduto.getTextFabricante().getText().trim().isEmpty() 
				&& !addProduto.getTextTamanho().getText().trim().isEmpty() 
				&& !addProduto.getTextTipo().getText().trim().isEmpty()  
				&& !addProduto.getTextQuantidade().getText().trim().isEmpty() 
				&& !addProduto.getTextPreco().getText().trim().isEmpty()) {
			
				String nome = addProduto.getTextNome().getText();
				String fabricante = addProduto.getTextFabricante().getText();
				String tamanho = addProduto.getTextTamanho().getText();
				String tipo = addProduto.getTextTipo().getText();
				int quantidade = Integer.parseInt(addProduto.getTextQuantidade().getText());
				double preco = Double.parseDouble(addProduto.getTextPreco().getText());
				Produto produto = new Produto(nome, fabricante, tamanho, tipo, quantidade, preco);
				try {
				conexao = new ConexaoDao().getConnection();
				ProdutosDao produtosDao = new ProdutosDao(conexao);
				produtosDao.adicionarProduto(produto);
				JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				} catch(Exception e) {
				e.printStackTrace();
				}
			}
		else {
			JOptionPane.showMessageDialog(addProduto, "Digite um valor válido no campo", "Erro de validação", JOptionPane.ERROR_MESSAGE);
		}
	}

}
