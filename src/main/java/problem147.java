/**
 Sort a linked list using insertion sort.
 */
public class problem147 {
  public static void main(String[] args){
    ListNode node = new ListNode(4);
    ListNode node1 = new ListNode(5);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(0);
    ListNode node4 = new ListNode(9);
    ListNode node5 = new ListNode(1);
    ListNode node6 = new ListNode(41);
    ListNode node7 = new ListNode(24);

    node.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;

    ListNode result = new problem147().insertionSortList(node);
    while (result != null){
      System.out.print(result.val + ",");
      result = result.next;
    }
  }
  public ListNode insertionSortList(ListNode head) {
    if(head == null || head.next == null) return head;
    int count = 0;
    ListNode node = head;
    while (node != null){
      count++;
      node = node.next;
    }
    int[] array = new int[count];
    node = head;
    count = 0;
    while (node != null){
      array[count] = node.val;
      count++;
      node = node.next;
    }
    for(int i = 0;i < array.length;i++){
      for(int j = i + 1;j < array.length;j++){
        if(array[i] > array[j]){
          int tmp = array[i];
          array[i] = array[j];
          array[j] = tmp;
        }
      }
    }
    node = new ListNode(array[0]);
    ListNode t = node;
    for(int i = 1; i < array.length;i++){
      ListNode tmp = new ListNode(array[i]);
      t.next = tmp;
      t = t.next;
    }
    return node;
  }
}
