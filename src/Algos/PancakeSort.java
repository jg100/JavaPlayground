package Algos;

import java.util.ArrayList;
import java.util.List;

/**
 * Pancake sort algo imp.
 */
class PancakeSort {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ret = new ArrayList<>();
        int max = 10 * arr.length;

        //Start with the highest number and work your way down
        for(int currNumber = arr.length; currNumber > 0; currNumber--) {
            //find index of the current value i
            int index = getIndex(arr, currNumber);

            //if the index is not in list, skip
            if(index == -1) continue;

            //if the index is not already at head
            if(index != 0) {
                reverse(arr,index+1);
                ret.add(index+1);
            }

            ret.add(currNumber);
            reverse(arr, currNumber);

        }

        /*
        //While the array is unsorted conduct the pancake swap
        while(!isSorted(arr)) {
            //System.out.println("Arr length: " + arr.length);
            //Choose a random k from 1 to arr length inclusive
            int k = arr[(int)(Math.random() * arr.length)];
            max--;
            //System.out.println("k: " + k);

            //reverse the first k values of the array by passing in subarray
            reverse(arr, k);

            ret.add(k);

        }
        System.out.println("Size: " + ret.size());
        return ret;
        */
        return ret;

    }

    private int getIndex(int[] arr, int val) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == val) return i;

        }
        return -1;
    }

    private boolean isSorted(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }


    //pass by ref, no need to ret.
    private void reverse(int[] arr, int k) {
        int left = 0;
        int right = k-1; //last element of subarray

        //traverse array from the outside in.
        while(left < right) { //while the left index is less than the. right
            //conduct swap
            int temp = arr[left];
            //System.out.println("left: " + left);
            //System.out.println("right: " + right);
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }


    }
}