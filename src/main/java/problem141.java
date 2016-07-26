/**
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */
public class problem141 {
  public boolean hasCycle(ListNode head) {
    if(head == null || head.next == null) return false;
    ListNode oneStep = head;
    ListNode twoStep = head.next.next;
    while (oneStep != null && twoStep != null){
      if(oneStep.val == twoStep.val) return true;
      if(twoStep.next == null) return false;
      oneStep = oneStep.next;
      twoStep = twoStep.next.next;
    }
    return false;
  }
}
