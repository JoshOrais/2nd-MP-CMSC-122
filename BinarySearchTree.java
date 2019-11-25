import java.util.*;

public class BinarySearchTree
{
	private Node root;

	public ArrayList<Node> traverse(){
		ArrayList<Node> values = new ArrayList<Node>();
		return root.inOrder(values);
	}

	public void insert(int key){
		if(root == null){
			root = new Node();
			root.setKey(key);
			root.setValue(1);
		}
		else{
			root.insert(key);
		}
	}
}