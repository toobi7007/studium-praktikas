import java.io.*;
// ACHTUNG: Unbedingt throws IOExeption it hinzufügen!
// und java.io.* importieren
public class praktika_1_1 {
    private static void aufgabe_2(RandomAccessFile flie) {
	System.out.println("hey aus funktion nr. 3");
    }
    public static void main(String[] args) throws IOException{
        RandomAccessFile file1 = new RandomAccessFile("data/datei1", "rw");
	System.out.println(file1.getFilePointer());
	// |---> Anzeigen der aktuellen Pointer Position in der geöffneten Datei

	file1.seek(5);
	System.out.println(file1.getFilePointer());
	// |---> Ändert die Position des Pointers in der Datei

	System.out.println(file1.length());
	// |---> Gbt die Länger der Datei in Bytes aus

	file1.setLength(500);


	file1.seek(0);
	System.out.println(file1.readLine());
		
	// Aufgabe 1:
	try {
	switch(args[0]) {
	case "1":
	    file1.seek(0);
	    for(int x = 1; x <= 100; x++) {
		file1.writeInt(x*x);
	    }

	    file1.seek(0);
	    for(int x = 0; x <= 100; x++) {
		System.out.println(file1.readInt());
	    }
	    break;
	case "2":
	    aufgabe_2(file1);
	    break;
	}
	} catch(Exception e){
	    e.printStackTrace();
	} finally {
	    file1.close();
	}
    }
}
