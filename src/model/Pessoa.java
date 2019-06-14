package model;

public class Pessoa {
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	
	public Pessoa() {
		setNome(null);
		setCpf(null);
		setTelefone(null);
		setEmail(null);
	}
	
	public Pessoa(String nome, String cpf, String telefone, String email) {
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setEmail(email);
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
