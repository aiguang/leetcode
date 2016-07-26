import java.util.ArrayList;
import java.util.List;

/**
 Given a binary tree and a sum, find all root-to-leaf
 paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class problem113 {
  public static void main(String[] args){
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(-2);
    TreeNode node3 = new TreeNode(3);

    node1.left = node2;
    node2.right = node3;

    List<List<Integer>> result = new problem113().pathSum(node1, 2);
    for(List<Integer> list : result){
      for(Integer value : list){
        System.out.print(value + ",");
      }
      System.out.println();
    }
  }
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(root == null) return result;
    helper(new ArrayList<Integer>(), result, root, sum);
    return result;
  }
  private void helper(List<Integer> current, List<List<Integer>> result,TreeNode currentNode,
                      int target){
    if(currentNode.left == null && currentNode.right == null){
      int total = 0;
      current.add(currentNode.val);
      for(int value : current){
        total += value;
      }
      if(total == target){
        List<Integer> tmp = new ArrayList<Integer>();
        for(int value : current){
          tmp.add(value);
        }
        result.add(tmp);
      }
      return;
    }
    current.add(currentNode.val);
    if(currentNode.left != null){
      helper(current, result, currentNode.left, target);
      current.remove(current.size() - 1);
    }
    if(currentNode.right != null){
      helper(current, result, currentNode.right, target);
      current.remove(current.size() - 1);
    }
  }
}
