public class Mapping{
    public void writeTree(Node root, long num){
        if(root.getLeft() == null && root.getRight() == null){
            root.getKey();
            //get binary representation of long
            //write key and long
        }

        Node(root.getLeft(), num<<1);
        Node(root.getRight(), (num<<1)|1);        
    }

    public void writeCompressed(int[][] pixels){
        int row = pixels.length();
        int column = pixels[0].length();

        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                //search key at tree file
                //write binary representation
            }
        }
    }
}