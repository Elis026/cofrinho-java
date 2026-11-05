package cofrinho;

/** Moeda Euro (Zona do Euro). */
public class Euro extends Moeda {

    // Taxa fixa usada na conversão (1 euro = 6,00 reais)
    private static final double TAXA_PARA_REAL = 6.00;

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.printf("Euro   (Zona do Euro)   - EUR %.2f%n", valor);
    }

    @Override
    public double converter() {
        return valor * TAXA_PARA_REAL;
    }
}
