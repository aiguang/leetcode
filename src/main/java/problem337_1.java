import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 16-4-26.
 */
public class problem337_1 {
  private Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
  public int rob(TreeNode root) {
    if(root == null) return 0;
    return helper(root);
  }
  public int helper(TreeNode node){
    if(node == null) return 0;
    if(map.containsKey(node)) return map.get(node);
    int l = 0;
    if(node.left != null){
      l = helper(node.left.left) + helper(node.left.right);
    }
    int r = 0;
    if(node.right != null){
      r = helper(node.right.left) + helper(node.right.right);
    }
    int result =  Math.max(node.val + l + r, helper(node.left) + helper(node.right));
    map.put(node, result);
    return result;
  }
}
