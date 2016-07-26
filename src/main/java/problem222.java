/**
 * Given a complete binary tree, count the number of nodes.
 *
 * Definition of a complete binary tree from Wikipedia: In a complete binary tree every level,
 * except possibly the last, is completely filled, and all nodes in the last level are as far left
 * as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 *
 * 解法I：二分枚举 高度为h的完全二叉树，其节点个数等于高度为h-1的满二叉树的节点个数 + 最后一层的节点个数。
 *
 * 因此，只需要二分枚举第h层的节点个数即可。
 *
 * 将第h层的节点从0至2^h - 1依次编号（根节点的层数记为0）
 *
 * 若用0表示左孩子，1表示右孩子，则这些编号的二进制形式是从根节点出发到叶子节点的“路径”。
 *
 * 例如高度为2，包含6个节点的完全二叉树：
 *
 * Lv0        1 /    \ Lv1     2      3 /  \   /  \ Lv2    4   5  6   -
 *
 * No.   00  01 10 从1号节点（根节点）出发，到第5号节点的路径为01（左右），同时该节点为第2层的第2个节点。
 */
public class problem222 {
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = 1, rightHeight = 1;
    TreeNode temp = root.left;
    while (temp != null) {
      temp = temp.left;
      leftHeight++;
    }
    temp = root.right;
    while (temp != null) {
      temp = temp.right;
      rightHeight++;
    }
    if (leftHeight == rightHeight) {
      return (1 << leftHeight) - 1;
    }
    return countNodes(root.left) + countNodes(root.right) + 1;
  }
}
