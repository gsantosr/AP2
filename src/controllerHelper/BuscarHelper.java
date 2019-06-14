package controllerHelper;

import view.BuscarView;
import view.NovoEstoqueView;

import java.util.ArrayList;

import model.Produto;

public class BuscarHelper {
	
	private BuscarView janelaBuscar;
	private NovoEstoqueView janelaEstoque;
	
	public BuscarHelper(BuscarView janelaBuscar) {
		this.janelaBuscar = janelaBuscar;
	}
	
	public BuscarHelper(NovoEstoqueView janelaEstoque) {
		this.janelaEstoque = janelaEstoque;
	}
	
	//Métodos que preenchem a tabela de BuscarView
	public void preencher(ArrayList<Produto> produtos) {
		janelaBuscar.getTableModel().setNumRows(0);
		for(Produto produto : produtos) {
			janelaBuscar.getTableModel().addRow(new Object[] {
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
	
	public void apagarTabela() {
		janelaBuscar.getTableModel().setNumRows(0);
	}
	//Fim dos métodos que preenchem a tabela de BuscarView
	
	//Métodos que preenchem a tabela de NovoEstoqueView
	public void preencherEstoque(ArrayList<Produto> produtos) {
		janelaEstoque.getTableModel().setNumRows(0);
		for(Produto produto : produtos) {
			janelaEstoque.getTableModel().addRow(new Object[] {
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
	
	public void apagarTabelaEstoque() {
		janelaEstoque.getTableModel().setNumRows(0);
	}
	//Fim dos métodos que preenchem a tabela de NovoEstoqueView
}
