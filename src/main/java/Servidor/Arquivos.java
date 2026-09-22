package Servidor;

import Cliente.Pessoa;
import Software.BancoBrasil;

import java.io.*;

public class Arquivos {
    private final File diretorio = new File("banco");
    private final File file = new File(diretorio,"banco.txt");


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
        bw.write(pessoa.getNome()+";" + pessoa.getDinheiro() +";"+ pessoa.getExperienciaTrabalho() +";"+ pessoa.getIdade() + ";"+pessoa.getCargoIndex() + ";"+pessoa.getDividaBanco() + ";"+pessoa.getCreditosBanco());
        bw.flush();
        fw.close();
        bw.close();
        System.out.println("Progresso salvo!");
    }

    // 1 save load por vez!
    public void carregarArquivo(Pessoa pessoa) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String linha;
        int indice = -1;

        while ((linha = br.readLine()) != null){
            String[] partes = linha.split(";");

            //recuperando as info!
            pessoa.setNome(partes[0]);
            pessoa.setDinheiro(Double.parseDouble(partes[1]));
            pessoa.setExperienciaTrabalho(Integer.parseInt(partes[2]));
            pessoa.setIdade(Integer.parseInt(partes[3]));
            pessoa.setCargoIndex(Integer.parseInt(partes[4]));
            pessoa.setDividaBanco(Integer.parseInt(partes[5]));
            pessoa.setCreditosBanco(Integer.parseInt(partes[6]));
        }
    }
}
