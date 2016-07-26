/**
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class problem109 {

  public TreeNode sortedListToBST(ListNode head) {
    if(head == null) return null;
    ListNode node = head;
    int count = 0;
    while (node != null){
      count++;
      node = node.next;
    }
    int[] array = new int[count];
    node = head;
    int index = 0;
    while (node != null){
      array[index] = node.val;
      node = node.next;
      index++;
    }
    return helper(array, 0, array.length - 1);
  }
  public TreeNode helper(int[] array, int left, int right){
    if(left > right) return null;
    int mid = (left + right) / 2;
    TreeNode node = new TreeNode(array[mid]);
    node.left = helper(array, left, mid - 1);
    node.right = helper(array, mid + 1, right);
    return node;
  }
}
