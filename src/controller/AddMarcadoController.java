package controller;

import javax.swing.JOptionPane;

import controllerHelper.VenderHelper;
import view.BuscarView;
import view.CarrinhoView;
import view.QtdCarrinhoView;

public class AddMarcadoController {
	
	private QtdCarrinhoView janelaQuantidade;
	private BuscarView janelaBusca;
	private VenderHelper helper;
	
	public AddMarcadoController(QtdCarrinhoView janelaQuantidade, BuscarView janelaBuscar, CarrinhoView janelaCarrinho) {
		this.janelaQuantidade = janelaQuantidade;
		this.janelaBusca = janelaBuscar;
		helper = new VenderHelper(janelaBuscar, janelaCarrinho);
		}
	
	public void btnConfirmar02() {
		helper.transferir(Integer.parseInt(janelaQuantidade.getTextQuantidade02().getText()), 
				janelaBusca.getTableProdutos().getSelectedRow());
	}
	
	
}
