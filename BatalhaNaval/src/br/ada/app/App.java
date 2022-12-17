package br.ada.app;

import java.util.Scanner;

import br.ada.app.modelo.Humano;
import br.ada.app.modelo.Maquina;
import br.ada.app.modelo.Tabuleiro;

public class App {

	public static void main(String[] args) {
		Humano humano = new Humano(new Tabuleiro());
		Maquina maquina = new Maquina(new Tabuleiro());
		
		humano.getTabuleiro().exibir(humano);
		
		humano.setPontos(0);
		maquina.setPontos(0);
		
		humano.posicionarNavios();
		maquina.posicionarNavios();
		
		do {
			humano.getTabuleiro().exibir(humano);
			
		} while(humano.getPontos() < 10 && maquina.getPontos() < 10);
	}
}