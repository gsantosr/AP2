package controller;

import java.sql.Connection;

import javax.swing.JOptionPane;

import dao.AdicionarGerenteDao;
import dao.ConexaoDao;
import model.Funcionario;
import model.Usuario;
import view.AdicionarGerenteView;

public class AdicionarGerenteController {

	private AdicionarGerenteView janelaAddGerente;
	
	public AdicionarGerenteController(AdicionarGerenteView janela) {
		janelaAddGerente = janela;
	}
	
	public void adicionarGerente() {
		String nome = janelaAddGerente.getTextNome().getText();
		String cpf = janelaAddGerente.getTextCpf().getText();
		String telefone = janelaAddGerente.getTextTelefone().getText();
		String email = janelaAddGerente.getTextEmail().getText();
		String login = janelaAddGerente.getTextLogin().getText();
		String senha01 = janelaAddGerente.getTextSenha01().getText();
		String senha02 = janelaAddGerente.getTextSenha02().getText();
		//FALTA CONSIDERAR O CASO ONDE AS SENHAS SÃO DIFERENTES
		if(senha01.equals(senha02) && !nome.trim().isEmpty() && !cpf.trim().isEmpty() && !telefone.trim().isEmpty() && !email.trim().isEmpty() && !login.trim().isEmpty()) {
			Usuario usuario = new Usuario(login, senha01);
			Funcionario gerente = new Funcionario(nome, cpf, telefone, email, usuario);
			Connection conexao;
			try {
				conexao = new ConexaoDao().getConnection();
				AdicionarGerenteDao gerentesDao = new AdicionarGerenteDao(conexao);
				gerentesDao.addGerente(gerente);
				JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
			} 
			catch(Exception e) {
				e.printStackTrace();
			}
		
		}
		else {
			JOptionPane.showMessageDialog(janelaAddGerente, "Digite um valor válido no campo", "Erro de validação", JOptionPane.ERROR_MESSAGE);
		}
	
	}
}
