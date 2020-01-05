public class WriteTester{
    private String extra = "1001";

    public WriteTester(){
        String pathString = "1001111111110000000010101";
        pathString = extra.concat(pathString);
        //System.out.println("Combined: " + pathString + "\tLength: " + pathString.length());

        while(pathString.length()  >= 8){
            WriteToFile(pathString.substring(0, 8));
            if(pathString.length() > 8){
                pathString = pathString.substring(8, (pathString.length()));
            }
            if(pathString.length() == 8){
                pathString = "";
            }
        }
        extra = pathString;
        //System.out.println("Extra: " + extra);
    }

    public void WriteToFile(String str){
        System.out.println("Write: " + str);
    }

    public static void main(String [] args){
        new WriteTester();
    }
}