import java.util.*;

public class CreatePath{
    private String path = "";
    private ArrayList<Node> pathList = new ArrayList<Node>();
    private int flag;

    public void create(Node node){
        //System.out.println("\nStart Value: " + node.getValue());

        if((node.getLeft() == null) || (node.getRight() == null)){
            node.setPath(path);
            pathList.add(node);

            if(flag == 1){
                if(path.length() < 2){
                    path = "";
                    //System.out.println("reset");
                }
                else{
                    path = path.substring(0, path.length()-1);
                }
            }
            if(flag == 0){
                if(path.length() < 3){
                    path = "";
                    //System.out.println("reset");
                }
                path = path.substring(0, path.length()-2);
            }
            //System.out.println("end\n");
            return;
        }

        if(node.getLeft() != null){
            flag = 1;
            path = path + "1";
            //System.out.println("left");
            //System.out.println("bitString: " + path);
            create(node.getLeft());
        }
        if(node.getRight() != null){
            flag = 2;
            path = path + "0";
            //System.out.println("right");
            //System.out.println("bitString: " + path);
            create(node.getRight());
        }
    }

    public Node[] getPathArray(){
        //System.out.println("\nCounter: " + cntr + " Left: " + leftCntr + " Right: " + rightCntr);
        Node[] pathArr = pathList.toArray(new Node[pathList.size()]);

        return pathArr; 
    }
}