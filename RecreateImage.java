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
        //image.setRGB(int x, int y, int rgb);

        //convert byte array to string
        
        // Node node = root;
        // String str = "";
        // int strTracker = 0;

        // for(int i=2; i<(fileContent.length); i++){
        //     //System.out.println("Converting \t" + i);
        //     str = str + (String.format("%8s", Integer.toBinaryString((fileContent[i]) & 0xFF)).replace(' ', '0'));
        // }
        // System.out.println("Done Creating String");

        // for(int i=0; i<row; i++){
        //     for(int j=0; j<col; j++){
        //         while((node.getLeft() != null) && (node.getRight() != null)){
        //             if(str.charAt(strTracker) == '1'){
        //                 node = node.getLeft();
        //             }
        //             else if(str.charAt(strTracker) == '0'){
        //                 node = node.getRight();
        //             }
        //             strTracker++;
        //         }
        //         image.setRGB(i, j, node.getKey());
        //     }
        // }

        Node node = root;
        int strTracker = 0;
        int length = 8;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                while((node.getLeft() != null) && (node.getRight() != null)){
                    if(length < 0){
                        if(((fileContent[strTracker] >> (length-1)) & 1) == 1){
                            node = node.getLeft();
                        }
                        else if(((fileContent[strTracker] >> (length-1)) & 1) == 0){
                            node = node.getRight();
                        }
                        length--;
                    }
                    else if(length == 0){
                        strTracker++;
                        length = 8;
                    }
                }
                image.setRGB(i, j, node.getKey());
            }
        }

        return image;
    }
}