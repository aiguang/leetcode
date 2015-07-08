/**
 * Created by Administrator on 15-6-28.
 *
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftCount = 0;
        if(root.left != null){
            leftCount = 1 + maxDepth(root.left);
        }
        int rightCount = 0;
        if(root.right != null){
            rightCount = 1 + maxDepth((root.right));
        }
        return leftCount > rightCount ? (leftCount + 1) : (rightCount + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
