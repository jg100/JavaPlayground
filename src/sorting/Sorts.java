package sorting;
// Implementation of sorting algorithms

import java.util.Arrays;

public class Sorts<T> {

    //Main testing
    public static void main(String[] args) {
        int[] nums = {5,2,4,1,7,5,3,6};
        //selectionSort(nums);
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));

    }


    //Selection sort
    //Move thorugh the array. one sorted half one unsorted. Move smallest of unsorted into sorted section
    //O(n^2) time. O(n) swaps
    public static void selectionSort(int[] nums) {
        int currIndex = 0;
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }

        }

    }
    //Array and indicies to swap
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //Insertion sort

    /**
     * Insertion Sort: Sorted half and unsorted half.
     *
     * Partition the array into two parts. Algorithm removes the first entry of the unsorted part and inserts it
     * into the proper location of the sorted half.
     * @param arr
     */
    //Iterative approach
    public static void insertionSort(int[] arr) {
        int unsortedStart = 1;
        //iterate through array and keep track of unsorted section
        for(int i = 1; i < arr.length; i++) {
            int j = 0;
            while(j < unsortedStart) {
                if(arr[j] > arr[unsortedStart]) {
                    swap(arr,j,unsortedStart);
                }
                j++;
            }
            unsortedStart++;
        }



    }

    //Recursive insertion sort
    public static void insertionSortRec(int[] arr) {


    }

    //Merge Sort

    //Quick Sort


    //Heap sort (Sorted in place to get O(1) complexity

}
