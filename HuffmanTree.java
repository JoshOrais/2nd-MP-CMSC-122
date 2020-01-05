public class HuffmanTree{
    private PriorityQueue queue;

    public Node generate(Node[] uniqueArr){
        queue = new PriorityQueue(uniqueArr);
        
        while(queue.isLastOne() == false){
            Node left = queue.dequeue();
            Node right = queue.dequeue();

            if (left.leaf == 0){
                left.setLeft(null);
                left.setRight(null);
            }
            if (right.leaf == 0){
                right.setLeft(null);
                right.setRight(null);
            }

            Node current = combine(left, right);
            current.leaf = 1;
            queue.enqueue(current); 
        }

        return queue.dequeue();
    }

    private Node combine(Node left, Node right){
        Node current = new Node();
        current.setValue(left.getValue() + right.getValue());
        current.setLeft(left);
        current.setRight(right);

        return current;
    }
}