public class PriorityQueue{
	private LinkList list = new LinkList();

	public PriorityQueue(Node[] nodes){
		for(int i = nodes.length-1; i >= 0; i--){
			list.createLink(nodes[i]);
		}
	}

	public void enqueue(Node node){
		list.insert(node);
	}

	public Node dequeue(){
		if(list.seeTop() != null){
			return list.getTop().getNode();
		}
		return null;
	}

	public boolean isLastOne(){
		try{
			if(list.seeTop().getNext() == null){
				return true;
			}
			return false;
		}catch(NullPointerException ex){
			return false;
		}
	}
}