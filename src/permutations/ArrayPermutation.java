package permutations;

import java.util.ArrayList;

public class ArrayPermutation {

    //testing main method
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        permutations(arr,0);
    }

    //Return an array list of array lists that contain integers
    public static ArrayList<ArrayList<Integer>> permutations(int[] arr, int start) {
        int removeIndex = start;

        if(removeIndex >= arr.length) {
            System.out.println(arr[removeIndex]);
            return null;
        }

        for(int i = start; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //recursive call for the left branch
        permutations(arr,removeIndex+1);

        //make index adjustments for the alternate branch. Switch omited value to next value
        removeIndex++;

        //recursive call for right branch
        permutations(arr, removeIndex+1);

        return null;
    }
}
