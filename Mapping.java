public class Mapping{
    public void createPath(Node node, long num){
        if(node.getLeft() == null && node.getRight() == null){
            node.setBitString(long);
        }
        else{
            writeTree(node.getLeft(), num<<1);
            writeTree(node.getRight(), (num<<1)|1); 
        }    
    }
}