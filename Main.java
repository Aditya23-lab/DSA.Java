// import java.util.*;

// // Main class must match the file name
// public class Main {
//   public static void main(String[] args) {
//     // Example tree:
//     TreeNode root = new TreeNode(1);
//     root.left = new TreeNode(2);
//     root.right = new TreeNode(3);
//     root.left.left = new TreeNode(4);
//     root.left.right = new TreeNode(5);

//     BFS bfs = new BFS();
//     List<List<Integer>> result = bfs.levelOrder(root);
//     System.out.println(result);
//   }
// }

// // BFS class
// class BFS {
//   public List<List<Integer>> levelOrder(TreeNode root) {
//     List<List<Integer>> result = new ArrayList<>();

//     if (root == null) {
//       return result;
//     }

//     Queue<TreeNode> queue = new LinkedList<>();
//     queue.offer(root);

//     while (!queue.isEmpty()) {
//       int levelSize = queue.size();
//       List<Integer> currentLevel = new ArrayList<>(levelSize);
//       for (int i = 0; i < levelSize; i++) {
//         TreeNode currentNode = queue.poll();
        
//         if(i==levelSize-1){
//             result.add(currentNode.val);
//         }
//         if (currentNode.left != null) {
//           queue.offer(currentNode.left);
//         }
//         if (currentNode.right != null) {
//           queue.offer(currentNode.right);
//         }
//       }
     
//     }
//     return result;
//   }
// }

// TreeNode class
// class TreeNode {
//   int val;
//   TreeNode left;
//   TreeNode right;

//   TreeNode(int val) {
//     this.val = val;
//   }
// }

import java.util.*;

// Main class must match the file name
public class Main {
  public static void main(String[] args) {
    // Example tree:
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    RightSideView rsv = new RightSideView();
    List<Integer> result = rsv.rightSideView(root);
    System.out.println(result);
  }
}

// RightSideView class
class RightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();

        // Add the last node of each level
        if (i == levelSize - 1) {
          result.add(currentNode.val);
        }

        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }
      }
    }

    return result;
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
