import sun.print.resources.serviceui_pt_BR;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class problem148 {
//  1 Use 2 pointers: fast and slow to divide the list into 2 sublist: list1 and list2 and make sure list1 is equal to or is longer than list2.
//  The key is the condition of while loop while(fast.next!=null && fast.next.next!=null). After this while loop slow will be at the position of the end of list1.
//  2 sort list1 and list2
//  3 merge list1 and list2
  public ListNode sortList(ListNode head){
    if(head == null || head.next == null) return head;
    ListNode h1 = head;
    ListNode fast = head.next.next;
    ListNode slow = head.next;
    while (fast != null && fast.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode h2 = slow.next;
    slow.next = null;
    h1 = sortList(h1);
    h2 = sortList(h2);
    return merge(h1, h2);
  }
  public ListNode merge(ListNode h1, ListNode h2){
    ListNode fakeHead = new ListNode(9);
    ListNode cur = fakeHead;
    while (h1 != null && h2 != null) {
      if (h1.val < h2.val) {
        cur.next = h1;
        cur = h1;
        h1 = h1.next;
      } else {
        cur.next = h2;
        cur = h2;
        h2 = h2.next;
      }
    }
    cur.next = h1 == null ? h2 : h1;
    return fakeHead.next;
  }
}
