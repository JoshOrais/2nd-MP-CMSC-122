public class Link
{
	private Node node;
	private Link next;

	public Link(Node node, Link next){
		this.node = node;
		this.next = next;
	}

	public void setNext(Link next){
		this.next = next;
	}

	public void setNode(Node node){
		this.node = node;
	}

	public Node getNode(){
		return node;
	}

	public Link getNext(){
		return next;
	}

	public void insert(Node node){
		if(next == null || node.getValue() < next.getNode().getValue()){
			Link newLink = new Link(node, next);
			next = newLink;
		}else{
			next.insert(node);
		}
	}
}