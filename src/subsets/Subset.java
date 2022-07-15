package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] arr = {3,4,5};
        System.out.println(subsets(arr));
    }

    private static List<List<Integer>> subsets(int[] arr) {

        List<List<Integer>> subsets = new ArrayList<>();
        //Adding the empty set
        subsets.add(new ArrayList<>());

        //traverse everything up until the last value
        for(int i = 0; i < arr.length; i++) {
            //Add the current digit as a subset.
            subsets.add(new ArrayList<>(Arrays.asList(arr[i])));

            //traversing the following numbers
            for(int j = i + 1; j < arr.length; j++) {
                subsets.add(Arrays.asList(arr[i], arr[j]));
            }
        }

        //Add the whole array as a subset
        List<Integer> wholeSet = new ArrayList<>();
        for(int num : arr) {
            wholeSet.add(num);
        }
        subsets.add(wholeSet);


        return subsets;
    }
}
