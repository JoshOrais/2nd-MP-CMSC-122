import java.util.*;

public class Node
{
	private int key;
	private int value;
	private Node right = null;
	private Node left = null;
	private String path;
	public int leaf = 0;


	public int getKey(){
		return key;
	}

	public void setKey(int key){
		this.key = key;
	}

	public int getValue(){
		return value;
	}

	public void setValue(int value){
		this.value = value;
	}

	public Node getRight(){
		return right;
	}

	public void setRight(Node right){
		this.right = right;
	}

	public Node getLeft(){
		return left;
	}

	public void setLeft(Node left){
		this.left = left;
	}

	public String getPath(){
		return path;
	}

	public void setPath(String path){
		this.path = path;
	}

	public ArrayList<Node> inOrder(ArrayList<Node> nodes){
		if(left != null){
			nodes = left.inOrder(nodes);
		}

		nodes = addToList(nodes, this);

		if(right != null){
			nodes = right.inOrder(nodes);
		}

		return nodes;
	}

	public void insert(int key){
		if(key == this.key){
			this.value++;
		}
		else if(key < this.key){
			if(left == null){
				left = new Node();
				left.setKey(key);
				left.setValue(1);
			}
			else{
				left.insert(key);
			}
		}
		else{
			if(right == null){
				right = new Node();
				right.setKey(key);
				right.setValue(1);
			}
			else{
				right.insert(key);
			}
		}
	}

	public ArrayList<Node> addToList(ArrayList<Node> list, Node nodes){
		list.add(nodes);
		return list;
	}
}