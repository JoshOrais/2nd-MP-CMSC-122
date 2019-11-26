public class HuffmanTree{
    private PriorityQueue queue;

    public Node generate(Node[] uniqueArr){
        queue = new PriorityQueue(uniqueArr);
        
        while(queue.isLastOne() == false){
            Node current = combine(queue.dequeue(), queue.dequeue());
            queue.enqueue(current); 
        }

        return queue.dequeue();
    }

    private Node combine(Node a, Node b){
        Node node = new Node();
        node.setValue(a.getValue() + b.getValue());
        node.setLeft(a);
        node.setRight(b);

        return node;
    }
}