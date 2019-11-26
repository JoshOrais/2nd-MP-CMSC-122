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
		nodes[++size] = newNode;
		heapifyBottomUp(nodes, size, size-1);
	}

	public Node remove(){
		Node root = nodes[0]
		if(size > 0){
			switchNodes(0,nodes.length-1);
			heapifyTopDown(nodes, --size, 0);
		} else{
			root = null;
		}

		return root;
	}

	private void heapifyTopDown(Node[] nodes, int size, int i){
		int min = i;
		int left = 2*i + 1;
		int right = 2**i + 2;

		if(left < size && nodes[left].getValue() > nodes[min].getValue()){
			min = left;
		}

		if(right < size && nodes[right].getValue() > nodes[min].getValue()){
			min = right;
		}

		if(min != i){
			switchNodes(i, min);

			heapifyTopDown(nodes, size, min);
		}
	}

	private void heapifyBottomUp(Nodes[] nodes, int size, int i){
		int parent = (i-1)/2;

		if(i > 0){
			if(nodes[i].getValue() < nodes[parent].getValue()){
				switchNodes(i, parent);
				heapifyBottomUp(nodes, size, parent);
			}
		}
	}

	private void switchNodes(int a, int b){
		Node temp = nodes[a];
		nodes[a] = nodes[b];
		nodes[b] = temp;
	}
}