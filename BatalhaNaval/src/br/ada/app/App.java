package br.ada.app;

import br.ada.app.modelo.Humano;
import br.ada.app.modelo.Tabuleiro;

public class App {

	public static void main(String[] args) {
		int[][] posicoes = new int[9][9];
		Humano humano = new Humano();
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.exibir(posicoes, humano);
	}
}