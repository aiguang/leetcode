/**
 * Created by Administrator on 15-8-17.
 */
public class problem19 {
  public static void main(String[] args){
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    node1.next = node2;
    int n = 1;
    ListNode node = new problem19().removeNthFromEnd(node1, 1);
    while(node != null){
      System.out.print(node.val + "->");
      node = node.next;
    }
  }
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null) return head;
    int length = 0;
    ListNode tmp = head;
    while (tmp != null){
      tmp = tmp.next;
      length++;
    }
    int removeIndex = length - n + 1;
    if(removeIndex == 1) return head.next;
    tmp = head;
    int index = 1;
    while(index < length){
      if(index + 1 == removeIndex){
        if(index + 1 != length){
          tmp.next = tmp.next.next;
        }else{
          tmp.next = null;
        }
        break;
      }
      index++;
      tmp = tmp.next;
    }
    return head;
  }
}
