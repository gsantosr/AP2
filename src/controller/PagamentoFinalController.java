package controller;

import java.sql.Connection;

import dao.ProdutosDao;
import dao.ConexaoDao;
import dao.VenderDao;
import model.Produto;
import view.PagamentoFinalView;

public class PagamentoFinalController {
	
	PagamentoFinalView janelaPagamentoFinal;
	
	public PagamentoFinalController(PagamentoFinalView janela) {
		janelaPagamentoFinal = janela;
	}
	
	//vê se o cpf do cliente está mesmo cadastrado no banco
	public boolean autenticarCpf() {
		Connection conexao;
		try {
			conexao = new ConexaoDao().getConnection();
			VenderDao venderDao = new VenderDao(conexao);
			return venderDao.autenticarCpf(janelaPagamentoFinal.getTextCpfCadastrado().getText());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//preenche tabela com todo os produtos selecionados no carrinho
	public void produtosComprados() {
		for(int i = 0; i < janelaPagamentoFinal.getJanelaFormaDePagamento().getJanelaCarrinho().getLinhas(); i++) {
			Produto produto = new Produto();
			produto.setCodigo((int)janelaPagamentoFinal.getJanelaFormaDePagamento().getJanelaCarrinho().getTableModel().getValueAt(i, 0));
	        produto.setNome((String)janelaPagamentoFinal.getJanelaFormaDePagamento().getJanelaCarrinho().getTableModel().getValueAt(i, 1));
	        produto.setFabricante((String)janelaPagamentoFinal.getJanelaFormaDePagamento().getJanelaCarrinho().getTableModel().getValueAt(i, 2));
	        produto.setTamanho((String)janelaPagamentoFinal.getJanelaFormaDePagamento().getJanelaCarrinho().getTableModel().getValueAt(i, 3));
	        produto.setTipo((String)janelaPagamentoFinal.getJanelaFormaDePagamento().getJanelaCarrinho().getTableModel().getValueAt(i, 4));
	        produto.setQuantidade((int)janelaPagamentoFinal.getJanelaFormaDePagamento().getJanelaCarrinho().getTableModel().getValueAt(i, 5));
	        produto.setPreco((double)janelaPagamentoFinal.getJanelaFormaDePagamento().getJanelaCarrinho().getTableModel().getValueAt(i, 6));
			
			janelaPagamentoFinal.getTableModel().addRow(new Object[] {
					produto.getCodigo(),
		            produto.getNome(),
		            produto.getFabricante(),
		            produto.getTamanho(),
		            produto.getTipo(),
		            produto.getQuantidade(),
		            produto.getPreco(),
			});
		}
	}
	
}
