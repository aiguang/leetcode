/**
 * Created by Administrator on 15-6-25.
 */
public class ReverseLinkedList {
    public static void main(String[] args){
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.test();
    }

    public void test(){
        ListNode head = new ListNode(1);
        ListNode middle = new ListNode(2);
        ListNode tail = new ListNode(3);
        head.next = middle;
        middle.next = tail  ;
//        head = reverseList(head);
        head = reverse2(head);
        while(head != null){


            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        ListNode tailNode = new ListNode(currentNode.val);

        while (head != null && head.next != null){
            ListNode node = new ListNode(head.val);

            ListNode tmp = tailNode.next;
            tailNode.next = node;
            node.next = tmp;

            head = head.next;
        }
        return tailNode;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){this.val = x;}
    }

    ListNode reverse2(ListNode head){
        ListNode first = null;
        ListNode tail = head;
        while (tail != null) {
            ListNode tmp = tail;
            tail = tail.next;
            tmp.next = first;
            first = tmp;
        }
        return first;
    }
}
