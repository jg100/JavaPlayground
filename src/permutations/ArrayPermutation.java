package permutations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPermutation {

    //testing main method
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        permute(nums);
    }

    //Return an array list of array lists that contain integers
    public static void backtrack(ArrayList<Integer> numsList) {
        //base case
        if(numsList.size() == 1) { //if there is only one value return to last call
            System.out.println(numsList);
            return;
        }

        //recursive call
        /**
         * Keep removing the first value until one is reached
         */

        int val = numsList.remove(0);
        backtrack(numsList);


    }

    public static ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<Integer> numsList = new ArrayList<>();

        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();

        //Copying values from nums array to ArrayList
        for(int num : nums) {
            numsList.add(num);
        }

        //Call backtracking algorithm
        backtrack(numsList);
        return null; //debug/testing
    }


}
