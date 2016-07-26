import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [3,2,1].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class problem145 {
  public static void main(String[] args){
    TreeNode node0 = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);

    node1.left = node0;
    node1.right = node2;

    List<Integer> result = new problem145().postorderTraversal(node1);
    for(int i = 0 ; i < result.size() ;i++){
      System.out.print(result.get(i) + ",");
    }
  }
  public List<Integer> postorderTraversal(TreeNode root) {
    if(root == null) return new ArrayList<Integer>();
    List<Integer> result = new ArrayList<Integer>();
    visit(result, root);
    return result;
  }
  public void visit(List<Integer> result, TreeNode node){
    if(node.left != null){
      visit(result, node.left);
    }
    if(node.right != null){
      visit(result, node.right);
    }
    result.add(node.val);
  }

}
