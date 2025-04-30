
 
class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        // Build a perfect binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root = connect(root);

        // Print the next pointers at each level
        printNextPointers(root);
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node leftmost = root;

        while (leftmost.left != null) {
            Node current = leftmost;

            while (current != null) {
                current.left.next = current.right;

                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                current = current.next;
            }

            leftmost = leftmost.left;
        }

        return root;
    }

    public static void printNextPointers(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node current = levelStart;
            while (current != null) {
                System.out.print(current.val + " -> ");
                if (current.next != null)
                    System.out.print(current.next.val + " ");
                else
                    System.out.print("null ");
                current = current.next;
            }
            System.out.println();
            levelStart = levelStart.left;
        }
    }
}
