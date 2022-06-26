package ArrayList;
import java.lang.reflect.Array;
/**
 * ArrayList to be implemented according to the Java API.
 * @param <T>
 */

public class ArrayList<T>{
    private T[] arr;
    private int size;

    //Arg constructor
    public ArrayList(T[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }

    //Zero arg constructor
    public ArrayList() {
        this.arr = new T[];
        this.size = 0;
    }

    //Constructor with initial capacity
    public ArrayList(int capacity) {
        this.arr = new T[capacity];
    }



    //Copy constructor


    //Behaviors
    public int size() {
        return size;
    }

    public boolean add(T value) {
        return false;
    }

    public boolean remove(int index) {
        return false;
    }

    public boolean remove(T value) {

    }


    public int indexOf(T value) {

    }



}
