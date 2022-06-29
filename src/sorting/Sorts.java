package sorting;
// Implementation of sorting algorithms

import java.util.Arrays;

public class Sorts<T> {

    //Main testing
    public static void main(String[] args) {
        int[] nums = {8,2,6,4,9,7,1};
        //selectionSort(nums);
        //insertionSort(nums);
        insertionSortRec(nums,1);
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
     *
     * Maybe change swap for insert and push.
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
                    //Insert value into j spot, move everything up one
                    swap(arr,j,unsortedStart);
                }
                j++;
            }
            System.out.println(Arrays.toString(arr));
            unsortedStart++;
        }
    }

    //Recursive insertion sort.

    /**
     * Change swap for insert and shift
     * @param arr
     * @param unsortedStart
     */
    public static void insertionSortRec(int[] arr, int unsortedStart) {
        //pass in unsorted array recursively
        if(unsortedStart == arr.length-1) return;


        for(int i = 0; i < unsortedStart; i++) {
            if(arr[unsortedStart] < arr[i]) {
                swap(arr,unsortedStart,i);
            }
        }
        System.out.println(Arrays.toString(arr));
        //System.out.println(unsortedStart);
        unsortedStart = unsortedStart+1;
        insertionSortRec(arr,unsortedStart);
    }

    //Shell Sort

    //Merge Sort
    /**
     * Merge sort divides an array into smaller partitions
     * Sorts smaller parts and merges into a final sorted array
     * Divide and conquer algorithm.
     */
    public static void mergeSort(int[] arr, int startIndex, int endIndex) {
        int mid = (endIndex - startIndex) / 2;
        if(mid == 0) return;

        int firstHalf = mid - 1;
        int secondHalf = mid;

        //divide portion

        //left branch
        mergeSort(arr, startIndex, firstHalf);

        //right branch
        mergeSort(arr, secondHalf, endIndex);

        //merge portion

    }

    private static void merge(int[] arr1, int[] arr2) {

    }

    private void copy(int[] original, int[] target) {
        for(int i = 0; i < original.length; i++) {
            target[i] = original[i];
        }
    }



    //Quick Sort


    //Heap sort (Sorted in place to get O(1) complexity

}
