import com.sun.org.apache.regexp.internal.recompile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-3-1.
 */
public class problem101 {
  public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;
    int level = 1;
    List<TreeNode> list = new ArrayList<TreeNode>();
    list.add(root);
    while (!list.isEmpty()){
      List<TreeNode> tmp = new ArrayList<TreeNode>();
      for(int i = 0; i < list.size();i++){
        TreeNode tmpNode = list.get(i);
        tmp.add(tmpNode.left);
        tmp.add(tmpNode.right);
      }
      for(int i = 0; i < list.size();i++){
        TreeNode left = list.get(i);
        TreeNode right = list.get(list.size() - i - 1);
        if(left == null && right != null) return false;
        if(left != null && right == null) return false;
        if(left != null && right != null && left.val != right.val) return false;
      }
      list = tmp;
    }
    return true;
  }
}
