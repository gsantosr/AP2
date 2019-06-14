package controller;

import java.sql.Connection;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controllerHelper.GerentesHelper;
import dao.ProdutosDao;
import dao.ConexaoDao;
import dao.FuncionariosDao;
import dao.GerenteDao;
import dao.RemoverDao;
import model.Funcionario;
import model.Gerente;
import view.GerenteView;

public class GerenteController {

	private GerenteView janelaGerentes;
	private GerentesHelper helper;

	public GerenteController(GerenteView janela) {
		janelaGerentes = janela;
		helper = new GerentesHelper(janela);
	}

	public void preencherGerentes() {
		Connection conexao;
		try {
			conexao = new ConexaoDao().getConnection();
			GerenteDao gerenteDao = new GerenteDao(conexao);
			ArrayList<Gerente> gerentes = gerenteDao.exibirGerentes();
			helper.preencher(gerentes);
		} catch (SQLSyntaxErrorException e) {
			helper.apagarTabela();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void preencherResultados() {
		Connection conexao;
		try {
			conexao = new ConexaoDao().getConnection();
			GerenteDao gerenteDao = new GerenteDao(conexao);
			ArrayList<Gerente> gerentes = gerenteDao.buscarGerente(
					janelaGerentes.getCriterioDeBusca().getSelectedIndex(), janelaGerentes.getTextBusca().getText());
			helper.preencher(gerentes);
		} catch (SQLSyntaxErrorException e) {
			helper.apagarTabela();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// FIM MÉTODOS DE BUSCA

	// MÉTODO DE REMOÇÃO
	public void removerGerente() {
		if(janelaGerentes.getTableGerentes().getSelectedRow() != -1) {
			Connection conexao;
			try {
				conexao = new ConexaoDao().getConnection();
				RemoverDao remover = new RemoverDao(conexao);
				int linhaSelecionada = janelaGerentes.getTableGerentes().getSelectedRow();
				String cpf = (String) janelaGerentes.getTableGerentes().getValueAt(linhaSelecionada, 1);
				remover.removerGerente(cpf);
				helper.removerGerente(linhaSelecionada);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Você precisa selecionar uma linha antes", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
