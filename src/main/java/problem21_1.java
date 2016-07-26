/**
 * Created by Administrator on 16-4-27.
 */
public class problem21_1 {
  public Node merge(Node head1, Node head2){
    if(head1 == null) return head2;
    if(head2 == null) return head1;
    Node dummy = new Node(0);
    Node h = dummy;

    while (head1 != null && head2 != null){
      if(head1.data < head2.data){
        h.next = new Node(head1.data);
        head1 = head1.next;
      }else{
        h.next = new Node(head2.data);
        head2 = head2.next;
      }
      h = h.next;
    }
    if(head1 != null){
      h.next = head1;
    }
    if(head2 != null){
      h.next = head2;
    }
    return dummy.next;
  }
}

class Node{
  public int data;
  public Node next;
  public Node(int data){
    this.data = data;
  }

}
