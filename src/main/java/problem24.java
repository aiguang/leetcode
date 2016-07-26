/**
 * Created by Administrator on 15-8-18.
 */
public class problem24 {
  public static void  main(String[] args){
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    ListNode head = new problem24().swapPairs(node1);
    while(head!= null){
      System.out.print(head.val + "->");
      head = head.next;
    }
  }
  public ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode tmpNode = head;
    ListNode prevNode = new ListNode(0);
    prevNode.next = head;
    ListNode tmpPrev = prevNode;
    while(tmpNode != null){
      ListNode next = tmpNode.next;

      if(next != null){
        tmpPrev.next = next;
        tmpNode.next = next.next;
        next.next = tmpNode;

        tmpPrev = tmpNode;
        tmpNode = tmpNode.next;
      }else{
        break;
      }
    }
    return prevNode.next;
  }
}
