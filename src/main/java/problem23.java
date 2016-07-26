/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its
 * complexity.
 */
public class problem23 {

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    return helper(lists, 0, lists.length - 1);
  }

  private ListNode helper(ListNode[] lists, int l, int r) {
    if (l < r) {
      int m = (l + r) / 2;
      return merge(helper(lists, l, m), helper(lists, m + 1, r));
    }
    return lists[l];
  }

  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    dummy.next = l1;
    ListNode cur = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        l1 = l1.next;
      } else {
        ListNode next = l2.next;
        cur.next = l2;
        l2.next = l1;
        l2 = next;
      }
      cur = cur.next;
    }
    if (l2 != null) {
      cur.next = l2;
    }
    return dummy.next;
  }
}
