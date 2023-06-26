package campoMinado;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {

	private char[][] tabuleiro;
    private boolean[][] minas;
    private int tamanho;
    private int totalMinas;
    
    
    public void definirJogo() {
    	
    	 Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Defina tamanho do seu tabuleiro");
    	int tamanho = scanner.nextInt();
    	
    	System.out.println("Defina quantas bombas tera no seu tabuleiro");
    	int totalMinas = scanner.nextInt();
    	
    	Jogo jogo = new CampoMinado(tamanho, totalMinas);
    	jogo.iniciarJogo();
    			
    	
    }

    public Tabuleiro(int tamanho) {
        this.tamanho = tamanho;
        this.tabuleiro = new char[tamanho][tamanho];
        this.minas = new boolean[tamanho][tamanho];
    }

    public void limparTabuleiro() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                tabuleiro[i][j] = '?';
            }
        }
    }

    public void gerarMinas(int totalMinas) {
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
    
    public boolean posicaoValida(int linha, int coluna) {
        return linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho;
    }

    public boolean posicaoRevelada(int linha, int coluna) {
        return tabuleiro[linha][coluna] != '?';
 
    }

    public void revelarPosicao(int linha, int coluna) {
        tabuleiro[linha][coluna] = '.';
    }

    public boolean temMina(int linha, int coluna) {
        return minas[linha][coluna];
    }

    public int contarMinasAdjacentes(int linha, int coluna) {
        int count = 0;

        for (int i = linha - 1; i <= linha + 1; i++) {
            for (int j = coluna - 1; j <= coluna + 1; j++) {
                if (posicaoValida(i, j) && temMina(i, j)) {
                    count++;
                }
            }
        }

        return count;
    }
    
    
    public int jogadasRestantes() {
        int totalMinas = 0;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiro[i][j] == '?') {
                    totalMinas++;
                }
            }
        }
        return totalMinas;
    }

    public char[][] getTabuleiro() {
        return tabuleiro;
    }

    public void atualizarPosicao(int linha, int coluna, char valor) {
        tabuleiro[linha][coluna] = valor;
    }
    


}	