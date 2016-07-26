/**
 * Created by Administrator on 16-3-7.
 */
public class problem143_1 {

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
