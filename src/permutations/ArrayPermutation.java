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
    public static ArrayList<Integer> backtrack(ArrayList<Integer> numsList) {

        //Removes the first value in the list
        int remove = numsList.remove(0);

        if(numsList.size() == 1) {
            System.out.println(numsList);
            return null; //null for testing purposes
        }

        System.out.println(numsList);
        backtrack(numsList);
        return null;
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
