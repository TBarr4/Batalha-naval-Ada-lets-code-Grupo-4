package br.ada.app.modelo;

import java.util.Random;

import br.ada.app.enumeration.MarcacaoEnum;

public class Maquina extends Jogador {
	public Maquina(Tabuleiro tabuleiro) {
		super(tabuleiro);
	}
	
	@Override
	public void atirar(Tabuleiro tabuleiro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void posicionarNavios() {
		String[][] posicoes = this.tabuleiro.getPosicoes();
		Random random = new Random();
		for(int i = 0; i < 10; i++) {
			int linha = this.retornaValor(random.nextInt(10));
			int coluna = this.retornaValor(random.nextInt(10));
			if(posicoes[linha][coluna].equals(MarcacaoEnum.NAVIO_POS.getMarca())) {
				i--;
				continue;
			}
			posicoes[linha][coluna] = MarcacaoEnum.NAVIO_POS.getMarca();
			this.tabuleiro.setPosicoes(posicoes);
		}
	}
	
	private int retornaValor(int valor) {
		switch(valor) {
			case 0: 
			case 1: 
			case 2: 
			case 3: 
			case 4: 
			case 5: 
			case 6: 
			case 7: 
			case 8: 
			case 9: 
				return valor++;
			default: 
				valor = new Random().nextInt(10);
				return this.retornaValor(valor);
		}
	}
}