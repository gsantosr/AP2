//esse método preenche a tabela de BuscarClientesView

package controllerHelper;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Cliente;
import view.BuscarClientesView;

public class ClientesHelper {
	
	private BuscarClientesView janelaBuscarClientes;
	
	public ClientesHelper(BuscarClientesView janela) {
		janelaBuscarClientes = janela;
	}
	
	public void preencher(ArrayList<Cliente> clientes) {
		janelaBuscarClientes.getTableModel().setNumRows(0);
		for(Cliente cliente : clientes) {
			janelaBuscarClientes.getTableModel().addRow(new Object[] {
					cliente.getNome(),
					cliente.getCpf(),
					cliente.getTelefone(),
					cliente.getEmail(),
					cliente.getTotalGasto(),
			});
		}
	}
	
	public void apagarTabela() {
		janelaBuscarClientes.getTableModel().setNumRows(0);
	}
	
	
	//remove os clientes na tabela da classe BuscarClienteView
	public void removerCliente(int linhaSelecionada) {
		janelaBuscarClientes.getTableModel().removeRow(linhaSelecionada);
	}
}
