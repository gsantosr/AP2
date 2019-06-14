package controller;

import java.sql.Connection;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;

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

	public VenderHelper getHelper() {
		return helper;
	}

}
