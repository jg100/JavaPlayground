package bitwise;

import java.util.ArrayList;

public class BitOperations {

    public static void main(String[] args) {
        int num = 4;
        int pos = 1;

        //System.out.println(set(num,pos));

        System.out.println(getBit(2,1));

    }


    /**
     * Takes the index and uses 0001 (1) to move the bit to the i-th
     * location.
     * Use Bitwise AND to compare the two. If the bit is set 1 is returned.
     * If the bit is not set then 0 is returned.
     *
     * @param num
     * @param index
     * @return
     */
    public static boolean getBit(int num, int index) {
        //break down each step

        //moving bit. Move bit to the desired index
        int move = (1 << index);

        //bitwise and operation
        return (num & move) != 0;

        /**
         * Can also be written in a single line
         *
         * return (num $ (1 << index)) != 0);
         */



    }

    /**
     *
     * @param num
     * @param pos
     * @return
     */
    public static int set(int num, int pos) {
        /**
         * Left shift the 0001 to the desired index and bitwise and to num
         * Store the number in num and return.
         */
        num |= (1 << pos);
        return num;
    }


    // Clear bit





}
