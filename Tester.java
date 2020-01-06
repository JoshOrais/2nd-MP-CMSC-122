import java.io.*;

public class Tester{
    private Compressor compressor = new Compressor();
    private String fileName = "5.png";
	private File file;
    private Node root = new Node();

    public Tester(){
        file = new File(fileName);
        root = compressor.compress(file);

        //PRINT PREORDER
        //System.out.println("PRE-ORDER TRAVESAL: ");
        //printPreorder(root);

        //READ FILENAME AND CHECK TOTAL VALUE
        System.out.println("FILE: " + fileName);
        //System.out.println("TOTAL VALUE: " + root.getValue() + " LEFT: " + root.getLeft().getValue() + " RIGHT: " + root.getRight().getValue());
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