public class ReadDimensions{
    public int[] read(byte[] fileContent){
        int[] dimensions = new int[2];
        int row=0, col=0;

        //CHECK ROW BITSTRING
        System.out.print("\nROW:\n");
        for(int i=0; i<4; i++){
            row = (row << 8) | fileContent[i]; 
            String s1 = String.format("%8s", Integer.toBinaryString((fileContent[i]) & 0xFF)).replace(' ', '0');
            System.out.println(s1);
        }
        //CHECK COLUMN BITSTRING
        System.out.print("COLUMN:\n");
        for(int i=4; i<8; i++){
            col = (col << 8) | fileContent[i];
            String s1 = String.format("%8s", Integer.toBinaryString((fileContent[i]) & 0xFF)).replace(' ', '0');
            System.out.println(s1);
        }
        System.out.print("\n");

        dimensions[0] = row;
        dimensions[1] = col;
        return dimensions;
    }
}