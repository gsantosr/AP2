package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.BuscarController;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NovoEstoqueView extends JFrame {

	private JPanel contentPane;
	private JTextField textBusca;
	private JTable tabelaEstoque;
	private OpcoesAdicionaisView janelaOpcoesAdicionais;
	private BuscarController controlador = new BuscarController(this);
	private DefaultTableModel tableModel;
	private JComboBox comboBox;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoEstoqueView frame = new NovoEstoqueView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NovoEstoqueView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(200, 100, 879, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblControleDeEstoque = new JLabel("Controle de Estoque");
		lblControleDeEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		lblControleDeEstoque.setForeground(Color.WHITE);
		lblControleDeEstoque.setFont(new Font("Arial", Font.PLAIN, 40));
		lblControleDeEstoque.setBounds(146, 0, 569, 59);
		contentPane.add(lblControleDeEstoque);
		
		textBusca = new JTextField();
		textBusca.setBounds(84, 71, 579, 30);
		textBusca.setColumns(10);
		contentPane.add(textBusca);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaOpcoesAdicionais.setEnabled(true);
				dispose();
				janelaOpcoesAdicionais.toFront();
			}
		});
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nome do produto", "C\u00F3digo do produto"}));
		comboBox.setBounds(84, 107, 148, 20);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 138, 695, 318);
		contentPane.add(scrollPane);
		
		tabelaEstoque = new JTable();
		tabelaEstoque.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Fabricante", "Tamanho", "Quantidade", "Tipo", "Pre\u00E7o"
			}
		));
		tabelaEstoque.getColumnModel().getColumn(0).setPreferredWidth(49);
		tabelaEstoque.getColumnModel().getColumn(1).setPreferredWidth(162);
		tabelaEstoque.getColumnModel().getColumn(2).setPreferredWidth(93);
		tabelaEstoque.getColumnModel().getColumn(4).setPreferredWidth(74);
		tabelaEstoque.getColumnModel().getColumn(5).setPreferredWidth(42);
		scrollPane.setViewportView(tabelaEstoque);
		btnSair.setBounds(84, 495, 91, 40);
		btnSair.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(btnSair);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.preencherResultadosEstoque();
			}
		});
		btnBuscar.setBounds(673, 71, 106, 30);
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(btnBuscar);
		
		JButton btnAlterarQuantidade = new JButton("Alterar quantidade");
		btnAlterarQuantidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.attQuantidade();
			}
		});
		btnAlterarQuantidade.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAlterarQuantidade.setBounds(316, 497, 156, 40);
		contentPane.add(btnAlterarQuantidade);
		
		JButton btnAdicionarProduto = new JButton("Adicionar Produto");
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovoAddProdutoView janelaAddprod = new NovoAddProdutoView();
				janelaAddprod.setJanelaEstoque(getThis());
				setVisible(false);
				janelaOpcoesAdicionais.toFront();
				janelaAddprod.toFront();
				janelaAddprod.setVisible(true);
			}
		});
		btnAdicionarProduto.setBounds(482, 497, 156, 40);
		btnAdicionarProduto.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdicionarProduto.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(btnAdicionarProduto);
		
		JButton btnExibirTodos = new JButton("Exibir tudo");
		btnExibirTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.preencherTudoEstoque();
			}
		});
		btnExibirTodos.setFont(new Font("Arial", Font.PLAIN, 15));
		btnExibirTodos.setBounds(648, 497, 156, 40);
		contentPane.add(btnExibirTodos);
		
		JButton btnRemover = new JButton("remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.removerDeVez();
			}
		});
		btnRemover.setBounds(199, 507, 89, 23);
		contentPane.add(btnRemover);
		
		JLabel fundo2 = new JLabel("");
		fundo2.setIcon(new ImageIcon(NovoEstoqueView.class.getResource("/fundoEscuro.png")));
		fundo2.setBounds(102, -11, 613, 59);
		contentPane.add(fundo2);
		
		JLabel fundo1 = new JLabel("");
		fundo1.setBounds(10, 48, 818, 523);
		fundo1.setIcon(new ImageIcon(NovoEstoqueView.class.getResource("/fundoEscuro.png")));
		contentPane.add(fundo1);
		
		JLabel fundo0 = new JLabel("");
		fundo0.setBounds(0, 0, 900, 900);
		contentPane.add(fundo0);
		fundo0.setIcon(new ImageIcon(NovoEstoqueView.class.getResource("/novoEstoqueFundo.jpg")));
		
		setResizable(false);
		
		tableModel = (DefaultTableModel) tabelaEstoque.getModel();		
		controlador.preencherTudoEstoque();
	}

	public void setJanelaOpcoesAdicionais(OpcoesAdicionaisView janelaOpcoesAdicionais) {
		this.janelaOpcoesAdicionais = janelaOpcoesAdicionais;
	}
	
	public OpcoesAdicionaisView getJanelaOpcoesAdicionais() {
		return janelaOpcoesAdicionais;
	}

	public NovoEstoqueView getThis() {
		return this;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public JTextField getTextBusca() {
		return textBusca;
	}

	public JTable getTabelaEstoque() {
		return tabelaEstoque;
	}

	public BuscarController getControlador() {
		return controlador;
	}
}