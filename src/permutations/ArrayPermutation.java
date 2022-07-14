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
    public static ArrayList<ArrayList<Integer>> backtrack(ArrayList<Integer> numsList) {

        //ArrayList to collect the permutations for a particular instance

        //base case
        if(numsList.size() == 1) { //if there is only one value return to last call
            //System.out.println("Base case: " + numsList);
            //Returns a list of list with only the final value
            ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
            ret.add(numsList);
            return ret;
        }

        ArrayList<ArrayList<Integer>> permutation = new ArrayList<>();

        // For every number in the list, make a recursive call to get permutation of #s with value removed
        for(int i = 0; i < numsList.size(); i++) {
            //remove the element and make recursive call

            System.out.println("Current index: " + i);

            int val = numsList.remove(i);
            //Adding the removed value to the arrayList
            permutation.add(new ArrayList<>(val));

            System.out.println(numsList);
            permutation.addAll(backtrack(numsList));

            //add removed number back
            numsList.add(i,val);
        }

        return permutation;

    }

    public static ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<Integer> numsList = new ArrayList<>();

        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();

        //Copying values from nums array to ArrayList
        for(int num : nums) {
            numsList.add(num);
        }

        //Call backtracking algorithm
        System.out.println(backtrack(numsList));
        return null; //debug/testing
    }


}
