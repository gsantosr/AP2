package model;

public class Produto {
	private int codigo;
	private String fabricante;
	private double preco;
	private String tipo;
	private String tamanho;
	private int quantidade;
	private String nome;
	
	public Produto() {
		
	}
	
	public Produto(String nome, String fabricante, String tamanho, 
			String tipo, int quantidade, double preco ) {
		this.fabricante = fabricante;
		this.preco = preco;
		this.tamanho = tamanho;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.nome = nome;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		preco = (int) (preco * 100) / 100.0;
		this.preco = preco;
	}
	
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
