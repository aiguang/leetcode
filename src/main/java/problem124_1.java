/**
 * Created by Administrator on 16-3-4.
 */
public class problem124_1 {
  public  int maxPathSum(TreeNode root){
    if(root == null) return 0;
    return root.val + helper(root.left) + helper(root.right);
  }
  public int helper(TreeNode node){
    if(node == null) return 0;
    int left = node.val + helper(node.left);
    int right = node.val + helper(node.right);
    return Math.max(left,right);
  }

}
