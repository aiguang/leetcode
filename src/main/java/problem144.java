import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,2,3].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class problem144 {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if(root == null) return result;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.add(root);
    while (!stack.empty()){
      TreeNode node = stack.pop();
      result.add(node.val);
      if(node.right != null){
        stack.add(node.right);
      }
      if(node.left != null){
        stack.add(node.left);
      }
    }
    return result;
  }
}
