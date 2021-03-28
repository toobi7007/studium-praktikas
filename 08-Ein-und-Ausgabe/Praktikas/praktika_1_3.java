package Praktikas;

import java.io.*;

public class praktika_1_3 {
    public static void main(String[] args) throws IOException {
	String dateiname = "data/aufg3";
	String[] arr = {"Hallo", "ich", "bin", "alex"};
	schreibeIn(dateiname, arr);
	System.out.println(liesAus(dateiname,Integer.parseInt(args[0])));
    }

    public static void schreibeIn(String dateiname, String[] strarr) throws IOException {
	RandomAccessFile w_dat = new RandomAccessFile(dateiname + ".dat", "rw");
	RandomAccessFile w_idx = new RandomAccessFile(dateiname + ".idx", "rw");
	try {
	    for( String x : strarr ) {
		w_idx.writeLong(w_dat.getFilePointer());
		w_dat.writeUTF(x);
	    }
	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    w_dat.close();
	    w_idx.close();
	}
    }

    public static String liesAus(String dateiname, int n) throws IOException {
	RandomAccessFile w_dat = new RandomAccessFile(dateiname + ".dat", "r");
	RandomAccessFile w_idx = new RandomAccessFile(dateiname + ".idx", "r");
	try {
	    w_idx.seek((n - 1) * 8);
	    long pointer = w_idx.readLong();

	    w_dat.seek(pointer);
	    return w_dat.readUTF();
	} catch(Exception e) {
	    e.printStackTrace();
	} finally {
	    w_dat.close();
	    w_idx.close();
	}

	
	return "hey";
    }
}
