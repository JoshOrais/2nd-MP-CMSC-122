import java.util.*;

public class CreatePathSample{
    private ArrayList<Node> pathList = new ArrayList<Node>();

    public void create(Node node, int flag, String path){
        if (node == null){
            return;
        }
        
        if (node.getLeft() == null || node.getRight() == null){
            node.setPath(path);
            pathList.add(node);

            // if(flag == 1){
            //     if(path.length() < 2){
            //         path = "";
            //     }
            //     else{
            //         path = path.substring(0, path.length()-1);
            //     }
            // }
            // else if(flag == 0){
            //     if(path.length() < 3){
            //         path = "";
            //     }
            //     else{
            //         path = path.substring(0, path.length()-2);
            //     }
            // }
        }
  
        create(node.getLeft(), 1, path+"1");
        create(node.getRight(), 0, path+"0"); 
    }

    public Node[] getPathArray(){
        Node[] pathArr = pathList.toArray(new Node[pathList.size()]);
        return pathArr; 
    }
}