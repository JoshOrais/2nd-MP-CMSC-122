public class WriteCompressed{
    private CreatePath path = new CreatePath();
    private MergeSort sort = new MergeSort();
    private BinarySearch search = new BinarySearch();
    private String extra = "";

    public void write(Node[] uniqueArr, Node root, int[][] pixelArr){
        WriteTree(root);
        WriteData(uniqueArr, pixelArr, root);
    }

    public void WriteTree(Node root){
        //read tree breadth wise
        //write in text file
    }

    public void WriteData(Node[] uniqueArr, int[][] pixelArr, Node root){
        path.create(root);
        Node[] pathArr = sort.mergeSort(path.getPathArray(), "pixel");
        
        //READ CONTENTS OF PATH ARRAY
        /*for(int i=0; i<pathArr.length; i++){
            System.out.println("Path: " + pathArr[i].getPath() + " \tValue: " + pathArr[i].getValue() + " \tPixel: " + pathArr[i].getKey());
        }*/

        //READ FOR CHECKING
        System.out.println("ROW: " + pixelArr.length + " \tCOLUMN: " + pixelArr[0].length);
        System.out.println("UNIQUE NODES: " + uniqueArr.length + " \tNO.OF PATHS: " + pathArr.length + "\n");

        int row = pixelArr.length;
        int col = pixelArr[0].length;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                String pathString = search.binSearch(pixelArr[i][j], pathArr);
                //READ PATH FOUND
                //System.out.println("pixel: " + pixelArr[i][j] + " \tString: " + pathString);
                pathString = extra.concat(pathString);
                //READ PATHSTRING
                //System.out.println("Combined: " + pathString + "\tLength: " + pathString.length());

                while(pathString.length()  >= 8){
                    WriteToFile(pathString.substring(0, 8));
                    if(pathString.length() > 8){
                        pathString = pathString.substring(8, (pathString.length()));
                    }
                    if(pathString.length() == 8){
                        pathString = "";
                    }
                }
                extra = pathString;
            }
        }
        WriteToFile(extra);
    }

    public void WriteToFile(String str){
        //CHECK BITSTRINGS
        //System.out.println(str);
        //byte bitString = Byte.parseByte(str); 
    }
}