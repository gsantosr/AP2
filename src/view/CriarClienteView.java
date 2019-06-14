package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ClienteController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CriarClienteView extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCpf;
	private ClienteController controller = new ClienteController(this);
	private JTextField textTelefone;
	private JTextField textEmail;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriarClienteView frame = new CriarClienteView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private MenuPrincipalView menu;
	
	public void setMenuPrincipal(MenuPrincipalView menu) {
		this.menu = menu;
		
	}

	
	public CriarClienteView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(500, 50, 411, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo01 = new JLabel("Adicionar novo");
		titulo01.setForeground(Color.WHITE);
		titulo01.setFont(new Font("Arial", Font.BOLD, 30));
		titulo01.setBounds(116, 43, 221, 35);
		contentPane.add(titulo01);
		
		JLabel titulo02 = new JLabel("cliente.");
		titulo02.setForeground(Color.WHITE);
		titulo02.setFont(new Font("Arial", Font.BOLD, 30));
		titulo02.setBounds(116, 79, 221, 35);
		contentPane.add(titulo02);
		
		JLabel nome = new JLabel("Nome *");
		nome.setForeground(Color.WHITE);
		nome.setFont(new Font("Arial", Font.BOLD, 20));
		nome.setBounds(52, 162, 82, 35);
		contentPane.add(nome);
		
		textNome = new JTextField();
		textNome.setBounds(52, 208, 294, 29);
		textNome.setFont(new Font("Arial", Font.PLAIN, 13));
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel cpf = new JLabel("CPF *");
		cpf.setForeground(Color.WHITE);
		cpf.setFont(new Font("Arial", Font.BOLD, 20));
		cpf.setBounds(52, 257, 82, 35);
		contentPane.add(cpf);
		
		textCpf = new JTextField();
		textCpf.setBounds(52, 303, 294, 29);
		textCpf.setFont(new Font("Arial", Font.PLAIN, 13));
		contentPane.add(textCpf);
		textCpf.setColumns(10);
		
		JLabel telefone = new JLabel("(DDD) Telefone");
		telefone.setForeground(Color.WHITE);
		telefone.setFont(new Font("Arial", Font.BOLD, 20));
		telefone.setBounds(52, 343, 235, 35);
		contentPane.add(telefone);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(52, 394, 294, 29);
		textTelefone.setFont(new Font("Arial", Font.PLAIN, 13));
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel email = new JLabel("E-mail");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Arial", Font.BOLD, 20));
		email.setBounds(52, 447, 82, 35);
		contentPane.add(email);
		
		textEmail = new JTextField();
		textEmail.setBounds(52, 493, 300, 29);
		textEmail.setFont(new Font("Arial", Font.PLAIN, 13));
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(48, 560, 150, 29);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setEnabled(true);
				getThis().dispose();
			}
		});
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(208, 560, 150, 29);
		contentPane.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controller.salvarCliente() == true) {
				menu.setEnabled(true);
				getThis().dispose();
				}
			}
		});
		
		JLabel lblCamposCom = new JLabel("Campos com * s\u00E3o obrigat\u00F3rios.");
		lblCamposCom.setForeground(Color.WHITE);
		lblCamposCom.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCamposCom.setBounds(195, 533, 179, 13);
		contentPane.add(lblCamposCom);
		
		JLabel iconeCliente = new JLabel("");
		iconeCliente.setIcon(new ImageIcon(MenuPrincipalView.class.getResource("/clienteIcone.png")));
		iconeCliente.setBounds(29, 31, 72, 94);
		contentPane.add(iconeCliente);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(MenuPrincipalView.class.getResource("/fundoCliente.jpg")));
		fundo.setBounds(0, 0, 655, 621);
		contentPane.add(fundo);
		
		setResizable(false);
	}
	public CriarClienteView getThis() {
		return this;
	}
	public JTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}

	public JTextField getTextCpf() {
		return textCpf;
	}

	public void setTextCpf(JTextField textCpf) {
		this.textCpf = textCpf;
	}

	public JTextField getTextTelefone() {
		return textTelefone;
	}

	public void setTextTelefone(JTextField textTelefone) {
		this.textTelefone = textTelefone;
	}

	public JTextField getTextEmail() {
		return textEmail;
	}

	public void setTextEmail(JTextField textEmail) {
		this.textEmail = textEmail;
	}	
}