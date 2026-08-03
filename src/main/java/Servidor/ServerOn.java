package Servidor;

import Cliente.Pessoa;
import Loja.Loja;
import Software.BancoBrasil;
import Software.LocalTrabalho;
import Loja.Produtos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ServerOn {
    private boolean isLigado;
    private final Scanner in = new Scanner(System.in);
    private final BancoBrasil bd = new BancoBrasil(new ArrayList<>(),3);
    Pessoa pessoa = new Pessoa("", 0, 0,0);
    LocalTrabalho trabalho = new LocalTrabalho(pessoa);
    Arquivos arquivos = new Arquivos();
    private int id = -1;
    Produtos[] produtos = new Produtos[10];
    Loja loja = new Loja(produtos);


    public ServerOn(boolean isLigado) {
        this.isLigado = isLigado;
    }


    public void rodarServidor(String input){
        System.out.println("Comandos : !cadastro, !acessar, !off, !job, !loja, !save, !load");
        while (isLigado){

            input = in.next();
            int indexProduto = 0;

            switch (input){
                case "!cadastro":
                    try {
                        System.out.println("Digite seu nome : ");
                        input = in.next();

                        System.out.println("Digite sua idade :");
                        int inIdade = in.nextInt();

                        pessoa = new Pessoa(input, inIdade, 0,0);
                        System.out.println("Cadastro criado!");
                        id++;

                        bd.adicionarPessoa(pessoa,id);
                    }catch (InputMismatchException e){
                        System.out.println(e.getMessage() + " [Erro somente número!]");
                        in.next();
                    }
                    break;
                case "!acessar":
                        bd.acessarLista();
                    break;
                case "!job":
                    System.out.println(pessoa.getNome() + " : Trabalhou por 72 horas!");
                    trabalho.entregarSalario(pessoa);
                    System.out.println("Saldo atual : "+pessoa.getDinheiro()+"$");
                    break;
                case "!loja":
                    loja.carregarListaProdutos(loja);

                    // teria que ser mais específico mais tem 2 casos?
                    try {
                        System.out.println("Digite valor id produto 1-10 (comprar)");
                        indexProduto = in.nextInt();

                        if(pessoa.getDinheiro() >= loja.acessaProdutos(indexProduto).getValor()) {
                            pessoa.setDinheiro(pessoa.getDinheiro() - loja.acessaProdutos(indexProduto).getValor());
                            System.out.println(pessoa.getNome() + " Comprou : " + loja.acessaProdutos(indexProduto) + "$");
                            System.out.println(pessoa.getNome() + " Saldo atual : " + pessoa.getDinheiro() + "$");
                        }else {
                            System.err.println("Valor inválido!! Saldo atual : "+pessoa.getDinheiro()+"$");
                        }
                    }catch (Exception e){
                        System.err.println("Error : " + e.getMessage());
                        in.next();
                    }
                    break;
                case "!off":
                    isLigado = false;
                    break;
                case "!save":
                    try {
                        arquivos.salvarArquivo(pessoa);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "!load":
                    try {
                        arquivos.carregarArquivo(pessoa,bd,0);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println("[Inválido] Comandos : !cadastro, !acessar, !off, !job, !loja, !save, !load");
            }
        }
    }
}
