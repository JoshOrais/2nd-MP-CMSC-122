public class Heap
{
	private Node[] nodes;
	private int size;

	public Heap(Node[] nodes){
		this.nodes = nodes;
		this.size = nodes.length;
	}

	public int getSize(){
		return size;
	}

	public void insert(Node newNode){
		nodes[++size-1] = newNode;
		heapifyBottomUp(size, size-1);
	}

	public Node remove(){
		Node root = nodes[0];
		if(size > 0){
			switchNodes(0,--size);
			heapifyTopDown(size, 0);
		} else{
			root = null;
		}

		return root;
	}

	private void heapifyTopDown(int size, int i){
		int min = i;
		int left = 2*i + 1;
		int right = 2*i + 2;

		if(left < size && nodes[left].getValue() < nodes[min].getValue()){
			min = left;
		}

		if(right < size && nodes[right].getValue() < nodes[min].getValue()){
			min = right;
		}

		if(min != i){
			switchNodes(i, min);

			heapifyTopDown(size, min);
		}
	}

	private void heapifyBottomUp(int size, int i){
		int parent = (i-1)/2;

		if(i > 0){
			if(nodes[i].getValue() < nodes[parent].getValue()){
				switchNodes(i, parent);
				heapifyBottomUp(size, parent);
			}
		}
	}

	private void switchNodes(int a, int b){
		Node temp = nodes[a];
		nodes[a] = nodes[b];
		nodes[b] = temp;
	}
}