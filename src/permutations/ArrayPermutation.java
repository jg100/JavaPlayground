package permutations;
import java.util.ArrayList;

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
            System.out.println("Base case: " + ret);
            return ret;
        }

        ArrayList<ArrayList<Integer>> permutation = new ArrayList<>();

        // For every number in the list, make a recursive call to get permutation of #s with value removed
        for(int i = 0; i < numsList.size(); i++) {

            int val = numsList.remove(i);
            System.out.println("Value removed: " + val);
            permutation.add(new ArrayList<Integer>(val));

            //Adding the removed value to the arrayList
            System.out.println(numsList);
            System.out.println("Perm array before addition: " + permutation);
            permutation.addAll(backtrack(numsList));

            ArrayList<Integer> sp = new ArrayList<>();
            System.out.println("Perm array before merge: " + permutation);
            //Combine the arrays into one
            for(int j = 0; j < permutation.size(); j++) {
                sp.add(permutation.get(i).get(0)); //Every element is a single valued AL
            }
            permutation.clear();
            permutation.add(sp);
            System.out.println("Perm array after merge: " + permutation);

            //add removed number back
            numsList.add(i,val);

            //System.out.println(permutation);
        }

        //System.out.println(permutation);
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
