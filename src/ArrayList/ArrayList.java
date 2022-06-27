package ArrayList;
import java.lang.reflect.Array;
/**
 * ArrayList to be implemented according to the Java API.
 * @param <T>
 */

public class ArrayList<T> {
    private T[] arr;
    private int size;

    //Arg constructor
    public ArrayList(T[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }

    //Zero arg constructor, constructs in ArrayList with initial capacity fo 10
    public ArrayList() {
        //Creating new array of Objects but casting into T[]
        this.arr = (T[]) new Object[10];
        this.size = 10;
    }

    //Constructor with initial capacity
    public ArrayList(int capacity) {
        this.arr = (T[]) new Object[capacity];
        this.size = capacity;
    }

    //Copy constructor


    //Behaviors
    public int length() {

        return size;

    }

    public boolean add(T value) {
        try {
            T[] temp = (T[]) new Object[this.size + 1];
            copy(this.arr, temp);
            this.arr = temp;
            this.arr[this.arr.length - 1] = value;
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    private void copy(T[] arrToCopy, T[] targetArray) {
        for(int i = 0; i < targetArray.length; i++) {
            targetArray[i] = arrToCopy[i];
        }
    }

    public boolean remove(int index) {
        return false;
    }

    public boolean remove(T value) {

    }


    public int indexOf(T value) {

    }



}
