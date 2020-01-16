import java.io.*;
import java.util.Scanner;
import java.awt.image.*;

public class Tester{
    private Compressor compressor = new Compressor();
    private Decompressor decompressor = new Decompressor();
    private String fileName = "RAY.BMP";
	private File file;
    private Node root = new Node();
    private Scanner scan = new Scanner(System.in);
    private BufferedImage bufferedImage = null;

    public Tester(){
        //START COMPRESS
        System.out.println("\n----------START COMPRESSION----------\n");

        file = new File(fileName);
        root = compressor.compress(file);

        System.out.println("FILE: " + fileName);

        //START DECOMPRESS
        System.out.println("\n----------START DECOMPRESSION----------\n");

        bufferedImage = decompressor.decompress("COMPRESSED.data", root);
    }
    
    public static void main(String [] args){
        new Tester();
    }
}