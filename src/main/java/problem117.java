/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 *
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 *
 * You may only use constant extra space. For example, Given the following binary tree, 1 /  \ 2
 * 3 / \    \ 4   5    7 After calling your function, the tree should look like: 1 -> NULL /  \ 2 ->
 * 3 -> NULL / \    \ 4-> 5 -> 7 -> NULL
 */
public class problem117 {

  public static void main(String[] args) {
    TreeLinkNode node1 = new TreeLinkNode(1);
    TreeLinkNode node2 = new TreeLinkNode(2);
    TreeLinkNode node3 = new TreeLinkNode(3);
    TreeLinkNode node4 = new TreeLinkNode(4);
    TreeLinkNode node5 = new TreeLinkNode(5);
    TreeLinkNode node6 = new TreeLinkNode(6);
    TreeLinkNode node7 = new TreeLinkNode(7);

    node1.left = node2;
    node1.right = node3;
    node2.left = node4;
    node2.right = node5;
    node3.right = node7;

    new problem117().connect(node1);

  }

  public void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    TreeLinkNode lastHead = root;
    TreeLinkNode pre = null;
    TreeLinkNode curHead = null;
    while (lastHead != null) {
      TreeLinkNode lastCur = lastHead;
      while (lastCur != null) {
        if (lastCur.left != null) {
          if (curHead == null) {
            curHead = lastCur.left;
            pre = curHead;
          } else {
            pre.next = lastCur.left;
            pre = pre.next;
          }
        }
        if (lastCur.right != null) {
          if (curHead == null) {
            curHead = lastCur.right;
            pre = curHead;
          } else {
            pre.next = lastCur.right;
            pre = pre.next;
          }
        }
        lastCur = lastCur.next;
      }
      lastHead = curHead;
      curHead = null;
    }
  }
}
