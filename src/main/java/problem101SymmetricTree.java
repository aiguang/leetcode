/**
 * Created by Administrator on 16-6-22.
 */
public class problem101SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;
    return helper(root.left, root.right);
  }
  public boolean helper(TreeNode left, TreeNode right){
    if(left == null && right == null) return true;
    if(left == null) return false;
    if(right == null) return false;
    if(left.val != right.val) return false;
    return helper(left.left, right.right) && helper(left.right, right.left);
  }
}
