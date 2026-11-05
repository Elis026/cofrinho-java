# Cofrinho de Moedas (Java)

Atividade de **Programação Orientada a Objetos** (UNINTER, Engenharia de Software).

Um cofrinho que guarda moedas de tipos diferentes (Real, Dólar e Euro) e calcula o total convertido para Real.

## Conceitos aplicados

- **Classe abstrata** (`Moeda`) e herança (`Real`, `Dolar`, `Euro`)
- **Polimorfismo**: cada moeda implementa `info()` e `converter()` do seu jeito
- `equals()` e `hashCode()` para remover uma moeda específica da lista
- Coleção `ArrayList<Moeda>` na classe `Cofrinho`
- Menu em console (adicionar, remover, listar e calcular total)

## Como executar

```bash
javac -d bin src/cofrinho/*.java
java -cp bin cofrinho.Principal
```

Também abre direto no Eclipse: rode a classe `Principal`.
