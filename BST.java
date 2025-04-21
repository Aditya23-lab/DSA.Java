import java.util.Scanner;

class BST {

    // Node class with a constructor to initialize node value and height
    public class Node {
        private int value;
        private Node right;
        private Node left;
        private int height;

        public Node(int value) {
            this.value = value;
            this.height = 0;  // By default, leaf node has height 0
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BST() {
        root = null;
    }

    public int height(Node node) {
        if (node == null) {
            return -1; // height of null node is -1
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value); // Create new node if position is found
        }

        if (value < node.value) {
            node.left = insert(node.left, value); // Insert in left subtree
        } else if (value > node.value) {
            node.right = insert(node.right, value); // Insert in right subtree
        }

        // Update height after insertion
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }
    public void populatedSorted(int []nums){
        populatedSorted(nums,0,nums.length);
    }
    private void populatedSorted(int []nums,int start,int end){
        if(start>=end){
            return;

        }
        int mid =(start+end)/2;
        this.insert(nums[mid]);
        populatedSorted(nums,start,mid);
        populatedSorted(nums,mid+1,end);

    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.righst);

        return Math.abs(leftHeight - rightHeight) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display() {
        display(this.root, "Root Node:");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }

        System.out.println(details + " " + node.value);
        display(node.left, "Left child of " + node.value + ":");
        display(node.right, "Right child of " + node.value + ":");
    }

    // Main method should be outside the BST class
    public static void main(String[] args) {
        BST tree = new BST();
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        tree.populatedSorted(nums);
        tree.display();
    }
}
