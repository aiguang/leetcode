/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified
 * list.
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it
 * is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example, Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 */
public class problem25 {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
//    ListNode next = new ListNode(2);
//    head.next = next;
    ListNode n = new problem25().reverseKGroup(head, 1);
    while (n != null) {
      System.out.print(n + "->");
      n = n.next;
    }
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    if (k <= 1) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode n1 = dummy;
    ListNode n2 = n1.next;
    ListNode n3;

    while (n2 != null) {
      for (int i = 1; i < k; i++) {
        if (n2.next != null) {
          n2 = n2.next;
        } else {
          return dummy.next;
        }
      }
      n3 = n2.next;
      n1 = reverse(n1, n2);
      n2 = n3;
    }

    return dummy.next;
  }

  private ListNode reverse(ListNode head, ListNode tail) {
    ListNode ret = head.next;
    while (head.next != tail) {
      ListNode n1 = head.next;
      head.next = n1.next;
      n1.next = tail.next;
      tail.next = n1;
    }

    return ret;
  }

}
