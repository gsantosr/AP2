package controllerHelper;

import view.BuscarView;
import view.CarrinhoView;
import view.QtdCarrinhoView;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Produto;

public class VenderHelper {
	
	private CarrinhoView janelaVender;
	private BuscarView janelaBuscar;
	
	public VenderHelper(CarrinhoView janelaVender) {
		this.janelaVender = janelaVender;
	}
	
	public VenderHelper(BuscarView janelaBuscar, CarrinhoView janelaVender) {
		this.janelaBuscar = janelaBuscar;
		this.janelaVender = janelaVender;
	}
	
	//M�TODOS QUE PREENCHEM TABELA NO BUSCAR C�DIGO
	public void adicionarNaVenda(Produto produto) {
		if(produto == null) {
			JOptionPane.showMessageDialog(null, "Quantidade de produtos no estoque insuficiente para atender o pedido.",
					"Estoque insuficiente", JOptionPane.ERROR_MESSAGE);
		}
		else {
			janelaVender.novaLinha();
	
			janelaVender.getTableModel().addRow(new Object[] {
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
	
	public void removerNaVenda(int codigoProduto, int qtd) {
		int posicao = 0;
		int quantidade = 0;
		boolean encontrou = false;
		
		for(int i = 0; i < janelaVender.getLinhas(); i++) {
			String valor = (String) janelaVender.getTabelaCarrinho().getValueAt(i, 0);
			if(codigoProduto == Integer.parseInt(valor)) {
				encontrou = true;
				posicao = i;
				quantidade = Integer.parseInt((String) janelaVender.getTabelaCarrinho().getValueAt(posicao, 5));
			}
		}
		
		if(encontrou) {
			if(qtd >= quantidade) {
				janelaVender.getTableModel().removeRow(posicao);
				janelaVender.tirarLinha();
				
			}
			else {
				janelaVender.getTableModel().setValueAt(quantidade - qtd, posicao, 5);
			}
		}
	}
	//FIM DOS M�TODOS QUE PREENCHEM TABELA NO BUSCAR C�DIGO
	
	//M�TODO QUE PREENCHE A TABELA AO SELECIONAR
	public void transferir(int quantidade, int linha) {
		Produto produto = new Produto();
		produto.setCodigo((int)janelaBuscar.getTableModel().getValueAt(linha, 0));
        produto.setNome((String)janelaBuscar.getTableModel().getValueAt(linha, 1));
        produto.setFabricante((String)janelaBuscar.getTableModel().getValueAt(linha, 2));
        produto.setTamanho((String)janelaBuscar.getTableModel().getValueAt(linha, 3));
        produto.setTipo((String)janelaBuscar.getTableModel().getValueAt(linha, 4));
        produto.setQuantidade(quantidade);
        produto.setPreco(quantidade * (double)janelaBuscar.getTableModel().getValueAt(linha, 6));
		
		janelaVender.getTableModel().addRow(new Object[] {
				produto.getCodigo(),
	            produto.getNome(),
	            produto.getFabricante(),
	            produto.getTamanho(),
	            produto.getTipo(),
	            produto.getQuantidade(),
	            produto.getPreco(),
		});
		janelaVender.novaLinha();
	}
	
	//M�TODO QUE SOMA TODOS OS PRE�OS DOS PRODUTOS QUE EST�O DO CARRINHO
	//CALCULA A CONTA QUE O CLIENTE DEVE PAGAR
	public double precosCarrinho() {
		double valorTotal = 0.0;
		for(int i = 0; i < janelaVender.getLinhas(); i++) {
			valorTotal += (double) janelaVender.getTableModel().getValueAt(i, 6);
		}
		return valorTotal;
	}
}
