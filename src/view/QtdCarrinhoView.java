package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AddMarcadoController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class QtdCarrinhoView extends JFrame {

	private JPanel contentPane;
	private JTextField textQuantidade02;
	private BuscarView janelaBuscar;
	private AddMarcadoController controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QtdCarrinhoView frame = new QtdCarrinhoView(new BuscarView());
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
	public QtdCarrinhoView(BuscarView janelaBuscar) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 222, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textQuantidade02 = new JTextField();
		textQuantidade02.setBounds(10, 48, 146, 29);
		contentPane.add(textQuantidade02);
		textQuantidade02.setColumns(10);
		
		JButton btnConfirmar02 = new JButton("Confirmar");
		btnConfirmar02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				janelaBuscar.getBtnAdicionar02().setEnabled(true);
				controlador.btnConfirmar02();
			}
		});
		btnConfirmar02.setBounds(82, 120, 114, 23);
		contentPane.add(btnConfirmar02);
		
		JLabel titulo = new JLabel("Quantidade a ser adicionada:");
		titulo.setBounds(10, 23, 186, 14);
		contentPane.add(titulo);
		
		controlador = new AddMarcadoController(getThis(), janelaBuscar, janelaBuscar.getJanelaCarrinho());
		
		setResizable(false);
	}

	public void setJanelaBuscar(BuscarView janelaBuscar) {
		this.janelaBuscar = janelaBuscar;
	}
	
	public QtdCarrinhoView getThis() {
		return this;
	}

	public JTextField getTextQuantidade02() {
		return textQuantidade02;
	}
	
}
