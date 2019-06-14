package model;

public class Tempo {
	private int horas;
	private int minutos;
	private int segundos;
	
	public Tempo() {
		horas = 0;
		minutos = 0;
		segundos = 0;
	}
	
	public Tempo(int horas, int minutos, int segundos) {
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	
	public void maisSegundos() {
		if(0 <= segundos && segundos <= 58)
			segundos++;
		else
			maisMinutos();
	}
	
	public void maisMinutos() {
		if(0 <= minutos && minutos <= 58) {
			minutos++;
		}
		else {
			maisHoras();
		}
		segundos = 0;
	}
	
	public void maisHoras() {
		if(0 <= horas && horas < 23) {
			horas++;
			minutos = 0;
		}
		else {
			horas = 0;
			minutos = 0;
			segundos = 0;
		}	
	}
	
}
