package cci.pra4;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 原文：

 Implement a function to check if a tree is balanced. For the purposes of this question,
 a balanced tree is defined to be a tree such that no two leaf nodes differ in distance from the root by more than one.

 译文：

 实现一个函数检查一棵树是否平衡。对于这个问题而言， 平衡指的是这棵树任意两个叶子结点到根结点的距离之差不大于1。
 */
public class cci4_1 {
  public boolean isBalance(TreeNode root){
    Stack<TreeNode> stack = new Stack<TreeNode>();
    Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
    map.put(root, 0);
    stack.add(root);
    while (!stack.isEmpty()){
      TreeNode tmp = stack.pop();
      while (tmp != null){
        int level = map.get(tmp.val);
        tmp = tmp.left;
        stack.push(tmp.left);
        map.put(tmp, level + 1);
      }
      tmp = stack.pop();
      if(tmp.right != null){
        map.put(tmp, map.get(tmp) + 1);
        tmp = tmp.right;
        stack.push(tmp);
      }
    }
    return true;
  }

  int d = 0;
  public void getDepth(TreeNode node){
    if(node == null) return ;
    d++;
    getDepth(node.left);
    if(node.left == null && node.right == null){

    }
  }
}
