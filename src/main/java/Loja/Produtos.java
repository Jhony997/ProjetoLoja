package Loja;

public class Produtos {
    //isso aqui vai dar salto conceitual

    private String nome;
    private double valor;
    private final String[] nomeGenerator = {
            "Café",
            "Espada",
            "Poção",
            "Arco",
            "Escudo",
            "Machado",
            "Adaga",
            "Elmo",
            "Anel",
            "Cristal"};

    private final String[] sobrenomeGenerator = {
            " de Ferro",
            " de Madeira",
            " de Ouro",
            " de Prata",
            " de Pedra",
            " de Cristal",
            " Mágico",
            " Sombrio",
            " Raro",
            " Lendário"};

    public Produtos(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    // getters e setters

    public void geraNomes(){
            int v = (int)(Math.random() * 9);
        this.nome = nomeGenerator[v] + sobrenomeGenerator[v];
    }

    public void geraValor(){
        this.valor = (int)(Math.random() * 100);
    }

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
