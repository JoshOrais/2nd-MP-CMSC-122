public class LinkList
{
	private Link first;

	public void createLink(Node node){
		Link newLink = first;
		first = new Link(node, newLink);
	}

	public Link seeTop(){
		return first;
	}

	public Link getTop(){
		if(first != null){
			Link top = first;
			first = first.getNext();
			return top;
		}else{
			return null;
		}
	}

	public void insert(Node node){
		if(first == null || node.getValue() < first.getNode().getValue()){
			createLink(node);
		}else{
			first.insert(node);
		}
	}
}