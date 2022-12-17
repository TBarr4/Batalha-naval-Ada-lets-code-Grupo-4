package br.ada.app.modelo;

import java.util.Scanner;

import br.ada.app.enumeration.MarcacaoEnum;

public class Humano extends Jogador {
	public Humano(Tabuleiro tabuleiro) {
		super(tabuleiro);
	}
	
	@Override//O objeto de tipo Tabuleiro pertence à maquina 
	public void atirar(Tabuleiro tabuleiro, int rodada) {
		//posiçoes referentes ao tabuleiro da máquina
		String[][] posicoes = tabuleiro.getPosicoes();
		//posições do jogador
		String[][] pos = this.tabuleiro.getPosicoes();
		int linha = this.retornaLinha(rodada, "tiro");
		int coluna = this.retornaColuna(rodada);
		if(!pos[linha][coluna].equals(MarcacaoEnum.VAZIO.getMarca()) && 
			!pos[linha][coluna].equals(MarcacaoEnum.NAVIO_POS.getMarca())) {
			
			System.out.println("Voca ja teve esse territorio marcado. Tente novamente.");
			this.atirar(tabuleiro, rodada);
		}
		this.marcarTabuleiros(tabuleiro, posicoes, linha, coluna);
	}

	@Override
	public void posicionarNavios() {
		System.out.println("Posicione seus 10 navios");
		String[][] posicoes = this.tabuleiro.getPosicoes();
		for(int i = 0; i < 10; i++) {
			int linha = this.retornaLinha(i, "navio");
			int coluna = this.retornaColuna(i);
			if(posicoes[linha][coluna].equals(MarcacaoEnum.NAVIO_POS.getMarca())) {
				System.out.println("Ja existe navio nessa posiçao. Tente novamente");
				i--;
				continue;
			}
			this.posicionarNavio(linha, coluna, posicoes);
		}
	}
	
	private void posicionarNavio(int linha, int coluna, String[][] posicoes) {
		posicoes[linha][coluna] = MarcacaoEnum.NAVIO_POS.getMarca();
		this.tabuleiro.setPosicoes(posicoes);
	}
	
	private int retornaLinha(int i, String nome) {
		System.out.printf("Insira a linha do %s %d (A-J || a-j): ", nome, (i+1));
		Scanner entrada = new Scanner(System.in);
		try {
			String linha = entrada.next();
			
			switch(linha.toUpperCase()) {
				case "A": return 1;
				case "B": return 2;
				case "C": return 3;
				case "D": return 4;
				case "E": return 5;
				case "F": return 6;
				case "G": return 7;
				case "H": return 8;
				case "I": return 9;
				case "J": return 10;
				default: 
					this.invalidaDados();
					return retornaLinha(i, nome);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			this.invalidaDados();
			return retornaLinha(i, nome);
		}
	}
	
	private int retornaColuna(int i) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Insira a coluna (0-9): ");
		int coluna = 0;
		try {
			coluna = entrada.nextInt();
			switch(coluna) {
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
					return ++coluna;
				default:
					this.invalidaDados();
					return retornaColuna(i);
			}
		} catch(Exception e) {
			this.invalidaDados();
			return retornaColuna(i);
		}
	}
	
	private void invalidaDados() {
		System.out.println("Valor inválido. Tente novamente");
	}
}