package cci.pra4;

import org.omg.DynamicAny._DynArrayStub;

/**
 原文：

 Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.

 译文：

 给定一个有序数组(递增)，写程序构建一棵具有最小高度的二叉树。
 */
public class cci4_3 {
  public TreeNode create(int[] array){
    if(array == null || array.length == 0) return null;
    return helper(0, array.length, array);
  }
  private TreeNode helper(int start, int end, int[] array){
    if(start <= end && start >= 0 && end < array.length){
      TreeNode node = new TreeNode(array[start + (end - start) / 2]);
      node.left = helper(start, (start + end) /2 - 1 , array);
      node.right = helper((start + end) + 1 / 2, end, array);
    }
    return null;

  }

}
