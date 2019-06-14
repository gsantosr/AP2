package model;

public class Gerente extends Pessoa {
	private double salario;
	private Usuario usuario;
	
	public Gerente() {
		super();
		setUsuario(new Usuario());
	}

	public Gerente(String nome, String cpf, String telefone, String email, Usuario usuario) {
		super(nome, cpf, telefone, email);
		this.usuario = usuario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
