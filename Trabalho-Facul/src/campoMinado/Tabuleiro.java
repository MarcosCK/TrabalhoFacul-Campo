package campoMinado;

import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {
	
	 private int tamanho;
	 private int totalMinas;
     private boolean[][] tabuleiro;
	 private boolean[][] minas;
	 private boolean[][] revelado;
	 private boolean gameOver;
	 

	public Tabuleiro(Boolean gameOver) {
		tamanho = 5;
		totalMinas = 5;
		tabuleiro = new boolean[tamanho][tamanho];
		minas = new boolean[tamanho][tamanho];
		revelado = new boolean[tamanho][tamanho];
		this.gameOver = false;
	}
	
	 public void gerarTabuleiro() {
	        Random random = new Random();

	        int minasRestantes = totalMinas;

	        while (minasRestantes > 0) {
	            int linha = random.nextInt(tamanho);
	            int coluna = random.nextInt(tamanho);

	            if (!minas[linha][coluna]) {
	                minas[linha][coluna] = true;
	                minasRestantes--;
	            }
	        }
	    }

	    public void exibirTabuleiro() {
	        System.out.print("  ");
	        for (int i = 0; i < tamanho; i++) {
	            System.out.print(i + " ");
	        }
	        System.out.println();

	        for (int i = 0; i < tamanho; i++) {
	            System.out.print(i + " ");
	            for (int j = 0; j < tamanho; j++) {
	                if (revelado[i][j]) {
	                    System.out.print(tabuleiro[i][j] + " ");
	                } else {
	                    System.out.print("? ");
	                }
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }

	    public void fazerJogada() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Informe a linha: ");
	        int linha = scanner.nextInt();

	        System.out.print("Informe a coluna: ");
	        int coluna = scanner.nextInt();

	        if (linha < 0 || linha >= tamanho || coluna < 0 || coluna >= tamanho) {
	            System.out.println("Posição inválida!");
	            return;
	        }

	        if (revelado[linha][coluna]) {
	            System.out.println("Posição já revelada!");
	            return;
	        }
	    }

	    private int contarMinasAdjacentes(int linha, int coluna) {
	        int count = 0;

	        for (int i = linha - 1; i <= linha + 1; i++) {
	            for (int j = coluna - 1; j <= coluna + 1; j++) {
	                if (i >= 0 && i < tamanho && j >= 0 && j < tamanho) {
	                    if (minas[i][j]) {
	                        count++;
	                    }
	                }
	            }
	        }

	        return count;
	    }

	    public void verificarFimDeJogo() {
	        int jogadasRestantes = tamanho * tamanho - totalMinas;

	        if (jogadasRestantes == 0) {
	            gameOver = true;
	        }
	    }

	    public static void main(String[] args) {
	        int tamanho = 5; // Tamanho do tabuleiro
	        int totalMinas = 5; // Número total de minas

	        CampoMinado campoMinado = new CampoMinado(tamanho, totalMinas);
	        campoMinado.iniciarJogo();
	    }

	 
	 
	
	

}