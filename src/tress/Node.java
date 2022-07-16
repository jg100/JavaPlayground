package tress;

public class Node<T> {
    private T value;
    private Node v1;
    private Node v2;

    Node(T value) {
        this.value = value;
        this.v1 = null;
        this.v2 = null;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setV1(Node v1) {
        this.v1 = v1;
    }

    public void setV2(Node v2) {
        this.v2 = v2;
    }

    public T getValue() {
        return value;
    }

    public Node getV1() {
        return v1;
    }

    public Node getV2() {
        return v2;
    }
}
