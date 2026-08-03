package Cliente;

import Software.LocalTrabalho;

import java.util.Scanner;

public class Pessoa {
    private String nome;
    private int idade;
    private double dinheiro;
    private Scanner in;
    private int experienciaTrabalho;

    public Pessoa(String nome, int idade, double dinheiro,int experienciaTrabalho) {
        this.nome = nome;
        this.idade = idade;
        this.dinheiro = dinheiro;
        this.experienciaTrabalho = experienciaTrabalho;
    }



    //get and set

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getExperienciaTrabalho() {
        return experienciaTrabalho;
    }

    public void setExperienciaTrabalho(int experienciaTrabalho) {
        this.experienciaTrabalho = experienciaTrabalho;
    }

    public String getNome() {
        return nome;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", dinheiro=" + dinheiro +
                ", in=" + in +
                '}';
    }
}
