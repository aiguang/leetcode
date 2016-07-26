import java.util.ArrayList;
import java.util.List;

/**
 Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

    1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class problem257 {
  public static void main(String[] args){
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);

    node1.left = node2;
    List<String> result = new problem257().binaryTreePaths(node1);
    for(String value : result){
      System.out.print(value + ",");
    }

  }
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<String>();
    if(root == null) return result;
    if(root.left == null && root.right == null){
      result.add(root.val + "");
      return result;
    }
    helper(root.left, result, root.val + "");
    helper(root.right, result, root.val + "");
    return result;
  }
  private void helper(TreeNode curNode, List<String> result, String curString){
    if(curNode == null){
      return;
    }
    if(curNode.left == null && curNode.right == null){
      curString = curString + "->" + curNode.val;
      result.add(curString);
      return;
    }
    curString = curString + "->" + curNode.val;
    helper(curNode.left, result, curString);
    helper(curNode.right, result, curString);
  }
}
