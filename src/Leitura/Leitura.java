package Leitura;
import Escrita.Registro;

public class Leitura {
    private static String fileName = "registros.txt";
    
    public static void main(String[] args) {        
        Registro reg = new Registro();
        for (int i = 100; i < 103; i++) {
            reg.leRegistro(i);
            System.out.println("Registro: " + reg.nseq);
            System.out.println(reg.content);
        }
    }
}
