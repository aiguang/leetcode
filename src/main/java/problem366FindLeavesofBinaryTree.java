import java.util.ArrayList;
import java.util.List;

/**
 Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 Example:
 Given binary tree
 1
 / \
 2   3
 / \
 4   5
 Returns [4, 5, 3], [2], [1].

 Explanation:
 1. Removing the leaves [4, 5, 3] would result in this tree:

 1
 /
 2
 2. Now removing the leaf [2] would result in this tree:

 1
 3. Now removing the leaf [1] would result in the empty tree:

 []
 Returns [4, 5, 3], [2], [1].
 */
public class problem366FindLeavesofBinaryTree {
  public static void main(String[] args){
    TreeNode root = new TreeNode(1);
    TreeNode left1 = new TreeNode(2);
    TreeNode right1 = new TreeNode(3);
    TreeNode left2 = new TreeNode(4);
    TreeNode right2 = new TreeNode(5);
    root.left = left1;
    root.right = right1;
    left1.left = left2;
    left1.right = right2;
    List<List<Integer>> result = new problem366FindLeavesofBinaryTree().findLeaves(root);
    for(List<Integer> r : result){
      for(Integer i : r){
        System.out.print(i + ",");
      }
      System.out.println();
    }

  }
  class Node{
    TreeNode node;
    int level;
    Node(TreeNode node, int level){
      this.node = node;
      this.level = level;
    }
  }
  public List<List<Integer>> findLeaves(TreeNode root) {
    if(root == null) return new ArrayList<List<Integer>>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    helper(result, root);
    return result;
  }
  public Node helper(List<List<Integer>> result, TreeNode node){
    if(node == null){
      Node n = new Node(null, 0);
      return n;
    }
    Node left = helper(result, node.left);
    Node right = helper(result, node.right);
    int level = Math.max(left.level, right.level) + 1;
    Node n = new Node(node, level);
    if(result.isEmpty() || result.size() < level){
      result.add(new ArrayList<Integer>());
    }
    List<Integer> l = result.get(level - 1);
    l.add(node.val);
    return n;
  }
}
