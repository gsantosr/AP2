package controller;

import java.sql.Connection;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controllerHelper.BuscarHelper;
import controllerHelper.VenderHelper;
import dao.ProdutosDao;
import dao.ConexaoDao;
import dao.GerenteDao;
import dao.VenderDao;
import model.Produto;
import view.BuscarView;
import view.CarrinhoView;

public class VenderController {
	
	// modificar de acordo com a janela de venda
	private CarrinhoView janelaCarrinho;
	private VenderHelper helper;
	
	public VenderController(CarrinhoView janelaCarrinho) {
		this.janelaCarrinho = janelaCarrinho;
		helper = new VenderHelper(janelaCarrinho);
	}
	
	public void btnConfirmar() {
		int codigoProduto = Integer.parseInt(janelaCarrinho.getTextCodigoProduto().getText());
		int quantidade = Integer.parseInt(janelaCarrinho.getTextQtd().getText());
		int comboBox = janelaCarrinho.getComboBox().getSelectedIndex();
		if(quantidade > 0) {
			if(comboBox == 0) {
				Connection conexao;
				try {
					conexao = new ConexaoDao().getConnection();
					VenderDao venderDao = new VenderDao(conexao);
					helper.adicionarNaVenda(venderDao.pegarProduto(codigoProduto, quantidade));
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			else {
				helper.removerNaVenda(codigoProduto, quantidade);
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"A quantidade de produtos deve ser positiva",
					"Quantidade inválida",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//Dar a baixa no estoque quando confirmar a venda.
	public void baixaEstoque() {
		Connection conexao;
		try {
			conexao = new ConexaoDao().getConnection();
			ProdutosDao produtosDao = new ProdutosDao(conexao);
			for(int i = 0 ; i <= janelaCarrinho.getLinhas() ; i++) {
				int codigo = (int) janelaCarrinho.getTabelaCarrinho().getValueAt(i, 0);
				int qtd = (int) janelaCarrinho.getTabelaCarrinho().getValueAt(i, 5);
				System.out.println(codigo);
				System.out.println(qtd);
				produtosDao.removerEstoque(codigo, qtd);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public VenderHelper getHelper() {
		return helper;
	}

}
