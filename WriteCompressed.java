public class WriteCompressed{
    private Mapping map = new Mapping();

    public WriteCompressed(Node[] uniqueArr, Node root, int[][] pixelArr){
        map.createPath(root, 0);

        int row = pixelArr.length;
        int column = pixelArr[0].length;
    }
}