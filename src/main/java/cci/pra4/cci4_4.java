package cci.pra4;

import java.util.ArrayList;
import java.util.List;

import cci.pra2.ListNode;

/**
 原文：

 Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth
 (i.e., if you have a tree with depth D, you’ll have D linked lists).

 译文：

 给定一棵二叉查找树，设计算法，将每一层的所有结点构建为一个链表(也就是说， 如果树有D层，那么你将构建出D个链表)
 */
public class cci4_4 {
  public List<List<TreeNode>> createList(TreeNode node){
    List<List<TreeNode>> result = new ArrayList<List<TreeNode>>();
    if(node == null) return null;
    List<TreeNode> tmp = new ArrayList<TreeNode>();
    tmp.add(node);
    result.add(tmp);
    while (!tmp.isEmpty()){
      List<TreeNode> t = new ArrayList<TreeNode>();
      for(int i = 0; i < tmp.size();i++){
        TreeNode n = tmp.get(i);
        if(n.left != null) t.add(n.left);
        if(n.right != null) t.add(n.right);
      }
      result.add(t);
      t = tmp;
    }
    return result;
  }
}
