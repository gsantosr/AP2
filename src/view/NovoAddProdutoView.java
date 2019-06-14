package view;

import java.awt.BorderLayout;
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

public class NovoAddProdutoView extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textFabricante;
	private JTextField textTamanho;
	private JTextField textTipo;
	private JTextField textQuantidade;
	private JTextField textPreco;
	private NovoEstoqueView janelaEstoque;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoAddProdutoView frame = new NovoAddProdutoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NovoAddProdutoView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(500, 50, 760, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo0 = new JLabel("Adicionar novo produto");
		titulo0.setBounds(39, 10, 524, 98);
		titulo0.setForeground(Color.WHITE);
		titulo0.setFont(new Font("Arial", Font.BOLD, 40));
		contentPane.add(titulo0);
		
		JLabel caixaImagem = new JLabel("");
		caixaImagem.setBounds(587, 10, 147, 121);
		caixaImagem.setIcon(new ImageIcon(NovoAddProdutoView.class.getResource("/caixaAdd.png")));
		contentPane.add(caixaImagem);
		
		JLabel nome = new JLabel("Nome *");
		nome.setForeground(Color.WHITE);
		nome.setFont(new Font("Arial", Font.BOLD, 14));
		nome.setBounds(39, 119, 82, 35);
		contentPane.add(nome);
		
		textNome = new JTextField();
		textNome.setBounds(39, 148, 324, 23);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel Fabricante = new JLabel("Fabricante *");
		Fabricante.setForeground(Color.WHITE);
		Fabricante.setFont(new Font("Arial", Font.BOLD, 14));
		Fabricante.setBounds(386, 119, 147, 35);
		contentPane.add(Fabricante);
		
		textFabricante = new JTextField();
		textFabricante.setColumns(10);
		textFabricante.setBounds(386, 148, 324, 23);
		contentPane.add(textFabricante);
		
		JLabel Tamanho = new JLabel("Tamanho *");
		Tamanho.setForeground(Color.WHITE);
		Tamanho.setFont(new Font("Arial", Font.BOLD, 14));
		Tamanho.setBounds(39, 182, 235, 35);
		contentPane.add(Tamanho);
		
		textTamanho = new JTextField();
		textTamanho.setColumns(10);
		textTamanho.setBounds(39, 211, 324, 23);
		contentPane.add(textTamanho);
		
		JLabel Tipo = new JLabel("Tipo *");
		Tipo.setForeground(Color.WHITE);
		Tipo.setFont(new Font("Arial", Font.BOLD, 14));
		Tipo.setBounds(386, 182, 82, 35);
		contentPane.add(Tipo);
		
		textTipo = new JTextField();
		textTipo.setColumns(10);
		textTipo.setBounds(386, 211, 324, 23);
		contentPane.add(textTipo);
		
		JLabel Quantidade = new JLabel("Quantidade *");
		Quantidade.setForeground(Color.WHITE);
		Quantidade.setFont(new Font("Arial", Font.BOLD, 14));
		Quantidade.setBounds(39, 245, 137, 35);
		contentPane.add(Quantidade);
		
		textQuantidade = new JTextField();
		textQuantidade.setColumns(10);
		textQuantidade.setBounds(39, 277, 324, 23);
		contentPane.add(textQuantidade);
		
		JLabel Preco = new JLabel("Preço *");
		Preco.setForeground(Color.WHITE);
		Preco.setFont(new Font("Arial", Font.BOLD, 14));
		Preco.setBounds(386, 245, 82, 35);
		contentPane.add(Preco);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(386, 277, 324, 23);
		contentPane.add(textPreco);
		
		JLabel titulo1 = new JLabel("Os campos com * são obrigatórios");
		titulo1.setForeground(Color.WHITE);
		titulo1.setFont(new Font("Arial", Font.BOLD, 11));
		titulo1.setBounds(520, 312, 190, 23);
		contentPane.add(titulo1);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				janelaEstoque.setVisible(true);
				janelaEstoque.getJanelaOpcoesAdicionais().toFront();
				janelaEstoque.toFront();
			}
		});
		btnVoltar.setBounds(386, 346, 137, 34);
		contentPane.add(btnVoltar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(573, 346, 137, 34);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				janelaEstoque.getControlador().adicionarProdutos(getThis());
				janelaEstoque.setVisible(true);
				janelaEstoque.getJanelaOpcoesAdicionais().toFront();
				janelaEstoque.toFront();
			}
		});
		contentPane.add(btnConfirmar);
		
		JLabel fundo0 = new JLabel("");
		fundo0.setBounds(-98, 0, 861, 577);
		fundo0.setIcon(new ImageIcon(NovoAddProdutoView.class.getResource("/fundoAddprod.jpg")));
		contentPane.add(fundo0);
		//fundoAddprod
		
		setResizable(false);
	}

	public void setJanelaEstoque(NovoEstoqueView janelaEstoque) {
		this.janelaEstoque = janelaEstoque;
	}

	public JTextField getTextNome() {
		return textNome;
	}

	public JTextField getTextFabricante() {
		return textFabricante;
	}

	public JTextField getTextTamanho() {
		return textTamanho;
	}

	public JTextField getTextTipo() {
		return textTipo;
	}

	public JTextField getTextQuantidade() {
		return textQuantidade;
	}

	public JTextField getTextPreco() {
		return textPreco;
	}
	
	public NovoAddProdutoView getThis() {
		return this;
	}
}
