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
//         currentLevel.add(currentNode.val);
//         if (currentNode.left != null) {
//           queue.offer(currentNode.left);
//         }
//         if (currentNode.right != null) {
//           queue.offer(currentNode.right);
//         }
//       }
//       result.add(currentLevel);
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

    BFS bfs = new BFS();
    List<Double> result = bfs.averageOfLevel(root);
    System.out.println(result);
  }
}

// BFS class
class BFS {
  public List<Double> averageOfLevel(TreeNode root) {
    List<Double>result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
     double averageLevel=0;
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();
       averageLevel +=currentNode.val;
        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }
      }
       averageLevel=averageLevel/levelSize;
      result.add(averageLevel);
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

