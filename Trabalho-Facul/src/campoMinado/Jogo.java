package campoMinado;

public class Jogo {
	

    private Tabuleiro board;
	


	public void iniciarJogo() {
		
        board.gerarTabuleiro();

        while (!gameOver) {
           board. exibirTabuleiro();
            board.fazerJogada();
            board.verificarFimDeJogo();
        }

        board.exibirTabuleiro();
        System.out.println("Fim de jogo!");
    }
	
	
    
    

	}
	
