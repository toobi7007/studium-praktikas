package Seminar;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SeqDateiarbeit {
    public static void main(String[] args) throws IOException{
        schreiben();
        lesen();

        schreibenGP();
        lesenGP();
    }

    private static void lesenGP() {
        BufferedReader i = null;
        try{
            i = Files.newBufferedReader(
                    Paths.get("datei2.dat"),
                    StandardCharsets.UTF_8
            );

            String zeile = null; // Ende wird als nulll dargestellt

            while((zeile = i.readLine()) != null) {
                System.out.println(zeile);
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(i != null) {
                try {
                    i.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void schreibenGP() {
        BufferedWriter o = null;
        try {
            o = new BufferedWriter(
                    new FileWriter("datei2.dat")
            );

            o.write("Geiler Text 2.0 yeah");
            o.newLine();
            o.write("zweite Zeile");
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(o != null) {
                try {
                    o.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void lesen() {
        InputStream i = null;
        try {
            i = Files.newInputStream(Paths.get("datei.dat"), StandardOpenOption.READ);
            int b = i.read(); // Wenn fertig: -1
            while(b != -1) {
                System.out.print((char)b);
                b = i.read();
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(i != null) {
                try {
                    i.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void schreiben() throws IOException{
        OutputStream o = null;
        try {
            o = new FileOutputStream("datei.dat");
            String txt = "Der Text ist super.";
            for(char x : txt.toCharArray()) {
                o.write(x);
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(o != null) {
                try {
                    o.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
