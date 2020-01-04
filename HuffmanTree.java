public class HuffmanTree{
    private PriorityQueue queue;

    public Node generate(Node[] uniqueArr){
        queue = new PriorityQueue(uniqueArr);
        
        while(queue.isLastOne() == false){
            Node current = combine(queue.dequeue(), queue.dequeue());
            queue.enqueue(current); 
            //System.out.println(current.getLeft().getValue() + " " + current.getRight().getValue());
        }

        Node root = queue.dequeue();
        //System.out.println(root.getValue());
        
        System.out.println(root.getValue());
        System.out.println(root.getLeft().getValue());//leaf true

        System.out.println(root.getRight().getValue());
        System.out.println(root.getRight().getLeft().getValue());//leaf false
        System.out.println(root.getRight().getLeft().getLeft().getValue());

        System.out.println(root.getRight().getRight().getValue());
        System.out.println(root.getRight().getRight().getLeft().getValue());//leaf false
        System.out.println(root.getRight().getRight().getLeft().getLeft().getValue());
        System.out.println(root.getRight().getRight().getLeft().getLeft().getLeft().getValue());
        System.out.println(root.getRight().getRight().getLeft().getLeft().getLeft().getLeft().getValue());
        
        System.out.println(root.getRight().getRight().getRight().getValue());//leaf false
        System.out.println(root.getRight().getRight().getRight().getLeft().getValue());
        System.out.println(root.getRight().getRight().getRight().getLeft().getLeft().getValue());
        
        return root;

        //return queue.dequeue();
    }

    private Node combine(Node left, Node right){
        Node current = new Node();
        current.setValue(left.getValue() + right.getValue());
        current.setLeft(left);
        current.setRight(right);

        return current;
    }
}