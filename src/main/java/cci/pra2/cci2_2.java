package cci.pra2;

/**
 原文：

 Implement an algorithm to find the nth to last element of a singly linked list.

 译文：

 实现一个算法从一个单链表中返回倒数第n个元素。
 */
public class cci2_2 {
  public ListNode getTailN(ListNode root, int n){
    int index = 0;
    ListNode tmp = null;
    while (root != null){
      if(index < n){
        index++;
      }else if(index == n){
        tmp = root;
      }else{
        tmp = tmp.next;
      }
      root = root.next;
    }
    return tmp;
  }

}
