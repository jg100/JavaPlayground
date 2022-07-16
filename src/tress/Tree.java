package tress;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    private Node<T> root;
    private Node<T> currentNode;

    Tree(T rootValue) {
        this.root = new Node<T>(rootValue);
        this.currentNode = root;
    }

    Tree() {
        this.root = null;
    }

    public void addNode(T newNodeValue ) {
        Node<T> newNode = new Node<>(newNodeValue);

        //If left or right nodes are empty, new node is attached to correpsonding node.
        if(currentNode.getV1() == null) {
            currentNode.setV1(newNode);
        } else if(currentNode.getV2() == null) {
            currentNode.setV2(newNode);
        } else { //at this point. Node is complete. Need to create new.
            currentNode.getV1().setV1(newNode); //sets the left most nodes child to newNode
        }
        //The most recent addition to the tree is set as the current node
        this.currentNode = newNode;
    }

    public void bfsTraversal() {
        Node<T> currNode = root;
        if(currNode.getV1() == null && currNode.getV2() == null) {
            System.out.print(currNode.getValue() + " ");
            return;
        }
        System.out.println(currNode + " ");
    }


}
