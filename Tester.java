import java.io.*;

public class Tester{
    private Compressor compressor = new Compressor();
    private String fileName = "2.jpg", line;
	private File file;
    private Node node = new Node();

    public Tester(){
        file = new File(fileName);
        node = compressor.compress(file);

        System.out.println("Value: " + node.getValue() + " Left: " + node.getLeft().getValue() + " Right: " + node.getRight().getValue());
        System.out.println("Key: " + node.getKey() + " Left: " + node.getLeft().getKey() + " Right: " + node.getRight().getKey());
    }

    public static void main(String [] args){
        new Tester();
    }
}