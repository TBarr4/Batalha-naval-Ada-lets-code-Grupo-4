package br.ada.app.modelo;

public class Tabuleiro {
	private static final String JOGADOR = "Jogador";
	private static final String MAQUINA = "Maquina";
	private static final String TITULO = "-------------------------------------------------------------------------\n"
										+ "				%s\n"
										+ "-------------------------------------------------------------------------\n";
	
	public void exibir(int[][] posicoes, Jogador jogador) {
		String tipo = jogador instanceof Humano ? JOGADOR : MAQUINA;
		String tabela = TITULO;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				tabela += "|	";
			}
			tabela += "|\n-------------------------------------------------------------------------\n";
		}
		System.out.printf(tabela, tipo);
	}
}
