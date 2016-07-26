import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-3-1.
 */
public class problem103_1 {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(root == null) return result;
    List<TreeNode> list = new ArrayList<TreeNode>();
    List<TreeNode> nextList = new ArrayList<TreeNode>();

    list.add(root);
    boolean leftToRight = true;

    while (!list.isEmpty()){
      List<Integer> tmpList = new ArrayList<Integer>();
      for(int i = 0; i < list.size();i++){
        if(leftToRight) tmpList.add(list.get(i).val);
        else tmpList.add(list.get(list.size() - 1 - i).val);
      }
      result.add(tmpList);
      
    }
    return null;
  }
}
