public class Tester{
    private Compressor compressor = new Compressor();

    public Tester(){
        Node node = new Node();
        node = compressor.compress();

        System.out.println("Value: " + node.getValue() + " Left: " + node.getLeft().getValue() + " Right: " + node.getRight().getValue());
        System.out.println("Key: " + node.getKey() + " Left: " + node.getLeft().getKey() + " Right: " + node.getRight().getKey());
    }

    public static void main(String [] args){
        new Tester();
    }
}