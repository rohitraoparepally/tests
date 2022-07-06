package company;

class Main{
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(8);
        binaryTree.add(4);
        binaryTree.add(2);
        binaryTree.add(7);
        binaryTree.add(9);
        binaryTree.add(6);

        if(null != binaryTree.root)
        binaryTree.printTree(binaryTree.root);

        //https://leetcode.com/problems/search-in-a-binary-search-tree/

        //binaryTree.printTree(binaryTree.searchBST(binaryTree.root, 3));
    }
}

public class BinaryTree {

    Node root;
    int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public void add(int value){
        this.size++;
        Node newNode = new Node(value);
        if(root == null){
            this.root = newNode;
        }
        else {

            recurseAdd(this.root, newNode);
        }
    }

    private void recurseAdd(Node rootNode, Node newNode){
        if(newNode.value >= rootNode.value){
            if(null != rootNode.rightChild){
                recurseAdd(rootNode.rightChild, newNode);
            }
            else {
                rootNode.rightChild = newNode;
            }
        }
        else {
            if(null != rootNode.leftChild){
                recurseAdd(rootNode.leftChild, newNode);
            }
            else {
                rootNode.leftChild = newNode;
            }
        }

    }

    public void printTree(Node rootNode){
        if (null != rootNode){
            System.out.print(rootNode.value+",");
            printTree(rootNode.leftChild);
            printTree(rootNode.rightChild);
        }
    }

    public Node searchBST(Node rootNode, int searchValue){

        if(rootNode == null){
            return null;
        }
        if(rootNode.value == searchValue){
            return rootNode;
        }
        if(rootNode.value > searchValue){
            return searchBST(rootNode.leftChild,searchValue);
        }
        else {
            return searchBST(rootNode.rightChild,searchValue);
        }
    }
}


class Node{
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int value) {
        this.value = value;
    }
}
