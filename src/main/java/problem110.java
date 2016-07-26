/**
 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class problem110 {
  public boolean isBalanced(TreeNode root) {
    if(root == null) return true;
    return findDepth(root) != -1;
  }
  private int findDepth(TreeNode node){
    if(node == null) return 0;
    int leftHeight = findDepth(node.left);
    int rightHeight = findDepth(node.right);
    if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
      return -1;
    }
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
