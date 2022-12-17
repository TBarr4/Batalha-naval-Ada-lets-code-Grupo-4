package br.ada.app;

import br.ada.app.modelo.Humano;
import br.ada.app.modelo.Maquina;
import br.ada.app.modelo.Tabuleiro;

public class App {
	private static final String RESULTADO = "jogador %d X maquina %d";
	public static void main(String[] args) {
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
}