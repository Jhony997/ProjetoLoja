import Cliente.Pessoa;
import Servidor.Arquivos;
import Software.BancoBrasil;

import java.io.IOException;
import java.util.ArrayList;

public class Site {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Jonas",1,5.0);
        Pessoa p2 = new Pessoa("Marcos",1,5.0);
        Pessoa p3 = new Pessoa("Antonho",1,5.0);
        Pessoa p4 = new Pessoa("Aurelio",1,5.0);
        Pessoa p5 = new Pessoa("Kelvin",1,5.0);
        Arquivos arquivos = new Arquivos();
        String[] nomes = {p1.getNome(),p2.getNome(),p3.getNome(),p4.getNome(),p5.getNome()};
        BancoBrasil bd = new BancoBrasil(nomes,15_000);

        bd.adicionarPessoa(nomes[0],0);
        bd.adicionarPessoa(nomes[1],1);
        bd.adicionarPessoa(nomes[2],2);
        bd.adicionarPessoa(nomes[3],3);
        bd.adicionarPessoa(nomes[4],4);

        bd.acessarLista();

        try {
            arquivos.criarArquivo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
