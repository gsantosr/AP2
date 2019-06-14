//Janela que busca itens no estoque

package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.BuscarController;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuscarView extends JFrame {

	private JPanel contentPane;
	private JTextField textBusca;
	private MenuPrincipalView janelaMenu;
	private JTable tableProdutos;
	private JComboBox criterioDeBusca;
	private BuscarController produtosController = new BuscarController(this);
	private JButton btnSair;
	private JButton btnNovaCompra;
	private JButton btnAdicionar02;
	private CarrinhoView janelaCarrinho;
	private DefaultTableModel tableModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarView frame = new BuscarView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BuscarView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(200, 0, 879, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textBusca = new JTextField();
		textBusca.setBounds(84, 71, 589, 30);
		contentPane.add(textBusca);
		textBusca.setColumns(10);
		textBusca.addKeyListener(new KeyAdapter() {

			@Override
            public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() ==  KeyEvent.VK_ENTER) {
					produtosController.preencherResultados();
                }
            }
        });
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(84, 490, 91, 30);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				janelaMenu.setEnabled(true);
				janelaMenu.toFront();
			}
		});
		contentPane.add(btnSair);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosController.preencherResultados();
			}
		});
		btnBuscar.setBounds(688, 71, 91, 30);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			produtosController.preencherResultados();
		}
	});
		
		JButton btnExibirTodos = new JButton("Exibir todos");
		btnExibirTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosController.preencherTudo();
			}
		});
		
		btnAdicionar02 = new JButton("Adicionar selecionado");
		btnAdicionar02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdicionar02.setEnabled(false);
				QtdCarrinhoView janelaQtd02 = new QtdCarrinhoView(getThis());
				janelaQtd02.setVisible(true);
				janelaQtd02.toFront();
			}
		});
		btnAdicionar02.setBounds(252, 490, 169, 30);
		contentPane.add(btnAdicionar02);
		btnExibirTodos.setBounds(431, 490, 169, 30);
		contentPane.add(btnExibirTodos);
		btnAdicionar02.setEnabled(false);
		
		btnNovaCompra = new JButton("Efetuar nova venda");
		btnNovaCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaCarrinho = new CarrinhoView();
				janelaCarrinho.setJanelaBuscar(getThis());
				janelaCarrinho.setVisible(true);
				btnSair.setEnabled(false);
				btnNovaCompra.setEnabled(false);
				btnAdicionar02.setEnabled(true);
			}
		});
		btnNovaCompra.setBounds(610, 490, 169, 30);
		contentPane.add(btnNovaCompra);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 135, 695, 344);
		contentPane.add(scrollPane);
		
		tableProdutos = new JTable();
		tableProdutos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Fabricante", "Tamanho", "Tipo", "Quantidade", "Pre\u00E7o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(43);
		tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(204);
		tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(83);
		tableProdutos.getColumnModel().getColumn(3).setPreferredWidth(54);
		tableProdutos.getColumnModel().getColumn(4).setPreferredWidth(32);
		tableProdutos.getColumnModel().getColumn(5).setPreferredWidth(66);
		tableProdutos.getColumnModel().getColumn(6).setPreferredWidth(55);
		scrollPane.setViewportView(tableProdutos);
		
		criterioDeBusca = new JComboBox();
		criterioDeBusca.setModel(new DefaultComboBoxModel(new String[] {"Nome do produto", "C\u00F3digo do produto"}));
		criterioDeBusca.setBounds(84, 43, 150, 20);
		contentPane.add(criterioDeBusca);
		
		JLabel fundo02 = new JLabel("");
		fundo02.setBounds(0, 32, 818, 523);
		fundo02.setIcon(new ImageIcon(LoginView.class.getResource("/fundoEscuro.png")));
		contentPane.add(fundo02);
		
		JLabel fundo = new JLabel("");
		fundo.setBounds(-143, -17, 1095, 617);
		fundo.setIcon(new ImageIcon(LoginView.class.getResource("/estoqueFundo.jpg")));
		contentPane.add(fundo);
		
		setResizable(false);
		
		//preenche todas a colunas
		tableModel = (DefaultTableModel) tableProdutos.getModel();
		produtosController.preencherTudo();
		
	}

	public void setJanelaMenu(MenuPrincipalView janelaMenu) {
		this.janelaMenu = janelaMenu;
	}
	
	public MenuPrincipalView getJanelaMenu() {
		return janelaMenu;
	}

	public JTable getTableProdutos() {
		return tableProdutos;
	}
	
	public JComboBox getCriterioDeBusca() {
		return criterioDeBusca;
	}

	public void setTableProdutos(JTable tableProdutos) {
		this.tableProdutos = tableProdutos;
	}

	public JTextField getTextBusca() {
		return textBusca;
	}

	public BuscarView getThis() {
		return this;
	}

	public JButton getBtnSair() {
		return btnSair;
	}

	public void setBtnSair(JButton btnSair) {
		this.btnSair = btnSair;
	}

	public JButton getBtnNovaCompra() {
		return btnNovaCompra;
	}

	public void setBtnNovaCompra(JButton btnNovaCompra) {
		this.btnNovaCompra = btnNovaCompra;
	}

	public JButton getBtnAdicionar02() {
		return btnAdicionar02;
	}

	public CarrinhoView getJanelaCarrinho() {
		return janelaCarrinho;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	
}
