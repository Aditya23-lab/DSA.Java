import java.util.Scanner;

class AVL {

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

    public AVL() {
        root = null;
    }

    public int height(Node node) {
        if (node == null) {
            return -1; // height of null node is -1
            
        }
        return node.height;
    }
    public int height() {
        return height(root);
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
        return rotate(node);
    }
    private Node rotate(Node node){
        if(height(node.left)-height(node.right)>1){
            // left heavy
            if(height(node.left.left)-height(node.left.right)>0){
            // left left case
            return rightRotate(node);
            }
            if(height(node.left.left)-height(node.left.right)<0){
                // left right case
                node.left=leftRotate(node.left);
                return rightRotate(node);
                }
        }
        if(height(node.left)-height(node.right)<-1){
            // right heavy
            if(height(node.right.left)-height(node.right.right)<0){
            // left left case
            return leftRotate(node);
            }
            if(height(node.right.left)-height(node.right.right)>0){
                // left right case
                node.right=rightRotate(node.right);
                return leftRotate(node);
                }
        }
        return node;

    }
    public Node rightRotate(Node p){
        Node c=p.left;
        Node t=c.right;

        c.right=p;
        p.left=t;
        p.height=Math.max(height(p.left),height(p.right)+1);
        c.height=Math.max(height(c.left),height(c.right)+1);
        return c;
    }
    public Node leftRotate(Node c){
        Node p=c.right;
        Node t=p.left;

        p.left=c;
        c.right=t;
        p.height=Math.max(height(p.left),height(p.right)+1);
        c.height=Math.max(height(c.left),height(c.right)+1);
        return p;
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
        int rightHeight = height(node.right);

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
        AVL tree = new AVL();
       for (int i = 0; i < 1000; i++) {
        tree.insert(i);
           

       }

       System.out.println(tree.height());
    
    }
}
