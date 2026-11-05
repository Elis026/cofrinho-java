package cofrinho;

import java.util.ArrayList;

/**
 * Representa o cofrinho: guarda uma coleção de moedas de qualquer tipo.
 *
 * A lista é de "Moeda" (a classe mãe), então ela aceita Real, Dolar, Euro
 * e qualquer moeda nova que for criada no futuro, sem mudar esta classe.
 */
public class Cofrinho {

    private ArrayList<Moeda> listaMoedas = new ArrayList<Moeda>();

    /** Coloca uma moeda dentro do cofrinho. */
    public void adicionar(Moeda moeda) {
        listaMoedas.add(moeda);
    }

    /**
     * Retira UMA moeda igual à informada (mesmo tipo e mesmo valor).
     * Devolve true se encontrou e removeu, false se não existia.
     */
    public boolean remover(Moeda moeda) {
        return listaMoedas.remove(moeda); // usa o equals() da classe Moeda
    }

    /** Mostra todas as moedas guardadas. */
    public void listagemMoedas() {
        if (listaMoedas.isEmpty()) {
            System.out.println("O cofrinho esta vazio.");
            return;
        }
        int numero = 1;
        for (Moeda m : listaMoedas) {
            System.out.print(numero + " - ");
            m.info(); // POLIMORFISMO: cada moeda imprime do seu jeito
            numero++;
        }
    }

    /** Soma tudo o que está no cofrinho, já convertido para Real. */
    public double totalConvertido() {
        double total = 0;
        for (Moeda m : listaMoedas) {
            total += m.converter(); // POLIMORFISMO: cada moeda converte do seu jeito
        }
        return total;
    }
}
