/**
 * Created by Administrator on 15-11-16.
 */
public class problem98 {
  public boolean isValidBST(TreeNode root) {
    if(root == null) return true;
    if(root.val > Long.MAX_VALUE || root.val < Long.MIN_VALUE) return false;
    return isValid(root.left, root.val, Long.MIN_VALUE) && isValid(root.right,Long.MAX_VALUE, root.val);
  }
  private boolean isValid(TreeNode node, long maxValue, long minValue){
    if(node == null) return true;
    if(node.val >= maxValue || node.val <= minValue) {
      return false;
    }
    return isValid(node.left, node.val, minValue) && isValid(node.right,maxValue ,node.val);
  }
}
