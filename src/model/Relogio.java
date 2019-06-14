package model;

import java.util.Calendar;

import view.MenuPrincipalView;

public class Relogio extends Thread {
	private boolean rodando;
	private boolean pausar;
	private Tempo tempo;
	private MenuPrincipalView janelaMenu;
	
	public Relogio(MenuPrincipalView janelaMenu) {
		this.janelaMenu = janelaMenu;
		rodando = true;
		pausar = false;
		tempo = new Tempo();
		janelaMenu.getRelogio().setVisible(true);
		start();
	}
	
	public void run() {
		if(rodando) {
			tempo.setHoras(java.time.LocalTime.now().getHour());
			tempo.setMinutos(java.time.LocalTime.now().getMinute());
			tempo.setSegundos(java.time.LocalTime.now().getSecond());
			while(!pausar) {
				//mudar o title aqui e o relogio tá pronto
				janelaMenu.getRelogio().setText(tempo.getHoras() + ":" + tempo.getMinutos() + ":" + tempo.getSegundos());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				tempo.maisSegundos();
			}
		}
	}

	public void pausarRelogio() {
		pausar = true;
	}
	
	public void voltarRelogio() {
		pausar = false;
		this.start();
	}
	
	public void fecharRelogio() {
		janelaMenu.getRelogio().setVisible(false);
		rodando = false;
	}
	
}