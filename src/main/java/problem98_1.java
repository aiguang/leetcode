/**
 * Created by Administrator on 16-3-1.
 */
public class problem98_1 {
  public static void main(String[] args){
    TreeNode node = new TreeNode(0);
    TreeNode node1 = new TreeNode(-1);
    node.left = node1;

    System.out.println(new problem98_1().isValidBST(node));
  }

  public boolean isValidBST(TreeNode root) {
    if(root == null) return true;
    if(root.val > Long.MAX_VALUE || root.val < Long.MIN_VALUE) return false;
    return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
  }
  public boolean helper(TreeNode node, long max, long min){
    if(node == null) return true;
    if(node.val >= max || node.val <= min) return false;
    return helper(node.left, node.val, min) && helper(node.right, max, node.val);
  }

}
