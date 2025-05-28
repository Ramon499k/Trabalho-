
package guess.number;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Salvamento {
     public static void salvarResultado(String nomeJogador, boolean venceu) {
        try (FileWriter writer = new FileWriter("resultado.txt", true)) {
            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            writer.write(String.format("%s - %s - %s%n", dataHora, nomeJogador, venceu ? "Venceu" : "Perdeu"));
        } catch (IOException e) {
            System.out.println("Erro ao salvar resultado: " + e.getMessage());
        }
    }

    public static void exibirResultados() {
        System.out.println("\n📋 Resultados salvos:");

        try (BufferedReader reader = new BufferedReader(new FileReader("resultado.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println("• " + linha);
            }
        } catch (IOException e) {
            System.out.println("Não foi possível ler o arquivo: " + e.getMessage());
        }

        System.out.println(); // quebra de linha no final
    }
}

