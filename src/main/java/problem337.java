import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 The thief has found himself a new place for his thievery again.
 There is only one entrance to this area, called the "root."
 Besides the root, each house has one and only one parent house.
 After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 It will automatically contact the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:
  3
 / \
 2   3
  \   \
   3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 Example 2:
    3
   / \
  4   5
 / \   \
 1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class problem337 {
  public int rob(TreeNode root) {
    if(root == null) return 0;
    List<Integer> left = new ArrayList<Integer>();
    List<Integer> right = new ArrayList<Integer>();
    helper(left, root);
    helper(right,root);

    Collections.sort(left);
    Collections.sort(right);
    return left.get(left.size() - 1) + right.get(right.size() - 1);
  }
  private void helper(List<Integer> list, TreeNode curNode){
    if(curNode == null) return;
    if(list.size() == 0){
      list.add(curNode.val);
    }else if(list.size() == 1){
      if (curNode.val > list.get(0)) {
        list.add(curNode.val);
      } else {
        list.add(list.get(0));
      }
    }else{
      int v = list.get(list.size() - 2) + curNode.val > list.get(list.size() - 1) ? list.size() - 2 + curNode.val:
      list.get(list.size() - 1);
      list.add(v);
    }
  }

}
