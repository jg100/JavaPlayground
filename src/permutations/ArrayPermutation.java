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
            System.out.println("Base case: " + numsList);
            return;
        }

        // For every number in the list, make a recursive call to get permutation of #s with value removed
        for(int i = 0; i < numsList.size(); i++) {
            //remove the element and make recursive call
            int val = numsList.remove(i);
            System.out.println(numsList);
            backtrack(numsList);
            //add removed number back
            numsList.add(0,val);

            System.out.println("Out of recursive call");
        }

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
