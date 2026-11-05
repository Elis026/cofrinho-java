package cofrinho;

/** Moeda Dólar (Estados Unidos). */
public class Dolar extends Moeda {

    // Taxa fixa usada na conversão (1 dólar = 5,50 reais)
    private static final double TAXA_PARA_REAL = 5.50;

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.printf("Dolar  (Estados Unidos) - US$ %.2f%n", valor);
    }

    @Override
    public double converter() {
        return valor * TAXA_PARA_REAL;
    }
}
