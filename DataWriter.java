import java.io.File;
import java.io.FileOutputStream;

public class DataWriter{
    private CreatePathSample path = new CreatePathSample();
    private MergeSort sort = new MergeSort();
    private BinarySearch search = new BinarySearch();
    private String extra = "";
    private File file;
    private FileOutputStream fileOutputStream;

    public DataWriter(){
        try {
			file = new File("COMPRESSED.data");
            file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void writer(Node[] uniqueArr, int[][] pixelArr, Node root){
        path.create(root, 0, "");
        Node[] pathArr = sort.mergeSort(path.getPathArray(), "pixel");
        
        //READ FOR CHECKING
        System.out.println("ROW: " + pixelArr.length + " \t\tCOLUMN: " + pixelArr[0].length);
        System.out.println("UNIQUE NODES: " + uniqueArr.length + " \tNO.OF PATHS: " + pathArr.length + "\n");

        //READ CONTENTS OF PATH ARRAY
        //for(int i=0; i<pathArr.length; i++){
        //    System.out.println("Path: " + pathArr[i].getPath() + " \tValue: " + pathArr[i].getValue() + " \tPixel: " + pathArr[i].getKey());
        //}

        int row = pixelArr.length;
        int col = pixelArr[0].length;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                //CHECK UPDATES
                System.out.println("check \t" + i + " \t" + j);
                String pathString = search.binSearch(pixelArr[i][j], pathArr);                
                pathString = extra.concat(pathString);

                while(pathString.length()  >= 8){
                    //CHECK UPDATES
                    System.out.println("\tprocessing substring");
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

        System.out.println("File written successfully.");
    }

    public void WriteToFile(String str){
        //CHECK BITSTRINGS
        //System.out.println(str);
        
        int num = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1'){
                num = (num << 1) | 1;
            }
            else if(str.charAt(i) == '0'){
                num = num << 1;
            }
        }

		try {
			file = new File("COMPRESSED.data");
			fileOutputStream = new FileOutputStream(file, true);
			if (!file.exists()) {
				file.createNewFile();
			}
			fileOutputStream.write((byte)(num & 0xff));
			fileOutputStream.flush();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
    }
    
}