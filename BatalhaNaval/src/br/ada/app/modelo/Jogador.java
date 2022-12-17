package br.ada.app.modelo;

import br.ada.app.enumeration.MarcacaoEnum;

public abstract class Jogador {
	/*Automaticamente cada jogador, seja humano ou maquina, ter� um tabuleiro*/
	protected Tabuleiro tabuleiro;
	protected int pontos;
	
	public Jogador(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.pontos = 0;
	}
	
	public abstract void atirar(Tabuleiro tabuleiro, int rodada);
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
	
	//os parametros do m�todo, s�o todos relacionados ao tabuleiro contr�rio de quem chamou este m�todo
	protected void marcarTabuleiros(Tabuleiro tabuleiro, String[][] posicoes, int linha, int coluna) {
		//posi��es do tabuleiro de quem chamou o m�todo
		String[][] pos = this.tabuleiro.getPosicoes();
		
		if(posicoes[linha][coluna].equals(MarcacaoEnum.NAVIO_POS.getMarca())) {
			posicoes[linha][coluna] = MarcacaoEnum.TIRO_CERTEIRO_NAVIO.getMarca();
			this.pontos++;
			if(pos[linha][coluna].equals(MarcacaoEnum.NAVIO_POS.getMarca())) {
				pos[linha][coluna] = MarcacaoEnum.TIRO_AGUA_NAVIO.getMarca();
			} else {
				pos[linha][coluna] = MarcacaoEnum.TIRO_CERTEIRO.getMarca();
			}
		} else if(posicoes[linha][coluna].equals(MarcacaoEnum.VAZIO.getMarca())) {
			if(pos[linha][coluna].equals(MarcacaoEnum.VAZIO.getMarca())) {
				pos[linha][coluna] = MarcacaoEnum.TIRO_AGUA.getMarca();
			} 
		} 
	}
}
