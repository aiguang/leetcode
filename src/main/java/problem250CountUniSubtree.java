/**
 * Created by Administrator on 16-5-9.
 */
public class problem250CountUniSubtree {
  private int count = 0;
  public int countUnivalSubtrees(TreeNode root) {
    if(root == null) return 0;
    helper(root);
    return count;
  }
  private boolean helper(TreeNode node){
    if(node == null) return true;
    boolean left = helper(node.left);
    boolean right = helper(node.right);

    if(left && right && (node.left == null || node.left.val == node.val) && (node.right == null || node.right.val == node.val)){
      count++;
      return true;
    }
    return false;
  }

}
