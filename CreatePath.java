import java.util.ArrayList;
import java.util.List;

public class CreatePath{
    private String path = "";
    private List<Node> pathList = new ArrayList<>();

    public void create(Node node){
        if(node.getLeft() == null || node.getRight() == null){
            node.setPath(path);
            pathList.add(node);
        }

        if(node.getLeft() != null){
            path = path + "1";
            create(node.getLeft());
        }
        if(node.getRight() != null){
            path = path + "0";
            create(node.getRight());
        }
    }

    public Node[] getPathArray(){
        Node[] pathArr = pathList.toArray(new Node[pathList.size()]);
        return pathArr; 
    }
}