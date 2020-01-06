public class ByteTester{
    public ByteTester(){
        //int x = 1001;
        //byte a = (byte)x;
        //String str = String.valueOf(x);

        //byte a = -100;
        //int x = a;
        //String str = String.valueOf(a);

        //String str = "1001";
        //int x = Integer.parseInt(str);
        //byte a = Byte.parseByte(str);
        
        String str = "1010";

        int length = str.length();
        StringBuilder sb = new StringBuilder(str);
        str = sb.reverse().toString();

        System.out.println(str);

    }

    public static void main (String [] args){
        new ByteTester();
    }
}