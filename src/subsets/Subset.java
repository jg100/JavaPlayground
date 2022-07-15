package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] arr = {3,4,5};
    }

    private List<List<Integer>> subsets(int[] arr) {

        List<List<Integer>> subsets = new ArrayList<>();
        //Adding the empty set
        subsets.add(new ArrayList<>());

        for(int i = 0; i < arr.length; i++) {
            //Add the current digit as a subset.

            //traversing the following numbers
            for(int j = i + 1; j < arr.length; j++) {

            }

        }

        return subsets;
    }
}
