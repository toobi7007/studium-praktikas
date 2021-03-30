package Seminar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(2134);
            boolean beenden = true;
            while(beenden) {
                // Wenn neue Verbindung -> neues socket erzeugt
                Socket client = server.accept();
                try  {
                    BufferedReader empfang =  new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter senden = new PrintWriter(client.getOutputStream());
                    String zeile = null;
                    while((zeile = empfang.readLine()) != null) {
                        if(zeile.equals("beenden")) {
                            beenden = false;
                        }
                        zeile = "Server sendet: " + zeile;
                        senden.println(zeile);
                        senden.flush();
                    }
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Server beendet");
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
