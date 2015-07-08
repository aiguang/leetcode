/**
 * Created by Administrator on 15-6-26.
 */
public class RemoveLinkedListNode {
    public static void main(String[] args){
        RemoveLinkedListNode removeLinkedListNode = new RemoveLinkedListNode();
        ListNode node = removeLinkedListNode.test();
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    public ListNode test(){
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        return removeElements(node1 , 4);
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode node = head;
        ListNode nextNode;
        while(node != null && node.next != null ){
            nextNode = node.next;
            if(nextNode.val == val){
                node.next = nextNode.next;
            }else{
                node = node.next;
            }

        }
        ListNode tail = head.next;
        if(head.val == val){
            head = null;
        }
        if(tail.val == val){
            tail = null;
        }
        return  head == null ? tail : head;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
