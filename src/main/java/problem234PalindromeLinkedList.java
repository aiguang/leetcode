/**
 * Created by Administrator on 16-6-26.
 */
public class problem234PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null) return true;
    ListNode slow = head;
    ListNode fast = head.next;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast= fast.next.next;
    }
    ListNode rNode = reverse(slow.next);
    slow.next = null;
    while(head != null && rNode != null){
      if(head.val != rNode.val) return false;
      head = head.next;
      rNode = rNode.next;
    }
    return true;
  }
  public ListNode reverse(ListNode node){
    if(node == null) return null;
    ListNode prev = null;
    while (node != null){
      ListNode next = node.next;
      node.next  = prev;
      prev = node;
      node = next;
    }
    return prev;
  }
}
