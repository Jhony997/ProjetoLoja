package Software;

import Cliente.Pessoa;

import java.util.List;

public class BancoBrasil {
    private List<Pessoa> listaCadastro;
    private int valorTotal;

    public BancoBrasil(List<Pessoa> listaCadastro, int valorTotal) {
        this.listaCadastro = listaCadastro;
        this.valorTotal = valorTotal;
    }

    // adiciona a listaCadastro
    public void adicionarPessoa(Pessoa p,int id){
        listaCadastro.add(id,p);
    }

    public void acessarLista(){
        for (Pessoa pessoa : listaCadastro) {
            System.out.println(pessoa);
        }
    }
}
