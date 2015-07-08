/**
 * Created by Administrator on 15-7-4.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return root;
        TreeNode treeNode = root.left;
        root.left = root.right;
        root.right = treeNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
