import java.io.*;

public class Tester{
    private Compressor compressor = new Compressor();
    private String fileName = "sample.png";
	private File file;
    private Node node = new Node();

    public Tester(){
        file = new File(fileName);
        node = compressor.compress(file);

        //PRINT PREORDER
        System.out.println("PRE-ORDER TRAVESAL: ");
        printPreorder(node);

        //READ FILENAME AND CHECK TOTAL VALUE
        System.out.println("\n\nFILE: " + fileName);
        System.out.println("TOTAL VALUE: " + node.getValue() + " LEFT: " + node.getLeft().getValue() + " RIGHT: " + node.getRight().getValue());
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