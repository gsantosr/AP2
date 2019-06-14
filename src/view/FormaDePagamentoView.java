package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class FormaDePagamentoView extends JFrame {

	private JPanel contentPane;
	private CarrinhoView janelaCarrinho;
	private ButtonGroup grupoDeBotoes = new ButtonGroup();
	private JRadioButton cartaoRadioButton;
	private JRadioButton dinheiroRadioButton;	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaDePagamentoView frame = new FormaDePagamentoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormaDePagamentoView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 341, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblEscolhaAForma = new JLabel("Escolhaa forma de pagamento:");
		lblEscolhaAForma.setForeground(Color.WHITE);
		lblEscolhaAForma.setFont(new Font("Arial", Font.BOLD, 18));
		lblEscolhaAForma.setBounds(25, 16, 285, 26);
		contentPane.add(lblEscolhaAForma);
		
		cartaoRadioButton = new JRadioButton("Cart\u00E3o de cr\u00E9dito");
		cartaoRadioButton.setForeground(Color.WHITE);
		cartaoRadioButton.setFont(new Font("Arial", Font.PLAIN, 14));
		cartaoRadioButton.setBounds(35, 63, 139, 23);
		cartaoRadioButton.setContentAreaFilled(false);
		cartaoRadioButton.setSelected(true);
		grupoDeBotoes.add(cartaoRadioButton);
		contentPane.add(cartaoRadioButton);
		
		dinheiroRadioButton = new JRadioButton("Dinheiro");
		dinheiroRadioButton.setFont(new Font("Arial", Font.PLAIN, 14));
		dinheiroRadioButton.setForeground(Color.WHITE);
		dinheiroRadioButton.setBounds(35, 96, 109, 23);
		dinheiroRadioButton.setContentAreaFilled(false);
		grupoDeBotoes.add(dinheiroRadioButton);
		contentPane.add(dinheiroRadioButton);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PagamentoFinalView janelaPagamentoFinal = new PagamentoFinalView(getThis());
				janelaPagamentoFinal.setVisible(true);
				getThis().setVisible(false);
				getThis().janelaCarrinho.getJanelaBuscar().getJanelaMenu().toFront();
				janelaPagamentoFinal.toFront();
			}
		});
		btnNewButton.setBounds(181, 138, 119, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getThis().dispose();
				janelaCarrinho.getJanelaBuscar().getJanelaMenu().toFront();
				janelaCarrinho.getJanelaBuscar().toFront();
				janelaCarrinho.getJanelaBuscar().setVisible(true);
				janelaCarrinho.toFront();
				janelaCarrinho.setVisible(true);
			}
		});
		btnVoltar.setBounds(25, 138, 119, 23);
		contentPane.add(btnVoltar);
		
		JLabel fundoEscuro = new JLabel("");
		fundoEscuro.setBounds(-35, 11, 350, 165);
		fundoEscuro.setIcon(new ImageIcon(LoginView.class.getResource("/fundoEscuro.png")));
		contentPane.add(fundoEscuro);
		
		JLabel fundoDeDinheiro = new JLabel("");
		fundoDeDinheiro.setBounds(0, 0, 333, 195);
		fundoDeDinheiro.setIcon(new ImageIcon(LoginView.class.getResource("/fundoDeDinheiro.jpg")));
		contentPane.add(fundoDeDinheiro);
		
		setResizable(false);
	}

	public CarrinhoView getJanelaCarrinho() {
		return janelaCarrinho;
	}

	public void setJanelaCarrinho(CarrinhoView janelaCarrinho) {
		this.janelaCarrinho = janelaCarrinho;
	}

	public JRadioButton getDinheiroRadioButton() {
		return dinheiroRadioButton;
	}
	
	public FormaDePagamentoView getThis() {
		return this;
	}
	
	public void testar() {
		System.out.println("forma de pagamento view");
	}
}
