package util;

import java.util.Scanner;

/**
 * Métodos de apoio para ler o que o usuário digita no console.
 *
 * Centralizar a leitura aqui evita repetir código e garante que uma
 * entrada inválida (ex.: letra no lugar de número) não derrube o programa.
 */
public class Entrada {

    private static final Scanner SCANNER = new Scanner(System.in);

    /** Lê um número inteiro entre min e max; repete até o usuário digitar algo válido. */
    public static int lerInteiro(String mensagem, int min, int max) {
        while (true) {
            System.out.print(mensagem);
            String texto = SCANNER.nextLine().trim();
            try {
                int valor = Integer.parseInt(texto);
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println("Valor fora do intervalo (" + min + " a " + max + "). Tente novamente.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            }
        }
    }

    /** Lê uma linha de texto. */
    public static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return SCANNER.nextLine().trim();
    }
}
