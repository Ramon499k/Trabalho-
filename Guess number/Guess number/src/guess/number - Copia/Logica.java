
package guess.number;
import java.util.Random;
import java.util.Scanner;


public class Logica {
    private Jogador jogador;
    private Nivel nivel;
    private int guessNumber;

    public Logica(Jogador jogador, Nivel nivel) {
        this.jogador = jogador;
        this.nivel = nivel;
        this.guessNumber = (int)(Math.random() * 100) + 1;
    }

    public void jogar() {
        Scanner sc = new Scanner(System.in);
        int tentativas = nivel.getTentativas();
        boolean venceu = false;

        System.out.println("Adivinhe o número entre 1 e 100!");

        while (tentativas > 0) {
            System.out.print("Digite seu palpite: ");
            int palpite = sc.nextInt();
            sc.nextLine(); // Limpa o buffer
            tentativas--;

            if (palpite == guessNumber) {
                System.out.println("Parabéns! Você acertou!");
                venceu = true;
                break;
            } else if (palpite < guessNumber) {
                System.out.println("O número secreto é MAIOR!");
            } else {
                System.out.println("O número secreto é MENOR!");
            }

            System.out.println("Tentativas restantes: " + tentativas);
        }

        if (!venceu) {
            System.out.println("Fim de jogo! O número era: " + guessNumber);
        }

            Salvamento.salvarResultado(jogador.getNome(), venceu);
    }
}

