package Servidor.InfraServe;

import Cliente.Pessoa;

public class RespostaPessoa{
    private Pessoa pessoa;

    public RespostaPessoa(Pessoa p) {
        this.pessoa = p;
    }

    public static Pessoa criarPessoa(String nome,int idade){
        return new Pessoa(nome,idade,0,0,1);
    }


    public static void trabalhar(Pessoa p){
        p.setDinheiro(p.getDinheiro() + p.getSalario());
        p.setExperienciaTrabalho(p.getExperienciaTrabalho() + 1);
        System.out.println(p.getNome() + " | Total carteira : " + p.getDinheiro()+"$");

        if(p.getExperienciaTrabalho() >= 10){
            p.setSalario(p.getSalario() + 5);
            p.setExperienciaTrabalho(0);
            System.out.println(p.getNome() + "| Aumento Salario : " + p.getSalario()+"$");
        }
    }
}
