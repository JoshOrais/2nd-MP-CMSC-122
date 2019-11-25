public class HuffmanTree{
    private PriorityQueue queue;

    public Node generate(Node[] nodeArr){
        queue = new PriorityQueue(nodeArr);
        
        while(queue.isLastOne() == false){
            Node current = combine(queue.dequeue(), queue.dequeue());
            queue.enqueue(current); 
        }

        return queue.dequeue();
    }

    private Node combine(Node a, Node b){
        Node node = new Node();

        if(){
            node.setCombined(a.getKey(), b.getKey());
        }
        else{
            node.setCombined(a.getCombined(), b.getCombined());
        }

        node.setValue(a.getValue() + b.getValue());
        node.setLeft(a);
        node.setRight(b);

        return node;
    }
}