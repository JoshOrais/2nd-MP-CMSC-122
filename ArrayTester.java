import java.util.Random;
import java.io.File;
import java.io.FileOutputStream;

public class ArrayTester{
    private BinarySearch search = new BinarySearch();
    private Random rand = new Random();
    private File file;
    private FileOutputStream fileOutputStream;

    public ArrayTester(){
        int test = 0;
        Node[] nodeArr = new Node[100];
        for(int i=0; i<100; i++){
            //System.out.println("test \t" + i);
            Node node = new Node();
            node.setKey(i);
            nodeArr[i] = node;
        }
        System.out.println("\nDone generating array\n");

        for(int i=0; i<300; i++){
            for(int j=0; j<300; j++){
                test = i+j;
                search.binSearch(rand.nextInt(100), nodeArr);
                //System.out.println("check \t" + i + " \t" + j);

                int str = 1298765432;
                while(str >= 8){
                    if(str > 8){
                        str = str/8;
                        WriteToFile("11100111");
                    }
                    if(str == 8){
                        str = 0;
                    }
                }

                if(str<8){
                    WriteToFile("11100111");
                }
            }
        }

        System.out.println("Done");
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
			file = new File("Oten.data");
			fileOutputStream = new FileOutputStream(file, true);
			if (!file.exists()) {
				file.createNewFile();
			}
			fileOutputStream.write((byte)(num & 0xff));
			//fileOutputStream.flush();
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

    public static void main(String [] args){
        new ArrayTester();
    }
}