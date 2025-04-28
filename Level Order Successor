
  
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;  // <-- import Scanner

public class Main {
    public static void main(String[] args) {
        // Example tree:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BFS bfs = new BFS();

        // Input key from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the key to find its successor: ");
        int key = scanner.nextInt();

        TreeNode successor = bfs.findSuccessor(root, key);

        if (successor != null) {
            System.out.println("Successor of " + key + " is: " + successor.val);
        } else {
            System.out.println("No successor found for " + key);
        }

        scanner.close();  // close the scanner to avoid resource leak
    }
}

// BFS class
class BFS {
    public TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.val == key) {
                break;
            }
        }

        return queue.peek();
    }
}

// TreeNode class
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
