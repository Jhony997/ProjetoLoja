package Servidor;

import java.io.File;
import java.io.IOException;
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
}
