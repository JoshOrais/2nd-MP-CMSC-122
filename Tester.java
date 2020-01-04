import java.io.*;

public class Tester{
    private Compressor compressor = new Compressor();
    private String fileName = "sample.png";
	private File file;
    private Node node = new Node();

    public Tester(){
        file = new File(fileName);
        node = compressor.compress(file);
        printPreorder(node);

        System.out.println("\n" + fileName);
        System.out.println("Value: " + node.getValue() + " Left: " + node.getLeft().getValue() + " Right: " + node.getRight().getValue());
    }

    public void printPreorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        /* first print data of node */
        System.out.print(node.getValue() + " "); 
  
        /* then recur on left sutree */
        printPreorder(node.getLeft()); 
  
        /* now recur on right subtree */
        printPreorder(node.getRight()); 
    }
    
    public static void main(String [] args){
        new Tester();
    }
}