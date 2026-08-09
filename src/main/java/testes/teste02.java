package testes;

import Servidor.ServerOn;

import java.lang.ref.Cleaner;

public class teste02 {
    public static void main(String[] args) {
        ServerOn server = new ServerOn(true);
        server.rodarServidor("");
    }
}
