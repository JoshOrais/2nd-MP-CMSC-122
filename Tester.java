import java.io.*;

public class Tester{
    private Compressor compressor = new Compressor();
    private String fileName = "sample.png";
	private File file;
    private Node node = new Node();

    public Tester(){
        file = new File(fileName);
        node = compressor.compress(file);

        System.out.println(fileName);
        System.out.println("Value: " + node.getValue() + " Left: " + node.getLeft().getValue() + " Right: " + node.getRight().getValue());
    }

    public static void main(String [] args){
        new Tester();
    }
}