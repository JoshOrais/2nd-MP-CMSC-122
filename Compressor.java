import java.io.*;

public class Compressor{
    private ImgScanner imgScan = new ImgScanner();
    private HuffmanTree tree = new HuffmanTree();
    private WriteCompressed write = new WriteCompressed();

    public Node compress(File file){    	
        Node[] uniqueArr = imgScan.scan(file);
        int[][] pixelsArr = imgScan.getPixels();

        Node root = tree.generate(uniqueArr);

        //write.write(uniqueArr, root, pixelsArr);

        return root;
    }
}