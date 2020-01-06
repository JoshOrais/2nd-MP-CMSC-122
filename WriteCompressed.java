public class WriteCompressed{
    private TreeWriter treeWriter;
    private DataWriter dataWriter;

    public WriteCompressed(){
        treeWriter = new TreeWriter();
        dataWriter = new DataWriter();
    }

    public void write(Node[] uniqueArr, Node root, int[][] pixelArr){
        treeWriter.writer(root);
        dataWriter.writer(uniqueArr, pixelArr, root);
    }
}