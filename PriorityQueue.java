public class PriorityQueue{
	private Heap heap;

	public PriorityQueue(Node[] nodes){
		heap = new Heap(nodes);
	}

	public void enqueue(Node node){
		heap.insert(node);
	}

	public Node dequeue(){
		return heap.remove();
	}

	public boolean isLastOne(){
		if(heap.getSize() == 1){
			return true;
		}
		return false;
	}
}