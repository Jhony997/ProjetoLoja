package Servidor.InfraServe;

import Cliente.Pessoa;
import Software.LocalTrabalho;

public class RespostaPessoa{

    public RespostaPessoa(Pessoa p) {
    }

    public static Pessoa criarPessoa(String nome,int idade){
        return new Pessoa(nome,idade,0,0,0,0,20);
    }


    public static void trabalhar(Pessoa p){
        LocalTrabalho clt = new LocalTrabalho(p);
        clt.entregarSalario(p);
    }
}
