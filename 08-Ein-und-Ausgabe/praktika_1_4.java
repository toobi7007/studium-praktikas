import java.io.*;
import java.nio.file.*;

public class praktika_1_4 {
    public static void main(String[] args) throws IOException {
	copyFile("/home/akex/testf", "/home/akex/prog/studium-praktika");
	if(

	String dir = "Kopie";
	Path dirPath = Paths.get(dir);
	
	if(!Files.exists(dirPath)) {
	    Files.createDirectory(dirPath);
	    System.out.println("Verzeichnis noch nicht da, wurde nicht erstellt!");
	} else {
	    System.out.println("Verzeichnis bereits vorhanden!");
	}

	moveFile("/home/akex/testff", dir + "/kopie_testff");
    }

    public static void copyFile(String source, String target) throws IOException {
	Path sourcePath = Paths.get(source);
	Path targetPath = Paths.get(target);

	Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

	if(Files.exists(targetPath)) {
	    System.out.println("Jo ist da");
	}
    }

    public static void moveFile(String source, String target) throws IOException {
	Path sourcePath = Paths.get(source);
	Path targetPath = Paths.get(target);
	for (; i < N; i++) {
	    
	}
	Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

	if(Files.exists(targetPath)) {
	    System.out.println("Jo ist da");
	}
    }
}
