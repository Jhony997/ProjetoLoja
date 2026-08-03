package testes;

import Loja.Produtos;

public class testProduto {
    public static void main(String[] args) {
        Produtos[] produtos = new Produtos[7];
        produtos[0] = new Produtos("Caneta",1);
        produtos[1] = new Produtos("Caderno",5);
        produtos[2] = new Produtos("Lapis",21);
        produtos[3] = new Produtos("Ps2",30);
        produtos[4] = new Produtos("Ps1",15);
        produtos[5] = new Produtos("Controle Ps2",5);
        produtos[6] = new Produtos("Controle Ps1",2);

        for(int i = 0; i < produtos.length; i++){
            System.out.println(produtos[i]);
        }

        System.out.println(" ");

        //simula a loja aqui :
        int dinheiroUser = 200;
        int indexProduto = 2;

        //talvez trate erro assim? não perde legibilidade?
        try {
            dinheiroUser -= (int) produtos[indexProduto].getValor();
            System.out.println("Você comprou : " + produtos[indexProduto].getNome() + " | Valor : " + produtos[indexProduto].getValor()+"$");
            System.out.println("Seu dinheiro atual : " + dinheiroUser+"$");

        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Error : " + e.getMessage() + " | Item não listado!");
        }
    }
}
