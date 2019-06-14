package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.BuscarClientesController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BuscarClientesView extends JFrame {

	private JPanel contentPane;
	private JTextField textBusca;
	private JTable tabelaClientes;
	private MenuPrincipalView janelaMenu;
	private JButton btnRmvCliente;
	private BuscarClientesController controlador = new BuscarClientesController(this);
	private JComboBox comboBox;
	private DefaultTableModel tableModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarClientesView frame = new BuscarClientesView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BuscarClientesView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 722, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textBusca = new JTextField();
		textBusca.setBounds(10, 37, 580, 20);
		contentPane.add(textBusca);
		textBusca.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.preencherResultados();
			}
		});
		btnBuscar.setBounds(607, 36, 89, 23);
		contentPane.add(btnBuscar);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nome do cliente", "Cpf do cliente"}));
		comboBox.setBounds(10, 11, 138, 20);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 686, 311);
		contentPane.add(scrollPane);
		
		tabelaClientes = new JTable();
		tabelaClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "Email", "Telefone", "Gasto total"
			}
		));
		scrollPane.setViewportView(tabelaClientes);	
		
		btnRmvCliente = new JButton("Remover cliente");
		btnRmvCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.removerCliente();
			}
		});
		btnRmvCliente.setBounds(522, 399, 174, 23);
		contentPane.add(btnRmvCliente);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				janelaMenu.setEnabled(true);
				janelaMenu.toFront();
			}
		});
		btnVoltar.setBounds(10, 399, 89, 23);
		contentPane.add(btnVoltar);
		
		tableModel = (DefaultTableModel) tabelaClientes.getModel();
		
		controlador.preencherClientes();
		
		setResizable(false);
	}

	public void setJanelaMenu(MenuPrincipalView janelaMenu) {
		this.janelaMenu = janelaMenu;
	}

	public JButton getBtnRmvCliente() {
		return btnRmvCliente;
	}

	public JTable getTabelaClientes() {
		return tabelaClientes;
	}

	public JTextField getTextBusca() {
		return textBusca;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	

}
