/**
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
public class problem61_1 {
  public static void main(String[] args){
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    ListNode head = new problem61_1().rotateRight(node1, 4);
    while (head != null){
      System.out.print(head.val + ",");
      head = head.next;
    }
  }

  public ListNode rotateRight(ListNode head, int k) {
    if(k <= 0 || head == null || head.next == null) return head;

    ListNode tmp = head;
    ListNode slow = head;
    ListNode fast = head;
    int count = 1;

    while (fast != null && fast.next != null){
      if(count <=  k){
        fast = fast.next;
      }else{
        slow = slow.next;
        fast = fast.next;
      }
      count++;
    }
    fast.next = tmp;
    ListNode r = slow.next;
    slow.next = null;
    return r;
  }
}
