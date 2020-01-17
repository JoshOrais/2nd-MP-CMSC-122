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

    public BufferedImage recreate(Node root, byte[] fileContent){
        Node node = root;
        int arrTracker = 0;
        int length = 8;
        String strChecker = "";

        System.out.print("\nCONTENT:\n");
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                //System.out.println("test 1");
                while((node.getLeft() != null) && (node.getRight() != null)){
                    //System.out.println("test 2");
                    if(length == 0){
                        System.out.println("check 1");
                        strChecker = "";
                        arrTracker++;
                        length = 8;
                    }
                    else if(length > 0){
                        System.out.println(length);
                        if(((fileContent[arrTracker] >> (length-1)) & 1) == 1){
                            strChecker  = strChecker + "1";
                            node = node.getLeft();
                            System.out.println("check 2");
                        }
                        else if(((fileContent[arrTracker] >> (length-1)) & 1) == 0){
                            strChecker  = strChecker + "0";
                            node = node.getRight();
                            System.out.println("check 3");
                        }
                        length--;
                    }
                }
                image.setRGB(i, j, node.getKey());
                //System.out.println("test");
            }
        }

        return image;
    }
}