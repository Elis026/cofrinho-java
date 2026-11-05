package cofrinho;

/**
 * Classe mãe ABSTRATA de todas as moedas do cofrinho.
 *
 * Ela guarda o que é comum a qualquer moeda (o valor) e obriga as filhas
 * (Dolar, Euro, Real...) a implementarem info() e converter().
 * Como é abstrata, não podemos fazer "new Moeda(...)", só instanciar as filhas.
 */
public abstract class Moeda {

    // Valor da moeda na sua própria unidade (ex.: 5.0 dólares, 2.5 euros)
    protected double valor;

    public Moeda(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    /**
     * Imprime na tela os dados da moeda (tipo e valor).
     * Cada filha escreve a sua versão: aqui entra o POLIMORFISMO.
     */
    public abstract void info();

    /**
     * Devolve o valor desta moeda convertido para Real.
     * Cada filha aplica a sua própria taxa de câmbio.
     */
    public abstract double converter();

    /**
     * Duas moedas são iguais quando são do MESMO TIPO (mesma classe) e
     * têm o MESMO VALOR. É isso que permite remover uma moeda específica
     * do ArrayList (o método remove() usa o equals()).
     */
    @Override
    public boolean equals(Object outro) {
        if (this == outro) {
            return true;
        }
        if (outro == null || getClass() != outro.getClass()) {
            return false;
        }
        Moeda m = (Moeda) outro; // type cast: já sabemos que é a mesma classe
        return Double.compare(this.valor, m.valor) == 0;
    }

    // Regra do Java: se sobrescrevemos equals, devemos sobrescrever hashCode também
    @Override
    public int hashCode() {
        return 31 * getClass().hashCode() + Double.hashCode(valor);
    }
}
