package Escrita;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registro {

    public Integer nseq;
    public String content;
    public static String fileName = "registros.txt";

    public Registro() {
        this.nseq = 0;
        content = new String();
    }

    public Registro(Integer nseq) {
        this.nseq = nseq;
        this.content = geraConteudoAleatorio();
    }

    public Registro(Integer nseq, String content) {
        this.nseq = nseq;
        this.content = content;
    }

    public void gravaRegistro() {
        File file = new File(fileName);
        long tamanho = file.length();
        tamanho = tamanho / 100;
        Integer proxNseq = Long.valueOf(tamanho).intValue();
        this.nseq = proxNseq;

        try ( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            gravaInteiro(proxNseq);
            bufferedWriter.write(content);
            bufferedWriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizaRegistro() {
        try ( RandomAccessFile raf = new RandomAccessFile(new File(fileName), "rw");  FileOutputStream fos = new FileOutputStream(raf.getFD())) {
            raf.seek(nseq * 100 + 4);
            fos.write(content.getBytes());
            fos.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void leRegistro(Integer nseq) {

        //Ler o nseq salvo no registro
        long offset = 100 * nseq;
        try ( RandomAccessFile file = new RandomAccessFile(fileName, "r")) {
            file.seek(offset);
            this.nseq = file.readInt();
        } catch (IOException e) {
            System.out.println("erro ao ler registro");
        }

        //Ler o conteúdo salvo no registro
        offset += 4;
        try ( RandomAccessFile file = new RandomAccessFile(fileName, "r")) {
            file.seek(offset);
            byte[] buffer = new byte[96];
            file.read(buffer, 0, 96);
            this.content = new String(buffer);
        } catch (IOException e) {
            System.out.println("erro ao ler registro");
        }
    }

    private void gravaInteiro(Integer nseq) {
        try ( DataOutputStream output = new DataOutputStream(new FileOutputStream(fileName, true))) {
            output.writeInt(nseq);
            output.flush();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    private String geraConteudoAleatorio() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 96; i++) {
            char c = (char) (random.nextInt(94) + 32);
            sb.append(c);
        }
        return sb.toString();
    }
}