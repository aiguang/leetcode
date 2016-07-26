/**
 * Created by Administrator on 15-7-15.
 *
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 the linked list should become 1 -> 2 -> 4 after calling your function.

 取巧的办法，将当前节点的指针指向下下个节点，这时候相当于链表不连续。

 */
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        if(node == null) return;
        if(node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
