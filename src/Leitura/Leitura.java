package Leitura;
import Escrita.Registro;
import java.util.ArrayList;
import java.util.Random;

public class Leitura {
    private static String fileName = "registros";
    
    @SuppressWarnings("empty-statement")
    public static void main(String args) { 
        Registro reg = new Registro();
        Random rand = new Random();
        System.out.println("TESTE DE LEITURA: ");
        for (int i = 0; i < 3; i++) {
            System.out.println(reg.quantidadeRegistros());
            int nseqASerLido = rand.nextInt(reg.quantidadeRegistros() + 1);
            reg.leRegistro(nseqASerLido);
            System.out.println("Nseq Esperado: " + nseqASerLido);
            System.out.println("Registro Lido:");
            System.out.println(reg);
            System.out.println("-----");
        }
        
        System.out.println("---------------------------------------------------"
                         + "---------------------------------------------------");
        System.out.println("---------------------------------------------------"
                         + "---------------------------------------------------");
        
        System.out.println("UPDATE DE REGISTRO: ");
        for (int i = 0; i < 3; i++) {
            int nseqASerModificado = rand.nextInt(reg.quantidadeRegistros());
            reg.leRegistro(nseqASerModificado);
            System.out.println("Registro antes da modificacao: ");
            System.out.println(reg);
            reg = new Registro(nseqASerModificado);
            System.out.println("");
            System.out.println("Registro apos modificacao:");
            System.out.println(reg);
            System.out.println("-----");
        }
        
        System.out.println("---------------------------------------------------"
                         + "---------------------------------------------------");
        System.out.println("---------------------------------------------------"
                         + "---------------------------------------------------");
        
        System.out.println("EXPERIMENTO LEITURA SEQUENCIAL E ALEATORIA: ");
        ArrayList<Integer> quantidadesRegistros = new ArrayList<>();
        quantidadesRegistros.add(1000);
        quantidadesRegistros.add(10000);
        quantidadesRegistros.add(1000000);
        
        for (Integer quantidade : quantidadesRegistros){
            long tempoAleatorio = reg.tempoLeituraAleatoriaMilisegundos(quantidade);
            long tempoSequencial = reg.tempoLeituraSequencialMilisegundos(quantidade);

            System.out.println("Quantidade de registros: " + quantidade);
            System.out.println("Tempo gasto para leitura aleatória: " + tempoAleatorio + " ms");
            System.out.println("Tempo gasto para leitura sequencial: " + tempoSequencial + " ms");
            System.out.println();
        }
    }
}
