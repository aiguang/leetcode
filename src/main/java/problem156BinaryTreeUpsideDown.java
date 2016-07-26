import java.util.ArrayList;
import java.util.List;

/**
 Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty,
 flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

 For example:
 Given a binary tree {1,2,3,4,5},
     1
    / \
   2   3
  / \
 4   5
 return the root of the binary tree [4,5,2,#,#,3,1].
    4
   / \
  5   2
     / \
    3   1
 confused what "{1,#,2,3}" means?
 */
public class problem156BinaryTreeUpsideDown {
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root==null || root.left==null) { return root; }  // the new root of the upside-down tree
    TreeNode newRoot = upsideDownBinaryTree(root.left);
    TreeNode newParent = root.left;  // the new parent of current level is originally the left child
    newParent.left = root.right;
    newParent.right = root;
    newParent.right.left = null;  // set original parent's left and right pointer to null, otherwise there will be a loop at the last backtracking level
    newParent.right.right = null;
    return newRoot;
  }
}
