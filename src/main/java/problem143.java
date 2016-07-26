/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class problem143 {

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    ListNode node7 = new ListNode(7);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;

    new problem143().reorderList(node1);
    while (node1 != null) {
      System.out.print(node1.val + ",");
      node1 = node1.next;
    }
  }

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    ListNode fast = head.next;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    //reverse the second half
    ListNode p1 = slow.next;
    ListNode p2 = p1.next;
    ListNode temp = null;
    ListNode tail = p1;
    while (p2 != null) {
      temp = p2.next;
      p2.next = p1;
      p1 = p2;
      p2 = temp;
    }
    tail.next = null;
    slow.next = null;

    //merge the first half and reversed second half
    ListNode curr = head;
    while (curr != null && p1 != null) {
      temp = p1.next;
      p1.next = curr.next;
      curr.next = p1;
      curr = curr.next.next;
      p1 = temp;
    }
  }
}
