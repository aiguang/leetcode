import java.util.HashMap;
import java.util.Map;

/**
 Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */
public class problem106 {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if(inorder == null || postorder == null) return null;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i = 0; i < inorder.length;i++){
      map.put(inorder[i], i);
    }
    return help(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
  }
  private TreeNode help(int[] inOrder, int inL, int inR, int[] postOrder, int postL, int postR,
                    Map<Integer, Integer> map){
    if(inL > inR || postL > postR){
      return null;
    }
    TreeNode root = new TreeNode(postOrder[postR]);
    int index = map.get(root.val);
    int num = index - inL;
    root.left = help(inOrder, inL, index - 1, postOrder, postL, postL + num - 1, map);
    root.right = help(inOrder, index + 1, inR, postOrder, postL + num, postR - 1, map);
    return root;
  }
}
