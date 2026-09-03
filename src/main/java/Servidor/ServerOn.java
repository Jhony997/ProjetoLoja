package Servidor;

import Cliente.Pessoa;
import Loja.Loja;
import Servidor.InfraServe.RespostaBanco;
import Servidor.InfraServe.RespostaPessoa;
import Software.BancoBrasil;
import Servidor.InfraServe.InfraServidor;
import Software.LocalTrabalho;
import Loja.Produtos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ServerOn {
    private boolean isLigado;
    int idTest = -1;
    int etapas = 0;

    private final Scanner in = new Scanner(System.in);


    Arquivos arquivos = new Arquivos();
    private int id = -1;
    Produtos[] produtos = new Produtos[10];
    Loja loja = new Loja(produtos);

    InfraServidor s = new InfraServidor();


    public ServerOn(boolean isLigado) {
        this.isLigado = isLigado;
    }


    public void rodarServidor(String input) throws InputMismatchException, IOException {
        //Inicia "login"
        Arquivos cm = new Arquivos();

            System.out.println("Digite seu nome : ");
            input = in.next();

            System.out.println("Digite sua idade :");
            int inIdade = in.nextInt();

            System.out.println("Comandos : !off, !job, !load, !save");

            idTest++;
            Pessoa pessoaObj = RespostaPessoa.criarPessoa(input, inIdade);
            RespostaBanco.cadastraPessoa(pessoaObj, idTest);



        while (isLigado) {
            input = in.next();

            switch (input) {
                case "!job":
                    RespostaPessoa.trabalhar(pessoaObj);
                    break;
                case "!load":
                    cm.carregarArquivo(pessoaObj);
                    break;
                case "!save":
                    cm.salvarArquivo(pessoaObj);
                    break;
                case "!off":
                    isLigado = false;
                    break;
                default:
                    System.out.println("[Inválido] Comandos : !off, !job, !save, !load");
            }
        }
    }
}
