package br.ada.app;

import br.ada.app.modelo.Humano;
import br.ada.app.modelo.Maquina;
import br.ada.app.modelo.Tabuleiro;

public class App {
	private static final String RESULTADO = "JOGADOR %d x %d MAQUINA";
	public static void main(String[] args) {
		instrucoes();
		
		Humano humano = new Humano(new Tabuleiro());
		Maquina maquina = new Maquina(new Tabuleiro());
		
		humano.getTabuleiro().exibir(humano);
		
		humano.posicionarNavios();
		maquina.posicionarNavios();
		int rodada = 0;
		
		do {
			humano.getTabuleiro().exibir(humano);
			humano.atirar(maquina.getTabuleiro(), rodada);
			maquina.atirar(humano.getTabuleiro(), rodada);
			System.out.printf("\n".concat(RESULTADO), humano.getPontos(), maquina.getPontos());
			rodada++;
		} while(humano.getPontos() < 10 && maquina.getPontos() < 10);
		
		humano.getTabuleiro().exibir(humano);
		maquina.getTabuleiro().exibir(maquina);
		
		if(humano.getPontos() == 10) {
			System.out.printf("Jogador venceu!\n".concat(RESULTADO), humano.getPontos(), maquina.getPontos());
		} else {
			System.out.printf("Maquina venceu!\n".concat(RESULTADO), humano.getPontos(), maquina.getPontos());
		}
	}
	
	private static void instrucoes() {

		System.out.println("Batalha Naval.");
		System.out.println("Neste jogo de tabuleiro, o objetivo é acertar os navios inimigos.");
		System.out.println("Cada jogador posicionará 10 navios em qualquer coordenada do seu tabuleiro de 10x10.");
		System.out.println("A cada rodada, cada jogador informa as coordenadas de seu ataque.");
		System.out.println("Para realizar ataques informe as coordenadas no formato letra e numero. Ex. A1, H3, etc.");
		System.out.println("Vencerá o jogo quem acertar primeiro todas as 10 embarcações inimigas.");
		System.out.println("Boa sorte!");

	}
}