package br.ada.app.modelo;

public abstract class Jogador {
	/*Automaticamente cada jogador, seja humano ou maquina, terá um tabuleiro*/
	protected Tabuleiro tabuleiro;
	protected int pontos;
	
	public Jogador(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.pontos = 0;
	}
	
	public abstract void atirar(Tabuleiro tabuleiro);
	public abstract void posicionarNavios();
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
}
