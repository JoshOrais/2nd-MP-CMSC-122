import java.util.Random;

public class ArrayTester{
    private BinarySearch search = new BinarySearch();
    private Random rand = new Random();

    public ArrayTester(){
        int test = 0;
        Node[] nodeArr = new Node[10000];
        for(int i=0; i<10000; i++){
            //System.out.println("test \t" + i);
            Node node = new Node();
            node.setKey(i);
            nodeArr[i] = node;
        }
        System.out.println("\nDone generating array\n");

        for(int i=0; i<3840; i++){
            for(int j=0; j<2160; j++){
                test = i+j;
                search.binSearch(rand.nextInt(10000), nodeArr);
                //System.out.println("check \t" + i + " \t" + j);

                int str = 1298765432;
                while(str >= 8){
                    if(str > 8){
                        str = str/8;
                    }
                    if(str == 8){
                        str = 0;
                    }
                }
            }
        }

        System.out.println(test);
    }

    public static void main(String [] args){
        new ArrayTester();
    }
}