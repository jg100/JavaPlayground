package sorting;
// Implementation of sorting algorithms

import java.util.Arrays;

public class Sorts<T> {

    //Main testing
    public static void main(String[] args) {
        //int[] nums = {8,2,6,4,9,7,1};
        int[] arr = {4,10,3,5,1};
        //selectionSort(nums);
        //insertionSort(nums);
        //insertionSortRec(nums,1);
        //int[] temp = new int[arr.length];
        //mergeSort(arr,temp,0,arr.length-1);
        //System.out.println(Arrays.toString(arr));
        //quickSort(arr,0, arr.length-1);
        heapSort(arr,0,arr.length-1);
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
    public static void mergeSort(int[] arr, int[] temp, int startIndex, int endIndex) {
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
        mergeSort(arr,temp, startIndex, startIndex + mid); //left side split
        //Issue: Was not offsetting the middle index by the new start index
        mergeSort(arr,temp, startIndex + mid + 1 , endIndex); //right side divide

        //Merge the results of the recursive calls above
        merge(arr,temp,startIndex,mid,endIndex);
    }

    /**
     * Merging consists of comparing corresponding indicies.
     * Given start and end indicies of an array
     */
    public static void merge(int[] arr, int[] temp, int start, int mid, int end) {

        int firstHalfStart = start;
        int firstHalfEnd = mid;

        int secondHalfStart = mid + 1;
        int secondHalfEnd = end;

        //traversing the passed in halfs of the array
        int tempIndex = 0;
        while((firstHalfStart <= firstHalfEnd) && (secondHalfStart <= secondHalfEnd)) {
            if(arr[firstHalfStart] <= arr[secondHalfStart]) {
                //store the secondHalfStart index and increment
                temp[tempIndex] = arr[firstHalfStart];
                secondHalfStart++;
            } else {
                //store the firstHalfStart and increment the value
                temp[tempIndex] = arr[secondHalfStart];
                firstHalfStart++;
            }
            tempIndex++;
        }

        System.out.println("Before copying the rem values: " + Arrays.toString(temp));


        //All values that can be compared are compared. Left-overs need to be copied over.
        if(firstHalfStart != firstHalfEnd) { //if values not equal, end has not been reached
            //copy remaining values
            tempIndex += mergeCopyHelper(arr,temp,firstHalfStart,firstHalfEnd,tempIndex);
        }

        if(secondHalfStart != secondHalfEnd) {
            //copy remaining  values
            tempIndex += mergeCopyHelper(arr,temp,secondHalfStart,secondHalfEnd,tempIndex);
        }

        //copy the sorted piece to the original array. tempIndex would be location of last value.

        System.out.println("In merge: " + Arrays.toString(temp));

    }

    private static int mergeCopyHelper(int[] main, int[] target, int start,int end, int index) {
        int originalIndex = index;
        for(int i = start; i <= end; i++) {
            target[index] = main[i];
            index++;
        }
        return index - originalIndex;
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


    private void copy(int[] original, int[] target) {
        for(int i = 0; i < original.length; i++) {
            target[i] = original[i];
        }
    }



    //Quick Sort

    /**
     * - Choose a pivot. Pivot is in position that it will reside in final sorted array
     * - Entries before the pivot are less than or equal the pivot
     * - Entries in the positions after the pivot are greater than or equal to the pivot.
     */
    public static void quickSort(int[] arr, int start, int end) {
        int leftIndex = start;
        int rightIndex = end;
        int pivotIndex = end;

        //System.out.println("Pivot: " + arr[pivotIndex]);
        if(end < start) return;

        while(leftIndex < rightIndex) {
            System.out.println("L:" + arr[leftIndex]);
            System.out.println("R:" + arr[rightIndex]);

            //if left has a value that bigger than pivot and right has value smaller than pivot: swap
            if(arr[leftIndex] >= arr[pivotIndex] && arr[rightIndex] < arr[pivotIndex]) {
                swap(arr,leftIndex,rightIndex);
                leftIndex++;
                rightIndex--;
            } else if(!(arr[leftIndex] >= arr[pivotIndex])) { //if left is smaller than pivot: inc the left and cont.
                leftIndex++;
            } else if(!(arr[rightIndex] < arr[pivotIndex])) { //if right is larger than pivot: dec the right and cont.
                rightIndex--;
            }
        }

        //swap the final pivot and left index overlap
        swap(arr,leftIndex,pivotIndex);
        System.out.println("*" + Arrays.toString(arr));

        quickSort(arr,start,pivotIndex-1);
        quickSort(arr,pivotIndex + 1, arr.length - 1);
    }

    // Helper function to select pivot.
    private int selectPivot(int[] arr) {
        return 1;
    }

    //Heap sort (Sorted in place to get O(1) complexity

    /**
     * Heapify the list
     */
    public static void heapSort(int[] arr, int start, int end) {
        System.out.println("Start of func: " + Arrays.toString(arr));
        System.out.println("End: " + end);
        if(start == end) return;
        for(int i = 0; i < end-2; i++) {
            if(arr[i] < arr[i+1]) {
                swap(arr,i,i+1);
            } else if(arr[i] < arr[i+2]) {
                swap(arr,i,i+2);
            }
        }
        //end of for means we have "heap-ified" the array

        //Swap the first and last values
        swap(arr,0,end);
        heapSort(arr,start,end-1);

    }

}
