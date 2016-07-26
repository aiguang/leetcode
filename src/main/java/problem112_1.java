/**
 * Created by Administrator on 16-3-3.
 */
public class problem112_1 {

  public static void main(String[] args){
    TreeNode root = new TreeNode(-2);
    TreeNode right = new TreeNode(-3);
    root.right = right;
    System.out.println(new problem112_1().hasPathSum(root, -5));
  }


  public boolean hasPathSum(TreeNode root, int sum) {
    if(root == null) return false;
    if(root.left == null && root.right == null && root.val == sum) return true;
    return helper(root, sum, 0);
  }

  public boolean helper(TreeNode node, int sum, int current){
    if(node == null) return false;
    if(current + node.val == sum && node.left == null && node.right == null) return true;
    return helper(node.left, sum, current + node.val) || helper(node.right, sum, current + node.val);
  }
}
