import java.io.*;

public class Tester{
    private Compressor compressor = new Compressor();
    private Decompressor decompressor = new Decompressor();
    private String fileName = "RAY.BMP";
	private File file;
    private Node root = new Node();

    public Tester(){
        file = new File(fileName);
        root = compressor.compress(file);

        //PRINT PREORDER
        //System.out.println("PRE-ORDER TRAVESAL: ");
        //printPreorder(root);

        System.out.println("FILE: " + fileName);

        decompressor.decompress(file, root);
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