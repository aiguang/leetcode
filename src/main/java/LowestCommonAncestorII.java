import java.util.Stack;

/**
 * Created by Administrator on 15-7-14.
 */
public class LowestCommonAncestorII {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null){
            return null;
        }
        if(p.val == root.val || q.val == root.val){
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p , q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p , q);
        if(leftNode != null && rightNode != null){
            return root;
        }
        return leftNode == null ? rightNode : leftNode;
    }
}
