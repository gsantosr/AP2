package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textSenha;
	private final LoginController controller = new LoginController(this);
	private String login;

	public JTextField getTextUsuario() {
		return textUsuario;
	}

	public void setTextUsuario(JTextField textUsuario) {
		this.textUsuario = textUsuario;
	}

	public JPasswordField getTextSenha() {
		return textSenha;
	}

	public void setTextSenha(JPasswordField textSenha) {
		this.textSenha = textSenha;
	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LoginView() {
		//controller = new LoginController(this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(500, 200, 346, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel login = new JLabel("Login");
		login.setForeground(Color.WHITE);
		login.setFont(new Font("Arial", Font.BOLD, 36));
		login.setBounds(120, 11, 107, 69);
		contentPane.add(login);
		
		JLabel usuario = new JLabel("Usu\u00E1rio");
		usuario.setForeground(Color.WHITE);
		usuario.setFont(new Font("Arial", Font.BOLD, 16));
		usuario.setBounds(50, 110, 94, 27);
		contentPane.add(usuario);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
		textUsuario.setBounds(30, 148, 280, 27);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		textUsuario.addKeyListener(new KeyAdapter() {

			@Override
            public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() ==  KeyEvent.VK_ENTER) {
					controller.autenticar();
                }
            }
        });
		
		JLabel senha = new JLabel("Senha");
		senha.setFont(new Font("Arial", Font.BOLD, 16));
		senha.setForeground(Color.WHITE);
		senha.setBounds(50, 186, 94, 19);
		contentPane.add(senha);
		
		textSenha = new JPasswordField();
		textSenha.setFont(new Font("Arial", Font.PLAIN, 16));
		textSenha.setBounds(30, 216, 280, 27);
		contentPane.add(textSenha);
		textSenha.addKeyListener(new KeyAdapter() {

			@Override
            public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() ==  KeyEvent.VK_ENTER) {
					controller.autenticar();
                }
            }
        });
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.autenticar();
			}
		});
		btnEntrar.setBounds(221, 267, 89, 23);
		contentPane.add(btnEntrar);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(LoginView.class.getResource("/IMG.login.jpg")));
		fundo.setBounds(-698, -145, 1484, 719);
		contentPane.add(fundo);
		
		setResizable(false);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
}
