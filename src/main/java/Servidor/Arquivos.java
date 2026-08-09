package Servidor;

import Cliente.Pessoa;
import Software.BancoBrasil;

import java.io.*;

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
        bw.write("nome="+ pessoa.getNome()+"\n");
        bw.write("dinheiro=" + String.valueOf(pessoa.getDinheiro()));
        bw.write("\n");
        bw.write("xp="+String.valueOf(pessoa.getExperienciaTrabalho()));
        bw.write("\n");
        bw.write("idade="+String.valueOf(pessoa.getIdade()));
        bw.write("\n");
        bw.flush();
        fw.close();
        System.out.println("Número salvo!");
    }

    // 1 save load por vez!
    public void carregarArquivo(Pessoa pessoa,BancoBrasil banco,int index) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String linha;
        int indice = -1;

        while ((linha = br.readLine()) != null){
            String[] partes = linha.split("=");
            String chave = partes[0];
            String valor = partes[1];
            System.out.println(valor);

           switch (chave){
               case "nome":
                   pessoa.setNome(valor);
                   break;
               case "dinheiro":
                   pessoa.setDinheiro(Double.parseDouble(valor));
                   break;
               case "xp":
                   pessoa.setExperienciaTrabalho(Integer.parseInt(valor));
                   break;
               case "idade":
                   pessoa.setIdade(Integer.parseInt(valor));
                   break;
               default:
                   System.err.println("Dado não encontrado!");
            }
        }
        banco.adicionarPessoa(pessoa,index);
    }
}
