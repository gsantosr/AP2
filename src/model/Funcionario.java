package model;

public class Funcionario extends Gerente {

	private double comissao;
	
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String cpf, String telefone, String email, Usuario usuario) {
		super(nome, cpf, telefone, email, usuario);
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
}
	
	