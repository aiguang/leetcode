import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-10-7.
 */
public class problem94 {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    inOrder(root, result);
    return result;
  }
  public void inOrder(TreeNode node, List<Integer> list){
    if(node == null ) return;
    inOrder(node.left, list);
    list.add(node.val);
    inOrder(node.right, list);
  }
}
