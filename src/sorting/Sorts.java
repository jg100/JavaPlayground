package sorting;
// Implementation of sorting algorithms

import java.util.Arrays;

public class Sorts<T> {

    //Main testing
    public static void main(String[] args) {
        //int[] nums = {8,2,6,4,9,7,1};
        int[] arr = {7,5,9,3,6,0,2,4};
        //selectionSort(nums);
        //insertionSort(nums);
        //insertionSortRec(nums,1);
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

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
        //tackle divide step(s) first

        //Printing of traversed portions of array for debugging purposes
        for(int i = startIndex; i <= endIndex; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        System.out.println("endIndex: " + endIndex + "\nstartIndex: " + startIndex);

        //Issue: Last leaves not separated. Issue in mid with 0 and 1 indexes.
        int mid = (endIndex+ - startIndex) / 2;

        //When indicies are the same no need to continue recursion
        if(endIndex == startIndex) return;

        System.out.println("Mid index: " + mid);

        //Offset the startIndex and mid
        mergeSort(arr, startIndex, startIndex + mid); //left side split

        //Issue: Was not offsetting the middle index by the new start index
        mergeSort(arr, startIndex + mid + 1 , endIndex); //right side divide


    }

    /**
     * Downside to this merge function is the allocation of an array for every merge call :/
     * Bad space complexity.
     */
    private static int[] mergeV1(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length + arr2.length];
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] > arr2[i]) {
                //put arr2[i] first in array
                temp[i] = arr2[i];
                temp[i+1] = arr1[i];
            } else {
                temp[i] = arr1[i];
                temp[i+1] = arr2[i];
            }
        }
    return temp;
    }

    /**
     * Merging consists of comparing corresponding indicies.
     */
    public static void merge(int[] arr1, int[] arr2) {



    }

    private void copy(int[] original, int[] target) {
        for(int i = 0; i < original.length; i++) {
            target[i] = original[i];
        }
    }



    //Quick Sort


    //Heap sort (Sorted in place to get O(1) complexity

}
