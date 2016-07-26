/**
 Given a binary tree, find the length of the longest consecutive sequence path.

 The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 The longest consecutive path need to be from parent to child (cannot be the reverse).

 For example,
  1
   \
    3
   / \
  2   4
       \
        5
 Longest consecutive sequence path is 3-4-5, so return 3.
   2
   \
   3
  /
  2
 /
 1
 Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class problem298BinaryTreeLongestConsecutiveSequence {
  public static void main(String[] args){
    TreeNode root = new TreeNode(1);
    TreeNode right = new TreeNode(3);
    root.right = right;

  }
  int max = 0;
  public int longestConsecutive(TreeNode root) {
    if(root == null) return 0;
    findLongest(root);
    return max;
  }
  public DataNode findLongest(TreeNode node){
    if(node == null){
      DataNode n = new DataNode();
      return n;
    }
    DataNode left = findLongest(node.left);
    DataNode right = findLongest(node.right);
    DataNode n = new DataNode();
    n.longest = 1;
    if(left.node == null && right.node == null){
      n.node = node;
    }else{
      n.node = node;
      int leftValue = left.node == null ? Integer.MAX_VALUE : left.node.val;
      int rightValue = right.node == null ? Integer.MAX_VALUE : right.node.val;
      if(leftValue - node.val == 1){
        n.longest = Math.max(left.longest + 1, n.longest);
      }
      if(rightValue - node.val == 1){
        n.longest = Math.max(right.longest + 1, n.longest);
      }
    }
    max = Math.max(max, n.longest);
    return n;
  }
  class DataNode{
    TreeNode node;
    int longest = 0;
  }

}
