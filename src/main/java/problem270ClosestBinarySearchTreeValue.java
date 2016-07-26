/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is
 * closest to the target.
 *
 * Note: Given target value is a floating point. You are guaranteed to have only one unique value in
 * the BST that is closest to the target. Show Company Tags Show Tags Show Similar Problems
 *
 * [41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,
 * null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,
 * 11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,
 * null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23] 3.285714
 */
public class problem270ClosestBinarySearchTreeValue {

  public static void main(String[] args) {
    TreeNode node = new TreeNode(2);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(3);
    node.left = node1;
    node.right = node2;
    double target = 0.14;
    System.out.println(new problem270ClosestBinarySearchTreeValue().closestValue(node, target));
  }

  public int closestValue(TreeNode root, double target) {
    TreeNode node = (root.val > target) ? root.left : root.right;
    if (node == null) {
      return root.val;
    }
    int value = closestValue(node, target);
    return Math.abs(root.val - target) > Math.abs(value - target) ? value : root.val;
  }

}
