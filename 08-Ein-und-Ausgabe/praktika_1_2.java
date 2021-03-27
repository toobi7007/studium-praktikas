import java.io.*;

public class praktika_1_2 {
    public static void main(String[] args) throws IOException {
	RandomAccessFile file = new RandomAccessFile("data/datei1", "r");

	System.out.println("Ausgabe der " + args[0] + ".  Zahl:");

	int arg = Integer.parseInt(args[0]);
	file.seek((arg-1) * 4);
	System.out.println(file.readInt());
    }
}
