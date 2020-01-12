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

        //convert byte array to string
        
        Node node = root;
        String str = "";
        int strTracker = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                while((node.getLeft() != null) && (node.getRight() != null)){
                    if(str.charAt(strTracker) == 1){
                        node = node.getLeft();
                    }
                    else if(str.charAt(strTracker) == 0){
                        node = node.getRight();
                    }
                    strTracker++;
                }
                image.setRGB(i, j, node.getKey());
            }
        }
    }
}