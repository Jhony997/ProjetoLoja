package Servidor;

import Cliente.Pessoa;
import Software.BancoBrasil;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Arquivos {
    private File diretorio = new File("banco");
    private File file = new File(diretorio,"banco.txt");


    public void criarArquivo() throws IOException {
        boolean isDiretorio = diretorio.mkdir();
        boolean isCriado = file.createNewFile();

        if(isCriado){
            System.out.println("Diretorio [banco] foi criado");
            System.out.println("Arquivo [banco.txt] criado com sucesso!!");
        }else {
            System.out.println("Diretorio [banco] não foi criado!");
            System.out.println("Arquivo [banco.txt] não foi criado!");
        }
    }

    public void salvarArquivo(Pessoa pessoa) throws IOException {
        //sem append true -> rescrever é isso que eu quero!
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        //salvar dados
        bw.write(pessoa.getNome()+"\n");
        bw.write(String.valueOf(pessoa.getDinheiro()));
        bw.write("\n");
        bw.write(String.valueOf(pessoa.getExperienciaTrabalho()));
        bw.write("\n");
        bw.write(String.valueOf(pessoa.getIdade()));
        bw.write("\n");
        bw.flush();
        fw.close();
        System.out.println("Número salvo!");
    }

    public void carregarArquivo(Pessoa pessoa,BancoBrasil banco,int index) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String linha;
        while ((linha = br.readLine()) != null){
            System.out.println(linha);

            switch (linha) {
                case "JJ":
                 pessoa.setNome(linha);
                break;
                case "3016.0":
             pessoa.setDinheiro(Double.parseDouble(linha));
                break;
                case "15":
                pessoa.setExperienciaTrabalho(Integer.parseInt(linha));
                break;
                case "30":
                pessoa.setIdade(Integer.parseInt(linha));
                break;
                default:
                    System.out.println("Load inválido!");
                    break;
            }
        }
        banco.adicionarPessoa(pessoa,index);
    }
}
