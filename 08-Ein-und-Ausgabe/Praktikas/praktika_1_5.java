package Praktikas;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class praktika_1_5 {
    public static void main(String[] args) {
        try {
            System.out.println(dump("praktika_1_5.java"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String dump(String filename) throws IOException {
        final int BREITE = 16;
        String dumb = "";
        String hexline = "";
        String txtline = "";
        Path pfad = Paths.get(filename);

        InputStream in = Files.newInputStream(pfad, StandardOpenOption.READ);

        int b = in.read();
        int i = 1;

        while(b != -1) {
            if(b <= 15) {
                hexline = hexline + "o";

            }
        }

        System.out.println("heyho");
        return "yo";
    }
}
