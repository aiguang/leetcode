/**
 Given a binary tree, count the number of uni-value subtrees.

 A Uni-value subtree means all nodes of the subtree have the same value.

 For example:
 Given binary tree,
     5                                                   7
                                                       82  82
                                                    -79 98
    / \
   1   5
  / \   \
 5   5   5
 return 4.

 [7,82,82,-79,98,98,-79,-79,null,-28,-24,-28,-24,null,-79,null,97,65,-4,null,3,-4,65,3,null,97]

 */
public class problem250CountUnivalueSubtrees {
  public static void main(String[] args){
    TreeNode root = new TreeNode(5);
    TreeNode left = new TreeNode(1);
    TreeNode right = new TreeNode(5);

    root.left = left;
    root.right = right;

    TreeNode left1 = new TreeNode(5);
    TreeNode right1 = new TreeNode(5);
    left.left = left1;
    left.right = right1;

    TreeNode right2 = new TreeNode(5);
    right1.right = right2;

    System.out.println(new problem250CountUnivalueSubtrees().countUnivalSubtrees(root));
  }
  int count = 0;
  public int countUnivalSubtrees(TreeNode root) {
    if(root == null) return 0;
    helper(root);
    return count;
  }
  public MyNode helper(TreeNode node){
    if(node == null){
      return null;
    }
    MyNode left = helper(node.left);
    MyNode right = helper(node.right);

    MyNode my = new MyNode();
    my.value = node.val;
    if(left == null && right == null){
      my.isUni= true;
    }
    if(left == null && right != null){
      my.isUni = right.isUni && my.value == right.value;
    }
    if(left != null && right == null){
      my.isUni = left.isUni && my.value == left.value;
    }
    if(left != null && right != null){
      my.isUni = left.isUni && right.isUni && my.value == left.value && my.value == right.value;
    }
    if(my.isUni) count++;
    return my;
  }
  class MyNode{
    boolean isUni = false;
    int value = 0;
  }
}
