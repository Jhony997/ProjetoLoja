package Servidor.InfraServe;

import Cliente.Pessoa;
import Software.BancoBrasil;

import java.util.ArrayList;

public class RespostaBanco {
    private static BancoBrasil bd = new BancoBrasil(new ArrayList<>(),3);


    public RespostaBanco(BancoBrasil bd) {
        this.bd = bd;
    }

    public static void servePaga(Pessoa p){
        bd.pagarDivida(p);
    }

    public static void emprestimoBanco(Pessoa p, int valor){
        bd.fazerEmprestimo(p,valor);
    }

    public static void cadastraPessoa(Pessoa p, int id){
        bd.adicionarPessoa(p,id);
        //da log das pessoas
        bd.acessarLista();
    }
}
