import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

/**
 Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class problem107 {
  public static void main(String[] args){
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);

    node1.left = node2;
    node1.right = node3;
    node2.left = node4;
    node2.right = node5;
    node3.right = node7;

    new problem107().levelOrderBottom(node1);
  }
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(root == null) return result;
    List<List<TreeNode>> nodeList = new ArrayList<List<TreeNode>>();
    List<TreeNode> list = new ArrayList<TreeNode>();
    list.add(root);
    nodeList.add(list);

    while (true){
      ListIterator<TreeNode> iter = list.listIterator();
      List<TreeNode> ot = new ArrayList<TreeNode>();
      while (iter.hasNext()){
        TreeNode tmp = iter.next();
        if(tmp.left != null) ot.add(tmp.left);
        if(tmp.right != null) ot.add(tmp.right);
      }
      if(ot.isEmpty()) break;
      nodeList.add(ot);
      list = ot;
    }
    for(int i = nodeList.size() - 1;i >= 0;i--){
      List<TreeNode> tmpList = nodeList.get(i);
      List<Integer> l = new ArrayList<Integer>();
      for(int j = 0; j < tmpList.size();j++){
        l.add(tmpList.get(j).val);
      }
      result.add(l);
    }
    return result;
  }
}
