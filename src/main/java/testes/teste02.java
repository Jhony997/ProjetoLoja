package testes;

import Servidor.ServerOn;

import java.io.IOException;
import java.lang.ref.Cleaner;

public class teste02 {
    public static void main(String[] args) throws IOException {
        ServerOn server = new ServerOn(true);
        server.rodarServidor("");
    }
}
