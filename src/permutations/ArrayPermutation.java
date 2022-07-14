package permutations;
import java.util.ArrayList;

public class ArrayPermutation {

    static ArrayList<ArrayList<Integer>> permutation = new ArrayList<>();

    //testing main method
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        permute(nums);
    }

    //Return an array list of array lists that contain integers
    public static ArrayList<Integer> backtrack(ArrayList<Integer> numsList) {

        //ArrayList to collect the permutations for a particular instance

        //base case
        if(numsList.size() == 1) { //if there is only one value return to last call
            //System.out.println("Base case: " + numsList);
            //Returns a list of list with only the final value
            ArrayList<Integer> ret = new ArrayList<>();
            ret.add(numsList.get(0));
            System.out.println("Base case: " + ret);
            return ret;
        }



        // For every number in the list, make a recursive call to get permutation of #s with value removed
        for(int i = 0; i < numsList.size(); i++) {
            System.out.println("Iteration start");
            ArrayList<Integer> temp = new ArrayList<>();

            /**
             * For every value in the list/sublist remove one.
             *
             * Take removed and append the result fo the children to it.
             *
             * At the end of every iteration
             */
            int val = numsList.remove(i); //removing value i
            temp.add(val);

            System.out.println("Temp before rec adAll: " + temp);
            temp.addAll(backtrack(numsList));

            numsList.add(i, val); //putting removed value back

            System.out.println("Temp at end of iteration: " + temp);
        }

        //System.out.println(permutation);
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
        //System.out.println(backtrack(numsList));
        backtrack(numsList);
        return null; //debug/testing
    }
}
