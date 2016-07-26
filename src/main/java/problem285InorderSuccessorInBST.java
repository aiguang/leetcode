import java.util.LinkedList;
import java.util.Stack;

/**
 Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

 Note: If the given node has no in-order successor in the tree, return null.
 */
public class problem285InorderSuccessorInBST {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if(root == null || p == null) return null;
    //找到root到p的路径，如果p有右节点，那么则找到右节点的最左子树为他的下一个，中序是有序的，往上找到下一个比他大的
    Stack<TreeNode> stack = new Stack<TreeNode>();
    while (root != null && root != p){
      stack.push(root);
      if(root.val > p.val){
        root = root.left;
      }else{
        root = root.right;
      }
    }
    if(root == null) return null;
    if(p.right != null){
      TreeNode tmp = p.right;
      while (tmp.left != null){
        tmp = tmp.left;
      }
      return tmp;
    }else{
      while (!stack.isEmpty() && stack.peek().val < p.val){
        stack.pop();
      }
      if(stack.isEmpty()) return null;
      return stack.pop();
    }
  }
}
