package Escrita;

public class Escrita {
    private static String fileName = "registros.txt";
    
    public static void main(String[] args) {
        Registro reg;
        int nReg = 100000;
        for (int i = 0; i <= nReg; i++) {
            reg = new Registro(i);
            reg.gravaRegistro();
        }
    }    
}
