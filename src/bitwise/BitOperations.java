package bitwise;

public class BitOperations {

    public static void main(String[] args) {
        int num = 4;
        int pos = 1;

        System.out.println(set(num,pos));

    }

    public static boolean getBit(int num, int index) {



    }

    //Setting a bit in the nth postion of "num"
    public static int set(int num, int pos) {

        //left shift and use OR operator to set the bit
        num |= (1 << pos);
        return num;
    }





}
