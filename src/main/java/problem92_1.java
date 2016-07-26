/**
 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.
 */
public class problem92_1 {
  public static void main(String[] args){
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    node1.next = node2;
    node2.next = node3;
    int m = 1;
    int n = 2;
    ListNode node = new problem92_1().reverseBetween(node1, m, n);
    while(node != null){
      System.out.print(node.val + "->");
      node = node.next;
    }
  }
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if(head == null || head.next == null || m == n) return head;
    int count = 0;
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode tmp = dummy;
    ListNode last = null;
    ListNode pre = null;
    while (head != null){
      if(pre != null && last != null) break;
      if(count + 1 == m){
        ListNode t = tmp;
        pre = t;
      }
      if (count == n){
        ListNode q = head;
        last = q;
      }
      head = head.next;
      tmp = tmp.next;
      count++;
    }
    if(pre == null || last == null) return dummy.next;
    ListNode t = reverse(pre, last);
    t.next = head;
    return dummy.next;
  }
  public ListNode reverse(ListNode pre, ListNode last){
    ListNode r = pre.next;
    ListNode cur = pre.next;
    ListNode next = cur.next;
    while(cur != last){
      ListNode t = next.next;
      next.next = cur;
      cur = next;
      next = t;
    }
    pre.next = cur;
    return r;
  }
}
