public class Compressor{
    private ImgScanner imgScan = new ImgScanner();
    private HuffmanTree tree = new HuffmanTree();
    private Mapping map = new Mapping();

    public Node compress(File file){    	
        Node[] nodeArr = imgScan.scan(file);
        Node root = tree.generate(nodeArr);

        int[][] pixels = imgScan.getPixels();

        map.writeTree();
        map.writeCompressed();

        return root;
    }
}