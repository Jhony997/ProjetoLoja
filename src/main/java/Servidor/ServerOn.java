package Servidor;

import Cliente.Pessoa;
import Servidor.InfraServe.RespostaBanco;
import Servidor.InfraServe.RespostaLoja;
import Servidor.InfraServe.RespostaPessoa;
import Software.BancoBrasil;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ServerOn {
    private boolean isLigado;
    int idTest = -1;
    private final Scanner in = new Scanner(System.in);

    public ServerOn(boolean isLigado) {
        this.isLigado = isLigado;
    }


    public void rodarServidor(String input) throws InputMismatchException, IOException {
        //Carrega "login"
        Arquivos cm = new Arquivos();
        RespostaLoja rp = new RespostaLoja();
        rp.novosProdutos();

        Pessoa pessoaObj = new Pessoa("", 0, 0, 0, 0,0,20);
        cm.carregarArquivo(pessoaObj);

        if (pessoaObj.getNome().equalsIgnoreCase("")) {
            pessoaObj = null;
            System.err.println("Digite !cadastro iniciar!");
        } else {
            System.err.println("Perfil carregado! [ "+ pessoaObj.getNome() + " | " + pessoaObj.getDinheiro()+"$"+" ]" + " [ Divida Banco : " + pessoaObj.getDividaBanco()+"$" + " ] " + " [ Créditos emprestimo : " + pessoaObj.getCreditosBanco()+"$" + " ] ");
        }

        System.out.println("Comandos : !off, !job, !load, !save, !emprestimo, !produtos");
        while (isLigado) {
            input = in.next();

            switch (input) {
                case "!cadastro":
                    System.out.println("Digite seu nome : ");
                    input = in.next();

                    System.out.println("Digite sua idade :");
                    int inIdade = in.nextInt();

                    idTest++;
                    pessoaObj = RespostaPessoa.criarPessoa(input, inIdade);
                    RespostaBanco.cadastraPessoa(pessoaObj, idTest);
                    break;
                case "!job":
                    RespostaPessoa.trabalhar(pessoaObj);
                    break;
                case "!save":
                    cm.salvarArquivo(pessoaObj);
                    break;
                case "!emprestimo":
                    try {
                        System.out.println("Digite valor emprestimo!");
                        int value = in.nextInt();
                        RespostaBanco.emprestimoBanco(pessoaObj,value);
                    }catch (Exception e){
                        System.err.println(e.getCause() + "| Error digitação!");
                    }
                    break;
                case "!pay":
                    RespostaBanco.servePaga(pessoaObj);
                    break;
                case "!produtos":
                    rp.acessarProdutos();
                    try {
                        System.err.println("[ Digite valor compra 1-4! ]");
                       int valor = in.nextInt();
                        rp.comprarProduto(valor,pessoaObj);
                    }catch (InputMismatchException e){
                        in.next();
                        System.err.println(e.getCause() + " | Erro somente digite números!");
                    }
                    break;
                case "!off":
                    isLigado = false;
                    break;
                default:
                    System.out.println("[Inválido] Comandos : !off, !job, !save, !load, !emprestimo, !produtos");
            }
        }
    }
}
