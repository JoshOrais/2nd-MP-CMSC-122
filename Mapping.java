public class Mapping{
    public void writeTree(Node root, long num){
        if(root.getLeft() == null && root.getRight() == null){
            root.getKey();
            //get binary representation of long
            //write key and long
        }

        writeTree(root.getLeft(), num<<1);
        writeTree(root.getRight(), (num<<1)|1);        
    }

    public void writeCompressed(int[][] pixels){
        int row = pixels.length();
        int column = pixels[0].length();

        //write binary representation of row and column
        //joshua dako otin

        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                //search key at tree file
                //write binary representation
            }
        }
    }

    private void writer(){

    }
}