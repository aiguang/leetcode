/**
 * Created by Administrator on 16-5-18.
 */
public class problem333LargestBSTSubtree {
  int max = 0;
  public static void main(String[] args){
    TreeNode root = new TreeNode(2);
//    root.left = new TreeNode(3);
//    root.left.left = new TreeNode(1);
    System.out.println(new problem333LargestBSTSubtree().largestBSTSubtree(root));
  }
  public int largestBSTSubtree(TreeNode root) {
    if(root == null) return 0;
    getNode(root);
    return max;
  }
  public DataNode getNode(TreeNode root){
    if(root == null){
      DataNode node = new DataNode();
      node.min = Integer.MAX_VALUE;
      node.max = Integer.MIN_VALUE;
      node.isBST = true;
      return node;
    }
    DataNode leftNode = getNode(root.left);
    DataNode rightNode = getNode(root.right);
    DataNode curNode = new DataNode();
    curNode.min = Math.min(root.val, Math.min(leftNode.min, rightNode.min));
    curNode.max = Math.max(root.val, Math.max(leftNode.max, rightNode.max));
    if(leftNode.isBST && root.val > leftNode.max && rightNode.isBST && root.val < rightNode.min){
      curNode.isBST = true;
      curNode.size = leftNode.size + rightNode.size + 1;
      max = Math.max(curNode.size, max);
    }else{
      curNode.size = 0;
    }
    return curNode;
  }

  class DataNode{
    int min;
    int max;
    int size;
    boolean isBST;
  }
}

