package cci.pra2;

/**
 原文：

 Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.

 EXAMPLE

 Input: the node ‘c’ from the linked list a->b->c->d->e Result: nothing is returned, but the new linked list looks like a->b->d->e

 译文：

 实现一个算法来删除单链表中间的一个结点，只给出指向那个结点的指针。

 例子：

 输入：指向链表a->b->c->d->e中结点c的指针

 结果：不需要返回什么，得到一个新链表：a->b->d->e
 */
public class cci2_3 {
  public void deleteNode(ListNode tobeDel){
    if(tobeDel == null) return;
    if(tobeDel.next != null){
      tobeDel.val = tobeDel.next.val;
      tobeDel.next = tobeDel.next.next;
    }else {
      tobeDel = null;
    }
  }

}
