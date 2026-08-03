package testes;

import Loja.Loja;
import Loja.Produtos;

public class testProduto2 {
    public static void main(String[] args) {
        int valorUser = 200;
        int index = 5;
       Produtos[] produtos = new Produtos[10];
        Loja loja = new Loja(produtos);


        //parece que precisa por conta do cast do int por ele retorna um valor null na loja!
        try {
            valorUser -= (int) loja.acessaProdutos(index).getValor();
            System.out.println("Você comprou : " + loja.acessaProdutos(index) +"$");
            System.out.println("Seu valor : "+valorUser+"$");
        }catch (NullPointerException e){
            System.err.println("Error Stack : " + e.getMessage());
        }
    }
}
