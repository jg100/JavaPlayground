package permutations;
import java.util.ArrayList;

public class ArrayPermutation {

    static ArrayList<ArrayList<Integer>> permutation = new ArrayList<>();

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

        // For every number in the list, make a recursive call to get permutation of #s with value removed
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        for(int i = 0; i < numsList.size(); i++) {
            System.out.println("Iteration start");
            /**
             * For every value in the list/sublist remove one.
             * Take removed and append the result fo the children to it
             * At the end of every iteration
             */

            //Adding the removed value as a list to the temp list of lists.
            int val = numsList.remove(i); //removing value i
            ArrayList<Integer> vList = new ArrayList<>();

            vList.add(val);
            //temp.add(vList); //adds the removed value to the temp arraylist

            System.out.println("Temp before rec adAll: " + temp);

            ArrayList<ArrayList<Integer>> returned = backtrack(numsList);
            vList.addAll(returned.get(0));
            temp.add(vList);
            System.out.println("vList: " + vList);
            System.out.println("Result fo rec calls: " + returned);

            numsList.add(i, val); //putting removed value back

            System.out.println("Temp at end of iteration: " + temp);
        }

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
