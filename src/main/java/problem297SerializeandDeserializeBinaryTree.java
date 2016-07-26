import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 Serialization is the process of converting a data structure or object into a sequence of bits
 so that it can be stored in a file or memory buffer,
 or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree.
 There is no restriction on how your serialization/deserialization algorithm should work.
 You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format,
 so please be creative and come up with different approaches yourself.
 Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class problem297SerializeandDeserializeBinaryTree {
  public static void main(String[] args){
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    TreeNode left1 = new TreeNode(4);
    TreeNode right1 = new TreeNode(5);

    root.left = left;
    root.right = right;

    right.left = left1;
    right.right = right1;

//    String result = new Codec().serialize(root);
//    System.out.println("decode result is " + result);
//
//    result = "5,2,3,null,null,2,4,3,1";
//    TreeNode n = new Codec().deserialize(result);
//    Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
//    queue.add(n);
//    while (!queue.isEmpty()){
//      TreeNode node = queue.poll();
//      System.out.print(node.val + ",");
//      if(node.left != null){
//
//      }
//    }

  }
}
class Codec {
  public String BFSserialize(TreeNode root) {
    List<TreeNode> queue = new LinkedList<TreeNode>();
    StringBuilder str = new StringBuilder();
    queue.add(root);
    while(!queue.isEmpty()) {
      TreeNode n = queue.remove(0);
      if(n != null) {
        queue.add(n.left);
        queue.add(n.right);
        str.append(n.val);
        str.append(',');
      } else {
        str.append("null,");
      }
    }
    return str.substring(0, str.length() - 1);
  }

  // Decodes your encoded data to tree.
  public TreeNode BFSdeserialize(String data) {
    List<TreeNode> queue = new LinkedList<TreeNode>();
    TreeNode dummy = new TreeNode(0);
    queue.add(dummy);
    data = "null," + data; //root is the right child of dummy root so add "null" as the left child
    String[] nodes = data.split(",");
    int i = 0;
    while(!queue.isEmpty() && i < nodes.length) {
      TreeNode n = queue.remove(0);
      if(n != null) {
        TreeNode left = null, right = null;
        if(!nodes[i].equals("null")) {
          left = new TreeNode(Integer.parseInt(nodes[i]));
          n.left = left;
        }
        i++;
        if(i < nodes.length && !nodes[i].equals("null")) {
          right = new TreeNode(Integer.parseInt(nodes[i]));
          n.right = right;
        }
        i++;
        queue.add(left);
        queue.add(right);
      }
    }
    return dummy.right;
  }
}
