package Servidor.InfraServe;

import Cliente.Pessoa;
import Loja.Produtos;

import java.util.ArrayList;
import java.util.List;

public class RespostaLoja {
    private static final List<Produtos> produtosLista = new ArrayList<>();

    public void novosProdutos() {
        for (int i = 0; i < 4; i++) {
            Produtos produtos = new Produtos("", 0);

            produtos.geraNomes();
            produtos.geraValor();


            produtosLista.add(i, produtos);

        }
    }

    public void acessarProdutos() {
        for (int i = 0; i < 4; i++) {
            System.out.println(i+".[ " + produtosLista.get(i).getNome() + " ] : " + produtosLista.get(i).getValor() + "$");
        }
    }

    public void comprarProduto(int id, Pessoa p){
        if(id < 4) {
            if(p.getDinheiro() >= produtosLista.get(id).getValor()) {
                p.setDinheiro(p.getDinheiro() - produtosLista.get(id).getValor());
                System.out.println("Você comprou : " + produtosLista.get(id).getNome() + " : " + produtosLista.get(id).getValor()+"$");
            }else {
                System.err.println("Erro | Sem dinheiro!");
            }
        }else {
            System.err.println("Erro | Digite números 1-4!");
        }
    }
}
