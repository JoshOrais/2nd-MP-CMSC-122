public class WriteCompressed{
    private CreatePath path = new CreatePath();
    private Sorter sort = new Sorter();
    private BinarySearch search = new BinarySearch();

    public WriteCompressed(Node[] uniqueArr, Node root, int[][] pixelArr){
        WriteTree(root);
        WriteData(uniqueArr, pixelArr, root);
    }

    public void WriteTree(Node root){
        //read tree breadth wise
        //write in text file
    }

    public void WriteData(int[][] pixelArr, Node root){
        path.create(root);
        Node[] pathArr = sort.mergeSort(path.getPathArray());

        int row = pathArr.length;
        int col = pathArr[0].length;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                String pathString = search.binSearch(pathArr[i][j]);
            }
        }

    }
}