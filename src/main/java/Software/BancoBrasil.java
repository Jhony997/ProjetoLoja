package Software;

import Cliente.Pessoa;

import java.util.List;

public class BancoBrasil {
    private String[] listaCadastro;
    private int valorTotal;

    public BancoBrasil(String[] listaCadastro, int valorTotal) {
        this.listaCadastro = listaCadastro;
        this.valorTotal = valorTotal;
    }

    public String adicionarPessoa(String p,int id){
       return listaCadastro[id] = p;
    }

    public void acessarLista(){
        for(String num : listaCadastro){
            System.out.println(num);
        }
    }
}
