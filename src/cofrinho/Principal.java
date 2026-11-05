package cofrinho;

import java.util.Scanner;

/**
 * Classe principal: mostra o menu e conversa com o usuário.
 * Toda a lógica das moedas fica nas outras classes.
 */
public class Principal {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        Cofrinho cofrinho = new Cofrinho();
        int opcao = -1;

        while (opcao != 0) {
            mostrarMenu();
            opcao = lerInteiro("Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    Moeda nova = lerMoeda();
                    cofrinho.adicionar(nova);
                    System.out.println("Moeda adicionada!");
                    break;
                case 2:
                    Moeda procurada = lerMoeda();
                    if (cofrinho.remover(procurada)) {
                        System.out.println("Moeda removida!");
                    } else {
                        System.out.println("Nao existe uma moeda assim no cofrinho.");
                    }
                    break;
                case 3:
                    cofrinho.listagemMoedas();
                    break;
                case 4:
                    System.out.printf("Total no cofrinho: R$ %.2f%n", cofrinho.totalConvertido());
                    break;
                case 0:
                    System.out.println("Encerrando. Ate logo!");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("===== COFRINHO =====");
        System.out.println("1 - Adicionar moeda");
        System.out.println("2 - Remover moeda");
        System.out.println("3 - Listar moedas");
        System.out.println("4 - Calcular total em Real");
        System.out.println("0 - Encerrar");
    }

    /**
     * Pergunta o tipo e o valor e devolve o objeto da moeda correspondente.
     * O retorno é do tipo Moeda (mãe), mas o objeto real é Real, Dolar ou Euro.
     */
    private static Moeda lerMoeda() {
        int tipo = 0;
        while (tipo < 1 || tipo > 3) {
            System.out.println("1 - Real");
            System.out.println("2 - Dolar");
            System.out.println("3 - Euro");
            tipo = lerInteiro("Qual a moeda? ");
        }

        double valor = -1;
        while (valor <= 0) {
            valor = lerDecimal("Qual o valor da moeda? ");
            if (valor <= 0) {
                System.out.println("O valor deve ser maior que zero.");
            }
        }

        Moeda moeda;
        if (tipo == 1) {
            moeda = new Real(valor);
        } else if (tipo == 2) {
            moeda = new Dolar(valor);
        } else {
            moeda = new Euro(valor);
        }
        return moeda;
    }

    // Lê um número inteiro; se o usuário digitar texto, avisa e pede de novo
    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = teclado.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas numeros inteiros.");
            }
        }
    }

    // Lê um número decimal (aceita virgula ou ponto, ex.: 2,50 ou 2.50)
    private static double lerDecimal(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = teclado.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero valido (ex.: 2,50).");
            }
        }
    }
}
