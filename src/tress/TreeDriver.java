package tress;

public class TreeDriver {
    public static void main(String[] args) {

        Tree<Integer> myTree = new Tree(5);

        myTree.addNode(6);
        myTree.addNode(7);
        myTree.addNode(8);
        myTree.addNode(9);
        myTree.addNode(10);
        myTree.addNode(11);


        myTree.bfsTraversal(myTree.getRoot());

    }
}
