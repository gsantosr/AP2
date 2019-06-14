package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.VenderController;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class CarrinhoView extends JFrame {

	private JPanel contentPane;
	private JTable tabelaCarrinho;
	private JTextField textCodigoProduto;
	private BuscarView janelaBuscar;
	private JTextField textQtd;
	private int linhas;
	private VenderController controlador = new VenderController(getThis());
	private JComboBox comboBox;
	private DefaultTableModel tableModel;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarrinhoView frame = new CarrinhoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CarrinhoView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(200, 300, 936, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 105, 861, 226);
		contentPane.add(scrollPane);
		
		linhas = 0;
		tabelaCarrinho = new JTable();
		tabelaCarrinho.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Fabricante", "Tamanho", "Tipo", "Quantidade", "Pre\u00E7o"
			}
		));
		scrollPane.setViewportView(tabelaCarrinho);
		
		textCodigoProduto = new JTextField();
		textCodigoProduto.setBounds(31, 34, 542, 27);
		contentPane.add(textCodigoProduto);
		textCodigoProduto.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.btnConfirmar();
			}
		});
		btnNewButton.setBounds(775, 34, 117, 27);
		contentPane.add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Adicionar produto no carrinho", "Remover produto do carrinho"}));
		comboBox.setBounds(30, 72, 228, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Cancelar compra");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaBuscar.getBtnSair().setEnabled(true);
				janelaBuscar.getBtnNovaCompra().setEnabled(true);
				janelaBuscar.getBtnAdicionar02().setEnabled(false);
				dispose();
				janelaBuscar.getJanelaMenu().toFront();
				janelaBuscar.toFront();

			}
		});
		btnNewButton_1.setBounds(53, 342, 206, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Proseguir para m\u00E9todo de pagamento");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormaDePagamentoView janelaFormaDePagamento = new FormaDePagamentoView();
				janelaFormaDePagamento.setJanelaCarrinho(getThis());
				getThis().setVisible(false);
				janelaFormaDePagamento.setVisible(true);
				janelaBuscar.setEnabled(true);
				janelaBuscar.setVisible(false);
				janelaBuscar.getJanelaMenu().toFront();
				janelaFormaDePagamento.toFront();
			}
		});
		btnNewButton_2.setBounds(635, 342, 253, 36);
		contentPane.add(btnNewButton_2);
		
		textQtd = new JTextField();
		textQtd.setBounds(583, 34, 182, 27);
		contentPane.add(textQtd);
		textQtd.setColumns(10);
		
		JLabel lblCdigoDoProduto = new JLabel("C\u00F3digo do produto");
		lblCdigoDoProduto.setBounds(31, 11, 127, 14);
		contentPane.add(lblCdigoDoProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade ");
		lblQuantidade.setBounds(583, 11, 117, 14);
		contentPane.add(lblQuantidade);
		
		tableModel = (DefaultTableModel) tabelaCarrinho.getModel();
		tableModel.setNumRows(0);
		
		setResizable(false);

	}
	
	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public BuscarView getJanelaBuscar() {
		return janelaBuscar;
	}

	public void setJanelaBuscar(BuscarView janelaBuscar) {
		this.janelaBuscar = janelaBuscar;
	}
	
	public CarrinhoView getThis() {
		return this;
	}

	public JTextField getTextCodigoProduto() {
		return textCodigoProduto;
	}

	public JTable getTabelaCarrinho() {
		return tabelaCarrinho;
	}
	
	public void novaLinha() {
		this.linhas++;
	}
	
	public void tirarLinha() {
		this.linhas--;
	}

	public JTextField getTextQtd() {
		return textQtd;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public VenderController getControlador() {
		return controlador;
	}

	public void testar() {
		System.out.println("carrinho view");
	}
}
