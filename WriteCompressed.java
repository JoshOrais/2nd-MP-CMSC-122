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

    public void WriteData(Node[] uniqueArr, int[][] pixelArr, Node root){
        path.create(root);
        Node[] pathArr = sort.mergeSort(path.getPathArray());

        System.out.println("All pixels: " + (pixelArr.length * pixelArr[0].length));
        System.out.println("Unique nodes: " + uniqueArr.length);
        System.out.println("Paths: " + pathArr.length);

        int row = pixelArr.length;
        int col = pixelArr[0].length;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                String pathString = search.binSearch(pixelArr[i][j], pathArr);
                //byte bitString = Byte.parseByte(pathString);
            }
        }

    }
}