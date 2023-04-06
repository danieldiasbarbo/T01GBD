package Escrita;

import Leitura.Leitura;

public class Escrita {
    private static String fileName = "registros";
    
    public static void main(String[] args) {
        Registro reg;
        int nReg = 1000;
        for (int i = 0; i <= nReg; i++) {
            reg = new Registro(i);
            reg.gravaRegistro();
        }
        Leitura.main("sim");
    }    
}
