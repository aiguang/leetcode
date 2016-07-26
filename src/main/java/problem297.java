import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
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
public class problem297 {
  public static void main(String[] args){
    problem297 t = new problem297();
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);

    node1.left = node2;
    node1.right = node3;
    node3.left = node4;
    node3.right = node5;

    String se = t.serialize(node1);
    System.out.println(se);

    TreeNode root = t.deserialize(se);
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.add(root);
    while (!stack.isEmpty()){
      TreeNode tmp = stack.pop();
      if(tmp == null){
        System.out.print("null,");
        stack.push(null);
        stack.push(null);
      }else{
        System.out.print(tmp.val + ",");
        stack.push(tmp.right);
        stack.push(tmp.left);
      }
    }
  }
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if(root == null) return null;
    int height = getHeight(root);
    String[] array = new String[2 * height + 2];
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.add(root);
    int index = 0;
    while (!stack.isEmpty()){
      TreeNode tmp = stack.pop();
      array[index] =  tmp.val + "";

      if(tmp.right == null){
        if(2 * index + 2 < array.length){
          array[2 * index + 2] = "null";
        }
      }else {
        stack.push(tmp.right);
      }
      if(tmp.left == null){
        if(2 * index + 1 < array.length){
          array[2 * index + 1] = "null";
        }
      }else {
        stack.push(tmp.left);
      }
      if(tmp.left != null || tmp.right != null){
        index = 2 * index + 2;
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < array.length;i++){
      if("null".equals(array[i])) sb.append("null");
      else sb.append(array[i] + "");
      sb.append(",");
    }
    return sb.substring(0, sb.length() - 1);
  }
  private int getHeight(TreeNode node){
    int left = 1;
    int right = 1;
    if(node.left != null){
      left = getHeight(node.left ) + 1;
    }
    if(node.right != null){
      right = getHeight(node.right) + 1;
    }
    return Math.max(left, right);
  }


  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if(data == null) return null;
    String[] array = data.split(",");
    TreeNode root = new TreeNode(Integer.parseInt(array[0]));
    Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
    map.put(0, root);
    for(int i = 0; i < array.length / 2;i++){
      TreeNode node = map.get(i);
      if(node == null){
        node = new TreeNode(node.val);
      }
      map.put(i, node);
      TreeNode left = map.get(2 * i + 1);
      if(left == null){
        left = new TreeNode(Integer.parseInt(array[2 * i + 1]));
      }
      map.put(2 * i + 1, left);
      node.left = left;

      TreeNode right = map.get(2 * i + 2);
      if(right == null){
        right = new TreeNode(Integer.parseInt(array[2 * i + 2]));
      }
      map.put(2 * i + 2, right);
      node.right = right;
    }
    return map.get(0);
  }
}
