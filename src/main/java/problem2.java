/**
 * Created by Administrator on 15-8-12. You are given two linked lists representing two non-negative
 * numbers. The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */
public class problem2 {

  public static void main(String[] args) {
    ListNode node1 = new ListNode(2);
    node1.next = new ListNode(4);
    node1.next.next = new ListNode(5);

    ListNode node2 = new ListNode(5);
    node2.next = new ListNode(6);
    node2.next.next = new ListNode(5);

    ListNode result = new problem2().addTwoNumbers(node1, node2);
    while(result != null){
      System.out.print(result.val + ",");
      result = result.next;
    }
    System.out.println();
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) {
      return null;
    }
    int l1Length = 0, l2Length = 0;
    ListNode tmpNode = l1;
    while (tmpNode != null) {
      l1Length++;
      tmpNode = tmpNode.next;
    }
    tmpNode = l2;
    while (tmpNode != null) {
      l2Length++;
      tmpNode = tmpNode.next;
    }
    int step = 0;
    int index = 0;
    int length = l1Length < l2Length ? l1Length : l2Length;
    ListNode l1Head = l1;
    ListNode l2Head = l2;
    ListNode node = new ListNode(0);
    ListNode nodeHead = node;
    while (index < length) {
      int value = l1Head.val + l2Head.val;
      ListNode currentNode = new ListNode((value + step) % 10);
      step = (value + step) / 10;
      nodeHead.next = currentNode;
      nodeHead = nodeHead.next;
      l1Head = l1Head.next;
      l2Head = l2Head.next;
      index++;
    }
    tmpNode = l1Length < l2Length ? l2Head : l1Head;
    while (tmpNode != null) {
      ListNode currentNode = new ListNode((tmpNode.val + step) % 10);
      step = (tmpNode.val + step) / 10;
      nodeHead.next = currentNode;
      nodeHead = nodeHead.next;
      tmpNode = tmpNode.next;
    }
    if(step > 0){
      nodeHead.next = new ListNode(step);
    }
    return node.next;
  }
}
