/**
 * Created by Administrator on 15-9-10.
 *
 *
 *
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class problem86 {
  public static void main(String[] args){
    ListNode node = new ListNode(4);
    ListNode node1 = new ListNode(1);
//    ListNode node2 = new ListNode(3);
//    ListNode node3 = new ListNode(2);
//    ListNode node4 = new ListNode(5);
//    ListNode node5 = new ListNode(2);
//    ListNode node6 = new ListNode(5);

    node.next = node1;
//    node1.next = node2;
//    node2.next = node3;
//    node3.next = node4;
//    node4.next = node5;
//    node5.next = node6;

    ListNode result = new problem86().partition(node, 4);
    while (result != null){
      System.out.print(result.val + ",");
      result = result.next;
    }
    System.out.println();
  }
  public ListNode partition(ListNode head, int x) {
    if(head == null) return head;
    ListNode lDummy = new ListNode(-1);
    ListNode lTmp = lDummy;
    ListNode hDummy = new ListNode(-1);
    ListNode hTemp = hDummy;
    while (head != null){
      if(head.val < x){
        ListNode t = head;
        lTmp.next = t;
        head = head.next;
        t.next = null;
        lTmp = lTmp.next;
      }else{
        ListNode t = head;
        hTemp.next = t;
        head = head.next;
        t.next = null;
        hTemp = hTemp.next;
      }
    }
    if(hDummy.next != null){
      lTmp.next = hDummy.next;
    }
    return lDummy.next;
  }
}
