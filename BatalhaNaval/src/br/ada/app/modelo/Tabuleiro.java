package br.ada.app.modelo;

public class Tabuleiro {
	private String[][] posicoes;
	
	private static final String JOGADOR = "Jogador";
	private static final String MAQUINA = "Maquina";
	private static final String TITULO = "---------------------------------------------\n"
										+ "		    %s\n"
										+ "---------------------------------------------\n";
	
	public Tabuleiro() {
		this.posicoes = new String[11][11];
	}
	
	public void exibir(Jogador jogador) {
		String tipo = jogador instanceof Humano ? JOGADOR : MAQUINA;
		String tabela = TITULO;
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				if(j == 0) {
					tabela += "| " + getCharacter(i) + " ";
				} else {
					tabela += "|   ";
				}
			}
			tabela += "|\n---------------------------------------------\n";
		}
		System.out.printf(tabela, tipo);
	}
	
	private String getCharacter(int number) {
		switch(number) {
			case 1: return "A";
			case 2: return "B";
			case 3: return "C";
			case 4: return "D";
			case 5: return "E";
			case 6: return "F";
			case 7: return "G";
			case 8: return "H";
			case 9: return "I";
			case 10: return "J";
			default: return " ";
		}
	}
}
