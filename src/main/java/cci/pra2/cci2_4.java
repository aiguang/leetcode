package cci.pra2;

import com.sun.java.swing.plaf.windows.resources.windows_zh_HK;

/**
 原文：

 You have two numbers represented by a linked list, where each node contains a single digit.
 The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
 Write a function that adds the two numbers and returns the sum as a linked list.

 EXAMPLE

 Input: (3 -> 1 -> 5), (5 -> 9 -> 2)

 Output: 8 -> 0 -> 8

 译文：

 你有两个由单链表表示的数。每个结点代表其中的一位数字。数字的存储是逆序的，
 也就是说个位位于链表的表头。写一函数使这两个数相加并返回结果，结果也由链表表示。

 例子：(3 -> 1 -> 5), (5 -> 9 -> 2)

 输入：8 -> 0 -> 8
 */
public class cci2_4 {
  public ListNode calculate(ListNode p, ListNode q){
    if(p == null) return q;
    if(q == null) return p;

    ListNode node = new ListNode(0);
    int step = 0;
    while (p != null && q  != null){
      int tmp = p.val + q.val + step;
      ListNode n = new ListNode(tmp % 10);
      step = tmp / 10;
      node.next = n;
      node = node.next;
      p = p.next;
      q = q.next;
    }
    ListNode d = p == null ? q : p;
    while (d != null){
      int tmp = d.val + step;
      ListNode n = new ListNode(tmp % 10);
      step = tmp / 10;
      node.next = n;
      node = node.next;
      d = d.next;
    }
    return node;
  }
}
