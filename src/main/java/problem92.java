/**
 * Created by Administrator on 15-10-7.
 */
public class problem92 {
  public static void main(String[] args){
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    node1.next = node2;
    node2.next = node3;
    int m = 1;
    int n = 2;
    ListNode node = new problem92().reverseBetween(node1, m, n);
    while(node != null){
      System.out.print(node.val + "->");
      node = node.next;
    }
  }
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if(head == null || head.next == null) return head;

    ListNode mPre = head;
    ListNode nullNode = new ListNode(0);
    nullNode.next = head;
    ListNode tmpHead = nullNode;
    ListNode nPre = null;
    int k = 0;
    while(tmpHead != null){
      if(k + 1 == m){
        ListNode node = tmpHead;
        mPre= node;
      }
      if(k > m && k <= n){
        ListNode node = tmpHead;
        nPre.next = node.next;
        node.next = mPre.next;
        mPre.next = node;
        k++;
        tmpHead = nPre.next;
        continue;
      }else if(k > n){
        break;
      }
      k++;
      ListNode node = tmpHead;
      nPre = node;
      tmpHead = tmpHead.next;
    }
    return nullNode.next;
  }
}
