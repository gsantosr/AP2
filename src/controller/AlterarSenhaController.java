package controller;

import java.sql.Connection;
import javax.swing.JOptionPane;
import dao.AlterarSenhaDao;
import dao.ConexaoDao;
import view.AlterarSenhaView;

public class AlterarSenhaController {
	private AlterarSenhaView alterarView;

	public AlterarSenhaController(AlterarSenhaView alterarView) {
		this.alterarView = alterarView;
	}

	public boolean mudarSenha() {
		String senha01 = alterarView.getTextSenha01().getText();
		String senha02 = alterarView.getTextSenha02().getText();
		if (senha01.equals(senha02) && !senha01.trim().isEmpty() && !senha02.trim().isEmpty()) {
			try {
				Connection conexao;
				conexao = new ConexaoDao().getConnection();
				AlterarSenhaDao senhaDao = new AlterarSenhaDao(conexao);
				senhaDao.mudarSenhaNoBanco(senha01);
				alterarView.dispose();
				return true;
			}

			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Digite um valor válido no campo", "Erro de validação",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

	}
}
