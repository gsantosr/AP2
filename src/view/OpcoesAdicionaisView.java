package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;

public class OpcoesAdicionaisView extends JFrame {

	private JPanel contentPane;
	private JButton btnMudarSenha;
	private MenuPrincipalView janelaMenuPrincipal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcoesAdicionaisView frame = new OpcoesAdicionaisView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OpcoesAdicionaisView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(50, 30, 1280, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//botão para retornar ao menu principal (botão redondo)
		JButton btnVoltar = new JButton("");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaMenuPrincipal.setVisible(true);
				dispose();
				janelaMenuPrincipal.toFront();
			}
		});
		btnVoltar.setBounds(93, 55, 48, 48);
		btnVoltar.setOpaque(false);
		btnVoltar.setFocusPainted(false);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorder(null);
		btnVoltar.setIcon(new ImageIcon(OpcoesAdicionaisView.class.getResource("/iconeBotaoVoltar.png")));
		contentPane.add(btnVoltar);
		
		//título "menu" no topo da página
		JLabel menu = new JLabel("MENU");
		menu.setForeground(Color.WHITE);
		menu.setFont(new Font("Arial", Font.BOLD, 60));
		menu.setBounds(544, 59, 189, 109);
		contentPane.add(menu);
		
		//Botão gerente
		JButton btnGerentes = new JButton("Gerentes");
		btnGerentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GerenteView view1 = new GerenteView();
				view1.setOpcoesAdicionais(getThis());
				setEnabled(false);
				view1.setVisible(true);
				
				
			}
		});
		btnGerentes.setHorizontalAlignment(SwingConstants.LEFT);
		btnGerentes.setFont(new Font("Arial", Font.PLAIN, 30));
		btnGerentes.setFocusPainted(false);
		btnGerentes.setIcon(new ImageIcon(OpcoesAdicionaisView.class.getResource("/gerente.png")));
		btnGerentes.setBounds(156, 202, 415, 82);
		contentPane.add(btnGerentes);
		
		//botão funcionários
		JButton btnFuncionarios = new JButton("Funcion\u00E1rios");
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FuncionariosView view = new FuncionariosView();
				view.setOpcoesAdicionais(getThis());
				setEnabled(false);
				view.setVisible(true);
			}
		});
		btnFuncionarios.setHorizontalAlignment(SwingConstants.LEFT);
		btnFuncionarios.setFont(new Font("Arial", Font.PLAIN, 30));
		btnFuncionarios.setIcon(new ImageIcon(OpcoesAdicionaisView.class.getResource("/funcionarios.png")));
		btnFuncionarios.setBounds(156, 401, 415, 82);
		btnFuncionarios.setFocusPainted(false);
		contentPane.add(btnFuncionarios);
		
		//botão estoque
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovoEstoqueView novoEstoqueView = new NovoEstoqueView();
				novoEstoqueView.setJanelaOpcoesAdicionais(getThis());
				novoEstoqueView.setVisible(true); 
				getThis().setEnabled(false);
			}
		});		
		btnEstoque.setHorizontalAlignment(SwingConstants.LEFT);
		btnEstoque.setFont(new Font("Arial", Font.PLAIN, 30));
		btnEstoque.setIcon(new ImageIcon(OpcoesAdicionaisView.class.getResource("/estoque02.png")));
		btnEstoque.setBounds(705, 202, 415, 82);
		btnEstoque.setFocusPainted(false);
		contentPane.add(btnEstoque);
		
		//botão alterar senha
		btnMudarSenha = new JButton("Alterar senha");
		btnMudarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarSenhaView senhaView = new AlterarSenhaView();
				senhaView.setOpcoesAdicionais(getThis());
				senhaView.setVisible(true); 
				getThis().setEnabled(false);
			}
		});
		btnMudarSenha.setHorizontalAlignment(SwingConstants.LEFT);
		btnMudarSenha.setFont(new Font("Arial", Font.PLAIN, 30));
		btnMudarSenha.setFocusPainted(false);
		btnMudarSenha.setIcon(new ImageIcon(OpcoesAdicionaisView.class.getResource("/adminSenha.png")));
		btnMudarSenha.setBounds(705, 401, 415, 82);
		contentPane.add(btnMudarSenha);
		
		JLabel fundoEscuro = new JLabel("");
		fundoEscuro.setIcon(new ImageIcon(OpcoesAdicionaisView.class.getResource("/fundoEscuro.png")));
		fundoEscuro.setBounds(32, 38, 1158, 595);
		contentPane.add(fundoEscuro);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(OpcoesAdicionaisView.class.getResource("/fundoMenu.jpg")));
		fundo.setBounds(0, 0, 1920, 1080);
		contentPane.add(fundo);
		
		setResizable(false);
	}
	
	public OpcoesAdicionaisView getThis(){
		return this;
	}
	
	public void setJanelaMenuPrincipal(MenuPrincipalView janela) {
		this.janelaMenuPrincipal = janela;
	}
}