import java.io.*;
import java.util.Scanner;

public class Tester{
    private Compressor compressor = new Compressor();
    private Decompressor decompressor = new Decompressor();
    private String fileName = "RAY.BMP";
	private File file;
    private Node root = new Node();
    private Scanner scan = new Scanner(System.in);

    public Tester(){
        //START COMPRESS
        System.out.print("START COMPRESSION ");
        scan.nextInt();

        file = new File(fileName);
        root = compressor.compress(file);

        //PRINT PREORDER
        //System.out.println("PRE-ORDER TRAVESAL: ");
        //printPreorder(root);

        System.out.println("FILE: " + fileName);

        //START DECOMPRESS
        System.out.print("\nSTART DECOMPRESSION ");
        scan.nextInt();

        decompressor.decompress("COMPRESSED.data", root);
    }

    public void printPreorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        System.out.print(node.getValue() + " "); 
        printPreorder(node.getLeft()); 
        printPreorder(node.getRight()); 
    }
    
    public static void main(String [] args){
        new Tester();
    }
}