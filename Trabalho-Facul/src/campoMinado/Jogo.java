package campoMinado;

public abstract class Jogo {
	
	 public abstract void iniciarJogo();


	   public void exibirTabuleiro(char[][] tabuleiro) {
	        int tamanho = tabuleiro.length;

	        System.out.print("  ");
	        for (int i = 0; i < tamanho; i++) {
	            System.out.print(i + " ");
	        }
	        System.out.println();

	        for (int i = 0; i < tamanho; i++) {
	            System.out.print(i + " ");
	            for (int j = 0; j < tamanho; j++) {
	                System.out.print(tabuleiro[i][j] + " ");
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }
}
