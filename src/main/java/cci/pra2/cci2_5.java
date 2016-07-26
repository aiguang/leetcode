package cci.pra2;

/**
 原文：

 Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.

 DEFINITION

 Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node, so as to make a loop in the linked list.

 EXAMPLE

 Input: A -> B -> C -> D -> E -> C [the same C as earlier]

 Output: C

 译文：

 给定一个循环链表，实现一个算法返回这个环的开始结点。

 定义：

 循环链表：链表中一个结点的指针指向先前已经出现的结点，导致链表中出现环。

 例子：

 输入：A -> B -> C -> D -> E -> C [结点C在之前已经出现过]

 输出：结点C
 */
public class cci2_5 {
  public ListNode getCirclePoint(ListNode root){
    if(root == null) return null;
    ListNode first = root;
    ListNode second = root;
    while(first != null && second != null){
      if(first == second){
        break;
      }
      first = first.next;
      if(second.next != null){
        second = second.next.next;
      }
    }
    return first;
  }
}
