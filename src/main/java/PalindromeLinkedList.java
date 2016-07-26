import java.util.Stack;

/**
 * Created by Administrator on 15-7-14.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode tmpNode = head;
        while(tmpNode != null){
            stack.push(tmpNode);
            tmpNode = tmpNode.next;
        }
        while(head != null){
            ListNode tmp = stack.pop();
            if(tmp.val != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
