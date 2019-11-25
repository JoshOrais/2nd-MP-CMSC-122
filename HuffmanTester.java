public class HuffmanTester{
    private HuffmanTree tree = new HuffmanTree();

    private Node node1 = new Node();
    private Node node2 = new Node();
    private Node node3 = new Node();
    private Node node4 = new Node();
    private Node node5 = new Node();

    public HuffmanTester(){
        node1.setKey(1);
        node1.setValue(1);
        node2.setKey(2);
        node2.setValue(1);
        node3.setKey(3);
        node3.setValue(3);
        node4.setKey(4);
        node4.setValue(4);
        node5.setKey(5);
        node5.setValue(7);

        Node[] arr = new Node[5];
        arr[0] = node1;
        arr[1] = node2;
        arr[2] = node3;
        arr[3] = node4;
        arr[4] = node5;

        Node node = tree.generate(arr);

        System.out.println("Value: " + node.getValue() + " Left: " + node.getLeft().getValue() + " Right: " + node.getRight().getValue());
        System.out.println("Key: " + node.getKey() + " Left: " + node.getLeft().getKey() + " Right: " + node.getRight().getKey());
    }

    public static void main(String [] args){
        new HuffmanTester();
    }
}