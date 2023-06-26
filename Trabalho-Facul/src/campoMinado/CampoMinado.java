package campoMinado;
import java.util.Scanner;



public class CampoMinado extends Jogo {

	 
    private Tabuleiro tabuleiro;
    private boolean gameOver;

    public CampoMinado(int tamanho, int totalMinas) {
        this.tabuleiro = new Tabuleiro(tamanho);
        this.tabuleiro.limparTabuleiro();
        this.tabuleiro.gerarMinas(totalMinas);
        this.gameOver = false;
    }

    @Override
    public void iniciarJogo() {
        while (!gameOver) {
            exibirTabuleiro(tabuleiro.getTabuleiro());
            fazerJogada();
            verificarFimDeJogo();
        }

        exibirTabuleiro(tabuleiro.getTabuleiro());
        System.out.println("Fim de jogo!");
    }

    private void fazerJogada() {
    	
    	
    	
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a linha: ");
        int linha = scanner.nextInt();

        System.out.print("Informe a coluna: ");
        int coluna = scanner.nextInt();

        if (!tabuleiro.posicaoValida(linha, coluna)) {
            System.out.println("Posição inválida!");
            return;
        }

        if (tabuleiro.posicaoRevelada(linha, coluna)) {
            System.out.println("Posição já revelada!");
            return;
        }

        tabuleiro.revelarPosicao(linha, coluna);

        if (tabuleiro.temMina(linha, coluna)) {
            gameOver = true;
            tabuleiro.atualizarPosicao(linha, coluna, 'X');
        } else {
            int numMinasAdjacentes = tabuleiro.contarMinasAdjacentes(linha, coluna);
            tabuleiro.atualizarPosicao(linha, coluna, (char) ('0' + numMinasAdjacentes));
        }
    }

    private void verificarFimDeJogo() {
        if (tabuleiro.jogadasRestantes() == 0) {
            gameOver = true;
        }
    }

	
	
}
	