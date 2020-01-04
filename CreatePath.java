import java.util.*;

public class CreatePath{
    private String path = "";
    private ArrayList<Node> pathList = new ArrayList<Node>();
    private int cntr = 0;
    private int leftCntr = 0;
    private int rightCntr = 0;

    public void create(Node node){
        //System.out.println(node.getValue());

        if((node.getLeft() == null) || (node.getRight() == null)){
            node.setPath(path);
            pathList.add(node);
            cntr++;
            //System.out.println("end");
            return;
        }

        if(node.getLeft() != null){
            path = path + "1";
            leftCntr++;
            //System.out.println("left");
            create(node.getLeft());
        }
        if(node.getRight() != null){
            path = path + "0";
            rightCntr++;
            //System.out.println("right");
            create(node.getRight());
        }
    }

    public Node[] getPathArray(){
        System.out.println("\nCounter: " + cntr + " Left: " + leftCntr + " Right: " + rightCntr);
        Node[] pathArr = pathList.toArray(new Node[pathList.size()]);
        return pathArr; 
    }
}