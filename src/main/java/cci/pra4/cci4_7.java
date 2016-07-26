package cci.pra4;

/**
 原文：

 You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
 Create an algorithm to decide if T2 is a subtree of T1

 译文：

 有两棵很大的二叉树：T1有上百万个结点，T2有上百个结点。写程序判断T2是否为T1的子树。
 */
public class cci4_7 {
  public boolean isSubTree(TreeNode t1, TreeNode t2){
    if(t1 == null || t2 == null) return true;
    if(isEqual(t1, t2)){
      return isSubTree(t1.left, t2.left) && isSubTree(t1.right, t2.right);
    }
    return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
  }
  private boolean isEqual(TreeNode t1, TreeNode t2){
    return t1.val == t2.val;
  }



}
