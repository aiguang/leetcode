import java.util.ArrayList;
import java.util.List;

/**
 Given a binary tree, return the zigzag level order traversal of its nodes' values.
 (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9   20
  /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 */
public class problem103 {
  public static void main(String[] args){
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(9);
    TreeNode node3 = new TreeNode(20);
    TreeNode node4 = new TreeNode(15);
    TreeNode node5 = new TreeNode(7);

    node1.left = node2;
    node1.right = node3;

    node2.left = node4;
    node2.right = node5;

    List<List<Integer>> result = new problem103().zigzagLevelOrder(node1);
    for(List<Integer> list : result){
      for(Integer value : list){
        System.out.print(value + ",");
      }
      System.out.println();
    }

  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(root == null) return result;
    helper(result, root);
    return result;
  }
  private void helper(List<List<Integer>> result, TreeNode root){
    List<TreeNode> list = new ArrayList<TreeNode>();
    list.add(root);

    boolean leftToRight = true;
    while (!list.isEmpty()){
      List<TreeNode> tmp = list;
      List<Integer> value = new ArrayList<Integer>();
      List<TreeNode> nextList = new ArrayList<TreeNode>();

      for(int i = 0; i < tmp.size();i++){
        int visit = leftToRight ? tmp.get(i).val : tmp.get(tmp.size() - i - 1).val;
        value.add(visit);
        TreeNode node = tmp.get(i);
        if(node.left != null){
          nextList.add(node.left);
        }
        if(node.right != null){
          nextList.add(node.right);
        }
      }
      if(!value.isEmpty()){
        result.add(value);
      }
      leftToRight = !leftToRight;
      list = nextList;
    }
  }
}
