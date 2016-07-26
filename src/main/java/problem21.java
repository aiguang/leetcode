/**
 * Created by Administrator on 15-8-17.
 */
public class problem21 {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;

    ListNode tmp1 = l1;
    ListNode tmp2 = l2;
    ListNode result = new ListNode(0);
    ListNode tmpResult = result;
    while (tmp1 != null && tmp2 != null){
      if(tmp1.val < tmp2.val){
        tmpResult.next = new ListNode(tmp1.val);
        tmp1 = tmp1.next;
      }else{
        tmpResult.next = new ListNode(tmp2.val);
        tmp2 = tmp2.next;
      }
      tmpResult = tmpResult.next;
    }
    if(tmp1 != null){
      tmpResult.next = tmp1;
    }
    if(tmp2 != null){
      tmpResult.next = tmp2;
    }
    return result.next;
  }
}
