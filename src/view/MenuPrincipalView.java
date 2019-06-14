package view;


import java.awt.EventQueue;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Relogio;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MenuPrincipalView extends JFrame {

	private JPanel contentPane;
	private JLabel usuario;
	private JButton BtnOpcoesAdicionais;
	private JLabel relogio;
	private Relogio relogioMecanismo;
	private LoginView janelaLogin;
	//essa variável serve pra ver se a pessoa que logou é um funcionario ou não
	private boolean vcEhFuncionario;
	//essa variável serve pra ver o tipo de usuário (gerente, admin, funcionário)
	private int tipoUsuario = 0; //1-admin  2-gerente  3-funcionario
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalView frame = new MenuPrincipalView();
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public MenuPrincipalView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 30, 1280, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usuario = new JLabel("");
		usuario.setForeground(Color.WHITE);
		usuario.setFont(new Font("Arial", Font.PLAIN, 12));
		usuario.setBounds(96, 50, 272, 28);
		contentPane.add(usuario);
		
		JButton btnLogout = new JButton("Sair");
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getThis().getJanelaLogin().dispose();
				getThis().dispose();
				LoginView login = new LoginView();
				login.setVisible(true);
			}
		});
		btnLogout.setBounds(1098, 55, 64, 23);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorder(null);
		btnLogout.setFocusPainted(false);
		contentPane.add(btnLogout);
		
		JLabel titulo = new JLabel("MENU");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 60));
		titulo.setBounds(562, 65, 189, 109);
		contentPane.add(titulo);
		
		JButton btnNovaCompra = new JButton("Pesquisar no estoque");
		btnNovaCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				BuscarView janelaDeBusca = new BuscarView();
				janelaDeBusca.setJanelaMenu(getThis());
				setEnabled(false);
				janelaDeBusca.setVisible(true);
			}
		});
		btnNovaCompra.setHorizontalAlignment(SwingConstants.LEFT);
		btnNovaCompra.setFont(new Font("Arial", Font.PLAIN, 30));
		btnNovaCompra.setFocusPainted(false);
		btnNovaCompra.setIcon(new ImageIcon(MenuPrincipalView.class.getResource("/pesquisarEmEstoque.png")));
		btnNovaCompra.setBounds(156, 216, 442, 82);
		contentPane.add(btnNovaCompra);
		
		JButton btnAdicionarCliente = new JButton("Adicionar cliente");
		btnAdicionarCliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdicionarCliente.setFont(new Font("Arial", Font.PLAIN, 30));
		btnAdicionarCliente.setIcon(new ImageIcon(MenuPrincipalView.class.getResource("/cliente.png")));
		btnAdicionarCliente.setBounds(156, 407, 442, 82);
		btnAdicionarCliente.setFocusPainted(false);
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriarClienteView clienteView = new CriarClienteView();
				clienteView.setMenuPrincipal(getThis());
				clienteView.setVisible(true); 
				setEnabled(false);
			}
		});
		contentPane.add(btnAdicionarCliente);
		
		JButton btnEstatisticas = new JButton("Clientes cadastrados");
		btnEstatisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarClientesView janelaCliente = new BuscarClientesView();
				janelaCliente.setJanelaMenu(getThis());
				janelaCliente.setVisible(true);
				setEnabled(false);
				if(vcEhFuncionario) //esse if desabilita o botão remover cliente se o usuário for um funcionário
					janelaCliente.getBtnRmvCliente().setEnabled(false);
			}
		});
		btnEstatisticas.setHorizontalAlignment(SwingConstants.LEFT);
		btnEstatisticas.setFont(new Font("Arial", Font.PLAIN, 30));
		btnEstatisticas.setFocusPainted(false);
		btnEstatisticas.setIcon(new ImageIcon(MenuPrincipalView.class.getResource("/clientesCadastrados.png")));
		btnEstatisticas.setBounds(705, 216, 442, 82);
		contentPane.add(btnEstatisticas);
		
		BtnOpcoesAdicionais = new JButton("Op\u00E7\u00F5es adicionais");
		BtnOpcoesAdicionais.setHorizontalAlignment(SwingConstants.LEFT);
		BtnOpcoesAdicionais.setFont(new Font("Arial", Font.PLAIN, 30));
		BtnOpcoesAdicionais.setIcon(new ImageIcon(MenuPrincipalView.class.getResource("/chave.png")));
		BtnOpcoesAdicionais.setBounds(705, 407, 442, 82);
		BtnOpcoesAdicionais.setFocusPainted(false);
		contentPane.add(BtnOpcoesAdicionais);
		BtnOpcoesAdicionais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				OpcoesAdicionaisView opav = new OpcoesAdicionaisView();
				opav.setJanelaMenuPrincipal(getThis());
				opav.setVisible(true);
			}
		});
		
		relogio = new JLabel("20:40:21");
		relogio.setForeground(Color.WHITE);
		relogio.setFont(new Font("Arial", Font.BOLD, 30));
		relogio.setBounds(1042, 563, 141, 49);
		relogio.setVisible(false);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relogioMecanismo.fecharRelogio();
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(1024, 552, 159, 64);
		contentPane.add(btnNewButton);
		contentPane.add(relogio);
		
		JLabel fundoEscuro = new JLabel("");
		fundoEscuro.setIcon(new ImageIcon(MenuPrincipalView.class.getResource("/fundoEscuro.png")));
		fundoEscuro.setBounds(32, 38, 1164, 598);
		contentPane.add(fundoEscuro);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(MenuPrincipalView.class.getResource("/fundoMenu.jpg")));
		fundo.setBounds(0, 0, 1920, 1080);
		contentPane.add(fundo);
		
		//classe Relogio.java
		relogioMecanismo = new Relogio(getThis());
		
		setResizable(false);
	}
	
	public LoginView getJanelaLogin() {
		return janelaLogin;
	}


	public void setJanelaLogin(LoginView janelaLogin) {
		this.janelaLogin = janelaLogin;
	}


	public void definirUsuario(int definirUsuario, MenuPrincipalView menu) {
		menu.setVisible(true);
		if(definirUsuario == 1) {
			vcEhFuncionario = false; //se for um funcionario, essa variável fica verdadeira
			tipoUsuario = 1;
		}
		
		if(definirUsuario == 2) {
			vcEhFuncionario = false;
			tipoUsuario = 2;
		}
		
		else if(definirUsuario == 3) {
			menu.getBtnOpcoesAdicionais().setEnabled(false);
			vcEhFuncionario = true;
			tipoUsuario = 3;
		}
		
		//imprime o tipo de usuário na parte esquerda superior (gerente, funcionário, admin)
		if(tipoUsuario != 0) {
			if(tipoUsuario == 1)
				usuario.setText("Admin: ");
			else if(tipoUsuario == 2)
				usuario.setText("Gerente: ");
			else if(tipoUsuario == 3)
				usuario.setText("Funcionário: ");
		}
		
		//imprime o login do usuário na parte esquerda superior
		if(janelaLogin != null)
			usuario.setText(usuario.getText() + janelaLogin.getLogin());
	}
	
	public JButton getBtnOpcoesAdicionais() {
		return BtnOpcoesAdicionais;
	}
	
	public MenuPrincipalView getThis() {
		return this;
	}

	public JLabel getRelogio() {
		return relogio;
	}
	
}
