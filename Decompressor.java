import java.io.*;
import java.awt.image.*;

public class Decompressor{
    // private DeserializeTree deserialize;
    private ReadDimensions readDimensions = new ReadDimensions();
    private RecreateImage recreateImage;
    private File file;
    private FileInputStream fileInputStream;
    private BufferedImage bufferedImage = null;

    public BufferedImage decompress(String fileName, Node root){
        //int row=0, col=0;
        int[] dimension = new int[2];
        file = new File(fileName);
        try{
            fileInputStream = new FileInputStream(file);
            byte[] fileContent = new byte[(int)file.length()];
            fileInputStream.read(fileContent);
            System.out.println("All Contents Read");

            dimension = readDimensions.read(fileContent);
            System.out.println("Assigned values for dimensions");

            recreateImage = new RecreateImage(dimension[0], dimension[1]);
            bufferedImage = recreateImage.recreate(root, fileContent);
            System.out.println("Image Recreated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error while closing stream: " + ioe);
            }
        }

        System.out.println("ROW: " + dimension[0] + " \tCOLUMN: " + dimension[1]);
        System.out.println("TOTAL BYTES READ: " + (int)file.length());
        System.out.println("Decompression Complete");

        return bufferedImage;
    }
}