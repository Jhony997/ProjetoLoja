package Loja;

import java.util.Arrays;

public class Loja {
    private final Produtos[] produtos;


    public Loja(Produtos[] produtos){
        produtos[0] = new Produtos("Caneta",1);
        produtos[1] = new Produtos("Caderno",5);
        produtos[2] = new Produtos("Lapis",21);
        produtos[3] = new Produtos("Ps2",30);
        produtos[4] = new Produtos("Ps1",15);
        produtos[5] = new Produtos("Controle Ps2",5);
        produtos[6] = new Produtos("Controle Ps1",2);
        this.produtos = produtos;
    }

    // preciso aprender a usar na sinatura do metodo o try!
    public Produtos acessaProdutos(int index){
        try {
            return produtos[index];
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Error : " + e.getCause() + " | produto não listado!");
        }
        return null;
    }

    public void carregarListaProdutos(Loja loja){
        int index = -1;
        for(Produtos e : this.produtos){
            index++;
            System.out.print(index + ". "+ e + " | ");
        }
        System.out.println(" ");
    }
}
