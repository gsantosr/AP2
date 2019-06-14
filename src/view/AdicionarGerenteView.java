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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AdicionarFuncionariosController;
import controller.AdicionarGerenteController;


import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class AdicionarGerenteView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textTelefone;
	private JTextField textEmail;
	private JTextField textLogin;
	private JPasswordField textSenha01;
	private JPasswordField textSenha02;
	private GerenteView gerenteView;
	private AdicionarGerenteController gerenteControlador;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarGerenteView frame = new AdicionarGerenteView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdicionarGerenteView() {
		gerenteControlador = new AdicionarGerenteController(this);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(500, 50, 411, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo01 = new JLabel("Adicionar novo");
		titulo01.setForeground(Color.WHITE);
		titulo01.setFont(new Font("Arial", Font.BOLD, 30));
		titulo01.setBounds(152, 25, 221, 35);
		contentPane.add(titulo01);
		
		JLabel titulo02 = new JLabel("gerente");
		titulo02.setForeground(Color.WHITE);
		titulo02.setFont(new Font("Arial", Font.BOLD, 30));
		titulo02.setBounds(152, 70, 221, 35);
		contentPane.add(titulo02);
		
		JLabel nome = new JLabel("Nome *");
		nome.setForeground(Color.WHITE);
		nome.setFont(new Font("Arial", Font.BOLD, 20));
		nome.setBounds(10, 119, 82, 35);
		contentPane.add(nome);
		
		JLabel cpf = new JLabel("CPF *");
		cpf.setForeground(Color.WHITE);
		cpf.setFont(new Font("Arial", Font.BOLD, 20));
		cpf.setBounds(10, 178, 82, 35);
		contentPane.add(cpf);
		
		textCpf = new JTextField();
		textCpf.setFont(new Font("Arial", Font.PLAIN, 13));
		textCpf.setColumns(10);
		textCpf.setBounds(11, 208, 362, 29);
		contentPane.add(textCpf);
		
		JLabel telefone = new JLabel("(DDD) Telefone *");
		telefone.setForeground(Color.WHITE);
		telefone.setFont(new Font("Arial", Font.BOLD, 20));
		telefone.setBounds(10, 247, 235, 35);
		contentPane.add(telefone);
		
		textTelefone = new JTextField();
		textTelefone.setFont(new Font("Arial", Font.PLAIN, 13));
		textTelefone.setColumns(10);
		textTelefone.setBounds(10, 279, 362, 29);
		contentPane.add(textTelefone);
		
		JLabel email = new JLabel("E-mail *");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Arial", Font.BOLD, 20));
		email.setBounds(10, 318, 82, 35);
		contentPane.add(email);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Arial", Font.PLAIN, 13));
		textEmail.setColumns(10);
		textEmail.setBounds(10, 348, 362, 29);
		contentPane.add(textEmail);
		
		JLabel label = new JLabel("Login *");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(10, 387, 82, 35);
		contentPane.add(label);
		
		textLogin = new JTextField();
		textLogin.setFont(new Font("Arial", Font.PLAIN, 13));
		textLogin.setColumns(10);
		textLogin.setBounds(10, 417, 362, 29);
		contentPane.add(textLogin);
		
		JLabel label_1 = new JLabel("Senha *");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.BOLD, 20));
		label_1.setBounds(10, 457, 82, 35);
		contentPane.add(label_1);
		
		textSenha01 = new JPasswordField();
		textSenha01.setBounds(10, 489, 363, 29);
		contentPane.add(textSenha01);
		
		JLabel label_2 = new JLabel("Confirmar senha *");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Arial", Font.BOLD, 20));
		label_2.setBounds(10, 520, 202, 35);
		contentPane.add(label_2);
		
		textSenha02 = new JPasswordField();
		textSenha02.setBounds(10, 548, 363, 29);
		contentPane.add(textSenha02);
		
		JLabel label_a = new JLabel("Os campos com * são obrigatórios");
		label_a.setForeground(Color.WHITE);
		label_a.setFont(new Font("Arial", Font.BOLD, 11));
		label_a.setBounds(184, 582, 202, 23);
		contentPane.add(label_a);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(25, -25, 158, 112);
		contentPane.add(label_3);
				
		JButton btnNewButton_1 = new JButton("Confirmar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenteControlador.adicionarGerente();
				dispose();
				gerenteView.setVisible(true);
				gerenteView.getOpcoesAdicionais().toFront();
				gerenteView.toFront();
				
			}
		});
		btnNewButton_1.setBounds(284, 610, 102, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				gerenteView.setVisible(true);
				gerenteView.getOpcoesAdicionais().toFront();
				gerenteView.toFront();
			}
		});
		btnVoltar.setBounds(185, 610, 89, 23);
		contentPane.add(btnVoltar);
		
		textNome = new JTextField();
		textNome.setBounds(10, 146, 363, 29);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(10, 146, 363, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(MenuPrincipalView.class.getResource("/Users-Administrator-icon.png")));
		fundo.setBounds(35, 25, 89, 74);
		contentPane.add(fundo);
		
		JLabel Fundo = new JLabel("");
		Fundo.setBounds(0, 0, 397, 633);
		Fundo.setIcon(new ImageIcon(MenuPrincipalView.class.getResource("/FundoAdicionarGerente1.jpg")));
		contentPane.add(Fundo);
		
		setResizable(false);
	}
	
	

	public void setGerenteView(GerenteView opcoes) {
		this.gerenteView = opcoes;
	}

	public JTextField getTextNome() {
		return textNome;
	}

	public JPasswordField getTextSenha01() {
		return textSenha01;
	}

	public JPasswordField getTextSenha02() {
		return textSenha02;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextCpf() {
		return textCpf;
	}

	public JTextField getTextTelefone() {
		return textTelefone;
	}

	public JTextField getTextEmail() {
		return textEmail;
	}

	public JTextField getTextLogin() {
		return textLogin;
	}
	
}

