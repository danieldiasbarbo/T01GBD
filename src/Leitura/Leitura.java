package Leitura;
import Escrita.Registro;

public class Leitura {
    private static String fileName = "registros.txt";
    
    public static void main(String[] args) {        
        Registro reg = new Registro();
            long tempo = reg.tempoLeituraSequencialMilisegundos(100);
            System.out.println("tempo: " + tempo + " ms");
    }
}
