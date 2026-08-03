package Loja;

public class Produtos {
    private String nome;
    private double valor;

    public Produtos(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    // getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}
