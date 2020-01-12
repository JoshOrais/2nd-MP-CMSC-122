import java.awt.image.*;

public class RecreateImage{
    private int row=0;
    private int col=0;
    private BufferedImage image;

    public RecreateImage(int x, int y){
        row = x;
        col = y;
        image = new BufferedImage(row, col, BufferedImage.TYPE_INT_ARGB);
    }

    public void recreate(Node root, byte[] byteArr){
        //image.setRGB(int x, int y, int rgb);
    }
}