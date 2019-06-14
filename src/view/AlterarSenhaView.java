package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlterarSenhaController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarSenhaView extends JFrame {

	private JPanel contentPane;
	private JPasswordField textSenha01;
	private JButton btnContinuar;
	private JButton btnCancelar;
	private JLabel titulo02;
	private JPasswordField textSenha02;
	private OpcoesAdicionaisView opcoesAdicionais;
	private AlterarSenhaController controller = new AlterarSenhaController(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarSenhaView frame = new AlterarSenhaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private OpcoesAdicionaisView op;

	public void setOpcoesAdicionais(OpcoesAdicionaisView op) {
		this.op = op;
	}
	public AlterarSenhaView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 395, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titulo01 = new JLabel("Digite a nova senha");
		titulo01.setForeground(Color.WHITE);
		titulo01.setFont(new Font("Arial", Font.BOLD, 20));
		titulo01.setBounds(29, 25, 231, 34);
		contentPane.add(titulo01);

		textSenha01 = new JPasswordField();
		textSenha01.setBounds(22, 70, 334, 34);
		contentPane.add(textSenha01);

		JLabel titulo02;
		titulo02 = new JLabel("Confimar senha");
		titulo02.setForeground(Color.WHITE);
		titulo02.setFont(new Font("Arial", Font.BOLD, 20));
		titulo02.setBounds(32, 117, 231, 34);
		contentPane.add(titulo02);

		btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (controller.mudarSenha() == true) {
					op.toFront();
					op.setEnabled(true);
					getThis().dispose();				
				}
			}
		});

		textSenha02 = new JPasswordField();
		textSenha02.setBounds(22, 158, 334, 34);
		contentPane.add(textSenha02);
		btnContinuar.setBounds(229, 216, 127, 34);
		contentPane.add(btnContinuar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op.setEnabled(true);
				getThis().dispose();
			}
		});
		btnCancelar.setBounds(22, 216, 127, 34);
		contentPane.add(btnCancelar);

		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(LoginView.class.getResource("/fundoAlterarSenha.jpg")));
		fundo.setBounds(0, 0, 400, 276);
		contentPane.add(fundo);
		
		setResizable(false);
	}

	public JPasswordField getTextSenha01() {
		return textSenha01;
	}

	public void setTextSenha01(JPasswordField textSenha01) {
		this.textSenha01 = textSenha01;
	}

	public JPasswordField getTextSenha02() {
		return textSenha02;
	}

	public void setTextSenha02(JPasswordField textSenha02) {
		this.textSenha02 = textSenha02;
	}

	public AlterarSenhaView getThis() {
		return this;
	}

}
