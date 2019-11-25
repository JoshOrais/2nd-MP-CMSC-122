public class Compressor{
    private ImgScanner imgScan;
    private HuffmanTree tree;

    public Node compress(File file){
    	imgScan = new ImgScanner();
    	tree = new HuffmanTree();
    	
        Node[] nodeArr = imgScan.scan(file);
        Node root = tree.generate(nodeArr);

        int[][] pixels = imgScan.getPixels();

        return root;
    }
}