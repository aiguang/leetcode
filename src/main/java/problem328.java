/**
 Given a singly linked list, group all odd nodes together followed by the even nodes.
 Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example:
 Given 1->2->3->4->5->NULL,
 return 1->3->5->2->4->NULL.

 Note:
 The relative order inside both the even and odd groups should remain as it was in the input.
 The first node is considered odd, the second node even and so on ...
 */
public class problem328 {
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

    ListNode head = new problem328().oddEvenList(node1);
    while(head!= null){
      System.out.print(head.val + "->");
      head = head.next;
    }
  }
  public ListNode oddEvenList(ListNode head) {
    if(head == null || head.next == null) return head;

    ListNode last = head;
    ListNode firstOdd = head.next.next;
    while(firstOdd != null){
      ListNode firstEven = last.next;
      firstEven.next = firstOdd.next;
      firstOdd.next = firstEven;
      last.next = firstOdd;

      last = last.next;
      if(firstEven.next != null){
        firstOdd = firstEven.next.next;
      }else break;

    }
    return head;
  }
}
