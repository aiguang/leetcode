/**
 * Created by Administrator on 16-6-22.
 */
public class problem110BalancedBinaryTree {
  class DataNode{
    boolean isBalance = false;
    int depth = 0;
  }
  public boolean isBalanced(TreeNode root) {
    if(root == null) return true;
    DataNode node = helper(root);
    return node.isBalance;
  }
  private DataNode helper(TreeNode node){
    if(node == null){
      DataNode n = new DataNode();
      n.isBalance = true;
      n.depth = 0;
      return n;
    }
    DataNode left = helper(node.left);
    DataNode right = helper(node.right);
    DataNode n = new DataNode();
    if(left.isBalance && right.isBalance){
      n.isBalance = Math.abs(left.depth - right.depth) <= 1;
      n.depth = Math.max(left.depth, right.depth) + 1;
    }else{
      n.isBalance = false;
      int leftDepth = left == null ? 0 : left.depth;
      int rightDepth = right == null ? 0 : right.depth;
      n.depth = Math.max(leftDepth, rightDepth) + 1;
    }
    return n;
  }
}
