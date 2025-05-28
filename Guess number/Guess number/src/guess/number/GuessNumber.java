
package guess.number;
import java.util.Scanner;
public class GuessNumber {

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        Jogador jogador = new JogadorComum(nome);
        

        boolean jogarNovamente;
        do {
            Nivel nivel = escolherNivel(sc); // Escolha de dificuldade
            Logica jogo = new Logica(jogador, nivel);
            jogo.jogar();

            System.out.print("Deseja jogar novamente? (s/n): ");
            jogarNovamente = sc.nextLine().trim().equalsIgnoreCase("s");
        } while (jogarNovamente);
        
        System.out.print("Deseja ver os resultados salvos? (s/n): ");
            String verResultados = sc.nextLine().trim();
            if (verResultados.equalsIgnoreCase("s")) {
               Salvamento.exibirResultados();
            }

        System.out.println("Obrigado por jogar!");
        sc.close();
    }

    private static Nivel escolherNivel(Scanner sc) {
        System.out.println("Escolha o nível de dificuldade:");
        System.out.println("1 - Fácil (3 tentativas)");
        System.out.println("2 - Difícil (2 tentativas)");
        System.out.print("Opção: ");

        String opcao = sc.nextLine();
        return opcao.equals("2") ? new Dificil() : new Facil();
    }
}
