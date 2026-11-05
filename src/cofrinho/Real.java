package cofrinho;

/** Moeda Real (Brasil). É a moeda base, então a conversão não altera o valor. */
public class Real extends Moeda {

    public Real(double valor) {
        super(valor); // chama o construtor da classe mãe
    }

    @Override
    public void info() {
        System.out.printf("Real   (Brasil)         - R$ %.2f%n", valor);
    }

    @Override
    public double converter() {
        return valor; // 1 Real = 1 Real
    }
}
