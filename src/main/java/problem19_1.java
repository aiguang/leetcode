/**
 * Created by Administrator on 16-5-3.
 */
public class problem19_1 {
  public static void main(String[] args){
    ListNode head = new ListNode(1);
    ListNode t = new ListNode(2);
//    head.next = t;

    new problem19_1().removeNthFromEnd(head, 1);
  }
  public ListNode removeNthFromEnd(ListNode head, int n){
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = dummy;
    while (fast.next != null){
      if(n <= 0) slow = slow.next;
      fast = fast.next;
      n--;
    }
    if(slow.next != null){
      slow.next = slow.next.next;
    }
    return dummy.next;
  }
}
