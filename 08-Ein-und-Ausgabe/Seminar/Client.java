package Seminar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket server = new Socket("127.0.0.1", 2134);

        BufferedReader empfang = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter senden = new PrintWriter(server.getOutputStream());
        BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
        boolean beenden = true;
        while(beenden) {
            String zeile = tastatur.readLine();
            senden.println(zeile);
            senden.flush();
            System.out.println(empfang.readLine());
            if(zeile.equals("beenden")) {
                beenden = false;
            }
        }
        server.close();
    }
}
