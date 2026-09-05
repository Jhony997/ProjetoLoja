package Cliente;

import Software.LocalTrabalho;

import java.util.Scanner;

public class Pessoa {
    private String nome;
    private int idade;
    private double dinheiro;
    private int cargoIndex;
    private int experienciaTrabalho;
    private int creditosBanco;
    private int dividaBanco;

    public Pessoa(String nome, int idade, double dinheiro,int experienciaTrabalho,int cargoIndex, int dividaBanco, int creditosBanco) {
        this.nome = nome;
        this.idade = idade;
        this.dinheiro = dinheiro;
        this.experienciaTrabalho = experienciaTrabalho;
        this.cargoIndex = cargoIndex;
        this.dividaBanco = dividaBanco;
        this.creditosBanco = creditosBanco;
    }



    //get and set


    public int getCreditosBanco() {
        return creditosBanco;
    }

    public void setCreditosBanco(int creditosBanco) {
        this.creditosBanco = creditosBanco;
    }

    public int getDividaBanco() {
        return dividaBanco;
    }

    public void setDividaBanco(int dividaBanco) {
        this.dividaBanco = dividaBanco;
    }

    public int getCargoIndex() {
        return cargoIndex;
    }

    public void setCargoIndex(int cargoIndex) {
        this.cargoIndex = cargoIndex;
    }
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
                ", experienciaTrabalho=" + experienciaTrabalho +
                ", cargoIndex=" + cargoIndex +
                '}';
    }
}
