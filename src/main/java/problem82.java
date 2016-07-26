import com.sun.org.apache.regexp.internal.recompile;

/**
 * Created by Administrator on 15-9-9.
 *
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */
public class problem82 {
  public static void main(String[] args){
    ListNode node = new ListNode(1);
    ListNode node1 = new ListNode(2);
    ListNode node2 = new ListNode(3);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(4);
    ListNode node6 = new ListNode(5);

    node.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;

    ListNode result = new problem82().deleteDuplicates(node);
    while (result != null){
      System.out.print(result.val + ",");
      result = result.next;
    }
    System.out.println();
  }
  public ListNode deleteDuplicates(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode node = head;
    ListNode preNode = new ListNode(0);
    ListNode tmpNode = preNode;
    preNode.next = head;
    int total = 1;
    while(node.next != null){
      if(node.val == node.next.val){
        total++;
      }else {
        if(total > 1){
          tmpNode.next = node.next;
          total = 1;
        }else{
          tmpNode = node;
        }
      }
      node = node.next;
    }
    if(total > 1){
      tmpNode.next = null;
    }
    return preNode.next;
  }
}
