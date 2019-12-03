public class WriteCompressed{
    private Mapping map = new Mapping();

    public WriteCompressed(Node[] uniqueArr, Node root, int[][] pixelArr){
        map.createPath(root, 0);

        int row = pixelArr.length;
        int column = pixelArr[0].length;

        //sort uniqueArr through key 

        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                //search pixelArr[i][j] at sorted uniqueArr
                //write matching uniqueArr.getBitString();
            }
        }
    }
}