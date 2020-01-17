import java.io.File;
import java.io.FileOutputStream;

public class DataWriter{
    private CreatePath path = new CreatePath();
    private MergeSort sort = new MergeSort();
    private BinarySearch search = new BinarySearch();
    private String extra = "";
    private File file;
    private FileOutputStream fileOutputStream;
    private int writeCounter = 0;

    public DataWriter(){
        try {
			file = new File("COMPRESSED.data");
            file.delete();
		} catch (Exception e) {
			e.printStackTrace();
        }
    }

    public void writer(Node[] uniqueArr, int[][] pixelArr, Node root){
        int row = pixelArr.length;
        int col = pixelArr[0].length;
        
        try {
			file = new File("COMPRESSED.data");
			fileOutputStream = new FileOutputStream(file, true);
			if (!file.exists()) {
				file.createNewFile();
            }

            //CHECK ROW BITSTRING
            System.out.print("ROW:\n");
            for(int i=3; i>=0; i--){
                fileOutputStream.write((byte)(row >>> (8*i)));

                String s1 = String.format("%8s", Integer.toBinaryString(((byte)(row >>> (8*i))) & 0xFF)).replace(' ', '0');
                System.out.println(s1);
            }
            //CHECK COLUMN BITSTRING
            System.out.print("COLUMN:\n");
            for(int i=3; i>=0; i--){
                fileOutputStream.write((byte)(col >>> (8*i)));
                String s1 = String.format("%8s", Integer.toBinaryString(((byte)(col >>> (8*i))) & 0xFF)).replace(' ', '0');
                System.out.println(s1);
            }
            System.out.print("\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        //CHECK IF FILE IS CREATED
        System.out.println("Dimensions Written");

        path.create(root, 0, "");
        Node[] pathArr = sort.mergeSort(path.getPathArray(), "pixel");

        //CHECK IF PATH ARRAY IS CREATED
        System.out.println("Path Array Created");
        
        //READ FOR CHECKING
        System.out.println("ROW: " + pixelArr.length + " \t\tCOLUMN: " + pixelArr[0].length);
        System.out.println("UNIQUE NODES: " + uniqueArr.length + " \tNO.OF PATHS: " + pathArr.length);

        //READ CONTENTS OF PATH ARRAY
        // for(int i=0; i<pathArr.length; i++){
        //    System.out.println("Path: " + pathArr[i].getPath() + " \tNumber of pixels: " + pathArr[i].getValue() + " \tPixel Value: " + pathArr[i].getKey());
        // }

        System.out.println("\nCONTENT:");
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                //CHECK UPDATES
                //System.out.println("check \t" + i + " \t" + j);
                String pathString = search.binSearch(pixelArr[i][j], pathArr);                
                pathString = extra.concat(pathString);

                //System.out.println(pathString);

                while(pathString.length()  >= 8){
                    //CHECK UPDATES
                    //System.out.println("\tprocessing substring");
                    WriteToFile(pathString.substring(0, 8));
                    if(pathString.length() > 8){
                        pathString = pathString.substring(8, (pathString.length()));
                    }
                    if(pathString.length() == 8){
                        pathString = "";
                    }
                }
                extra = pathString;
            }
        }

        //CHECK EXTRA
        //System.out.println("Extra: " + extra);
        if(extra.length() > 0){
            int k = 8-extra.length();
            for(int i=0; i<k; i++){
                extra = extra + "0";
            }
            WriteToFile(extra);
        }

        try {
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //CHECK IF DONE
        System.out.println("\nFile written successfully.");
        System.out.println("TOTAL BYTES WRITTEN: " + writeCounter);

        int totalBytes = (int)file.length();
        System.out.println("LENGTH OF FILE: " + totalBytes);
    }

    public void WriteToFile(String str){
        //CHECK BITSTRINGS
        //System.out.println(str);
        writeCounter++;

        //CHECK IMAGE BITSTRING
        System.out.println(str);

        int num = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1'){
                num = (num << 1) | 1;
            }
            else if(str.charAt(i) == '0'){
                num = num << 1;
            }
        }

        try{
            fileOutputStream.write((byte)(num & 0xff));
        } catch (Exception e) {
			e.printStackTrace();
		}
		
    }
    
}