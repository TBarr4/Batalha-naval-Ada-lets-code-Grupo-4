package br.ada.app.modelo;

import java.util.Scanner;

import br.ada.app.enumeration.MarcacaoEnum;

public class Humano extends Jogador {
	public Humano(Tabuleiro tabuleiro) {
		super(tabuleiro);
	}
	
	@Override//Tabuleiro da maquina como parametro 
	public void atirar(Tabuleiro tabuleiro) {
		String[][] posicoes = tabuleiro.getPosicoes();
		int linha = this.getValor();
		int coluna = this.getValor();
		
	}

	@Override
	public void posicionarNavios() {
		System.out.println("Posicione seus 10 navios");
		String[][] posicoes = this.tabuleiro.getPosicoes(); 
		for(int i = 0; i < 10; i++) {
			int linha = this.retornaLinha(i);
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
	
	private int retornaLinha(int i) {
		Scanner entrada = new Scanner(System.in);
		System.out.printf("Insira a linha do navio %d (A-J || a-j): ", (i+1));
		String linha = entrada.nextLine();
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
				return retornaLinha(i);
		}
	}
	
	private int retornaColuna(int i) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Insira a coluna (0-9): ");
		int y = 0;
		try {
			y = entrada.nextInt();
			switch(y) {
				case 0: return 1;
				case 1: return 2;
				case 2: return 3;
				case 3: return 4;
				case 4: return 5;
				case 5: return 6;
				case 6: return 7;
				case 7: return 8;
				case 8: return 9;
				case 9: return 10;
				default:
					this.invalidaDados();
					return retornaColuna(i);
			}
		} catch(Exception e) {
			this.invalidaDados();
			return retornaColuna(i);
		}
	}
	
	private int getValor() {
		Scanner entrada = new Scanner(System.in);
		int valor = 0;
		try {
			valor = entrada.nextInt();
			entrada.close();
			return valor;
		} catch(Exception e) {
			this.invalidaDados();
			entrada.close();
			return this.getValor();
		}
	}
	
	private void invalidaDados() {
		System.out.println("Valor inválido. Tente novamente");
	}
	
	//os parametros do método são todos relacionados ao tabuleiro da máquina
	private void marcarTabuleiros(Tabuleiro tabuleiro, String[][] posicoes, int linha, int coluna) {
		//posições do tabuleiro do objeto jogador humano
		String[][] pos = this.tabuleiro.getPosicoes();
		
		if(posicoes[linha][coluna].equals(MarcacaoEnum.NAVIO_POS.getMarca())) {
			posicoes[linha][coluna] = MarcacaoEnum.TIRO_CERTEIRO_NAVIO.getMarca();
			this.pontos++;
			if(pos[linha][coluna].equals(MarcacaoEnum.NAVIO_POS)) {
				pos[linha][coluna] = MarcacaoEnum.TIRO_AGUA_NAVIO.getMarca();
			} else {
				pos[linha][coluna] = MarcacaoEnum.TIRO_CERTEIRO.getMarca();
			}
		} else if(posicoes[linha][coluna].equals(MarcacaoEnum.VAZIO.getMarca())) {
			pos[linha][coluna] = MarcacaoEnum.TIRO_AGUA.getMarca();
		}
	}
}