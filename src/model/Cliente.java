package model;

public class Cliente extends Pessoa {
	private double gastoTotal;
	private double bonus;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String cpf, String telefone, String email) {
		super(nome,cpf,telefone,email);
	}

	public double getTotalGasto() {
		return gastoTotal;
	}

	public void setTotalGasto(double totalGasto) {
		this.gastoTotal = totalGasto;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}
