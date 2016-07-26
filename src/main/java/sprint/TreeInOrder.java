package sprint;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 16-5-4.
 */
public class TreeInOrder {

  public List<Integer> inorderTraversal(TreeNode root) {
    if(root == null) return new ArrayList<Integer>();

    List<Integer> result = new ArrayList<Integer>();
    TreeNode p = root;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    while (p != null || !stack.isEmpty()){
      while (p != null){
        stack.add(p);
        p = p.left;
      }
      if(!stack.isEmpty()){
        p = stack.pop();
        result.add(p.val);
        p = p.right;
      }
    }
    return result;
  }


  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
