import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ScanTester{
    private File file;
    private BufferedImage img = null;

    public ScanTester(){
        try{
            file = new File("2.jpg");
            img = ImageIO.read(file);
        }
        catch(IOException e){
            System.out.println(e);
        }

        int width = img.getWidth();
        int height = img.getHeight();
        long cntr=0;

        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                System.out.println(img.getRGB(i,j));
                cntr++;
            }
        }
        System.out.println("Total: " + cntr);
    }

    public static void main(String [] args){
        new ScanTester();
    }
}