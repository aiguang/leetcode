package cci.pra4;

/**
 原文：

 Write an algorithm to find the ‘next’ node (i.e., in-order successor) of a given node in a binary search tree
 where each node has a link to its parent.

 译文：

 给定二叉查找树的一个结点， 写一个算法查找它的“下一个”结点(即中序遍历后它的后继结点)， 其中每个结点都有指向其父亲的链接。
 */
public class cci4_5 {
  public TreeNodeWithParent findNext(TreeNodeWithParent node){
    if(node == null) return null;
    if(node.father == null){
      TreeNodeWithParent right = node.right;
      if(right == null) return null;
      while (right.left != null){
        right = right.left;
      }
      return right;
    }
    if(node.father.left == node) return node.father;
    TreeNodeWithParent grand = node.father.father;
    if(grand == null){
      TreeNodeWithParent right = node.right;
      if(right == null) return null;
      while (right.left != null){
        right = right.left;
      }
      return right;
    }else {
      while (grand.right == null){
        grand = grand.father;
      }
      TreeNodeWithParent right = grand.right;
      if(right == null) return null;
      while (right.left != null){
        right = right.left;
      }
      return right;
    }

  }
}
