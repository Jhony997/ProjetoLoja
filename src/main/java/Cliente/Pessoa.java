package Cliente;

import java.util.Scanner;

public class Pessoa {
    private String nome;
    private int idade;
    private double dinheiro;
    private Scanner in;

    public Pessoa(String nome, int idade, double dinheiro) {
        this.nome = nome;
        this.idade = idade;
        this.dinheiro = dinheiro;
    }

    public String getNome() {
        return nome;
    }
}
