import java.io.*;

public class Decompressor{
    private File file;
    private FileInputStream fileInputStream;
    private DataInputStream dataInputStream;

    public void decompress(String fileName, Node root){
        int row=0, col=0;
        file = new File(fileName);
        try{
            fileInputStream = new FileInputStream(file);
            dataInputStream = new DataInputStream(fileInputStream);

            row = dataInputStream.readInt();
            col = dataInputStream.readInt();

            byte[] fileContent = new byte[(int)file.length()];
            fileInputStream.read(fileContent);

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            }
            catch (IOException ioe) {
                System.out.println("Error while closing stream: " + ioe);
            }
        }
        
        System.out.println("Row: " + row + " \tCol: " + col);
        System.out.println("Decompression Complete");
    }
}