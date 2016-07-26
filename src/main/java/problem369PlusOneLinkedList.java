/**
 Given a non-negative number represented as a singly linked list of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.

 Example:
 Input:
 1->2->3

 Output:
 1->2->4
 */
public class problem369PlusOneLinkedList {
  class Pair{
    ListNode node;
    int step;
    Pair(ListNode node, int step){
      this.node = node;
      this.step = step;
    }
  }
  public ListNode plusOne(ListNode head) {
    if(head == null) return head;
    Pair p = helper(head);
    if(p.step == 0) return p.node;
    ListNode n = new ListNode(p.step);
    n.next = head;
    return n;
  }
  public Pair helper(ListNode node){
    if(node.next == null){
      int r = node.val + 1;
      node.val = r % 10;
      Pair p = new Pair(node, r / 10);
      return p;
    }
    Pair pair = helper(node.next);
    node.next = pair.node;
    int r = node.val + pair.step;
    node.val = r % 10;
    Pair result = new Pair(node, r / 10);
    return result;
  }
}
