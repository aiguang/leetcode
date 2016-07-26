package cci.pra4;

import java.util.Stack;

/**
 原文：

 Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.

 译文：

 写程序在一棵二叉树中找到两个结点的第一个共同祖先。不允许存储额外的结点。注意： 这里不特指二叉查找树。
 */
public class cci4_6 {
  public static void main(String[] args){
    System.out.println(String.valueOf((byte)192));
  }
  public TreeNode findLCA(TreeNode a, TreeNode b, TreeNode root, TreeNode result){

    while (isFather(root, a) && isFather(root, b)){
      result = root;
      findLCA(a, b,root.left, result);
      findLCA(a, b, root.right, result);
    }
    return result;
  }
  private boolean isFather(TreeNode father, TreeNode child){
    if(father == null) return false;
    if(father.left == child || father.right == child) return true;
    return isFather(father.left, child) || isFather(father.right, child);
  }
}
