import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.*;

public class ImgScanner{
    private BufferedImage img = null;
    private ArrayList<Node> nodeList;

    private BinarySearchTree tree;
    private Sorter sort;

    private int height, width;
    private int[][] pixel;

    public Node[] scan(File file){
        tree = new BinarySearchTree();
        nodeList = new ArrayList<>();
        sort = new Sorter();
        
        try{
            img = ImageIO.read(file);
        }
        catch(IOException e){
            System.out.println(e);
        }

        width = img.getWidth();
        height = img.getHeight();
        pixel = new int[width][height];

        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                int color = img.getRGB(i,j);
                pixel[i][j] = color;
                tree.insert(color);
            }
        }

        nodeList = tree.traverse();
        Node[] nodeArr = nodeList.toArray(new Node[nodeList.size()]);
        return sort.mergeSort(nodeArr);
    }

    public int[][] getPixels(){
        return pixel;
    }
}