package permutations;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayPermutation {
    //testing main method
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    //Return an array list of array lists that contain integers
    public static ArrayList<ArrayList<Integer>> backtrack(ArrayList<Integer> numsList) {
        //ArrayList to collect the permutations for a particular instance
        //base case returns a single value as a list of a list.
        if(numsList.size() == 1) { //if there is only one value return to last call
            //System.out.println("Base case: " + numsList);
            //Returns a list of list with only the final value
            ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
            ret.add(numsList);
            System.out.println("Base case: " + ret);
            return ret;
        }

        //List of all permutations
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        for(int i = 0; i < numsList.size(); i++) { //traverses the entire list
            System.out.println("Iteration start...");
            /**
             * For every value in the list/sublist remove one.
             * Take removed and append the result fo the children to it
             * At the end of every iteration
             */
            System.out.println("numList: " + numsList);
            //Adding the removed value as a list to the temp list of lists.
            int val = numsList.remove(i); //removing value i
            System.out.println("VAL:: " + val);
            //Rec call and saves the resulting permutations
            ArrayList<ArrayList<Integer>> returned = backtrack(numsList);


            for(ArrayList<Integer> ret : returned) {
                ArrayList<Integer> holder = new ArrayList<>();
                holder.add(val);
                holder.addAll(ret);
                temp.add(holder);
            }

            numsList.add(0,val);

        }

        System.out.println("Final temp: " + temp);
        return temp;
        //System.out.println(permutation);
        //At the end the function should return the permutations for X level in the tree.
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
        return backtrack(numsList);

    }
}
