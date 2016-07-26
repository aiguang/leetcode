import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

 If two nodes are in the same row and column, the order should be from left to right.

 Examples:

 Given binary tree [3,9,20,null,null,15,7],
   3
   /\
  /  \
  9  20
     /\
    /  \
    15   7
 return its vertical order traversal as:
 [
 [9],
 [3,15],
 [20],
 [7]
 ]
 Given binary tree [3,9,8,4,0,1,7],
   3
   /\
  /  \
  9   8
  /\  /\
 /  \/  \
 4  01   7
 return its vertical order traversal as:
 [
 [4],
 [9],
 [3,0,1],
 [8],
 [7]
 ]
 Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
      3
     /\
    /  \
    9   8
    /\  /\
    /  \/  \
    4  01   7
      /\
     /  \
     5   2
 return its vertical order traversal as:
 [
 [4],
 [9,5],
 [3,0,1],
 [8,2],
 [7]
 ]
 */
public class problem314BinaryTreeVerticalOrderTraversal {
  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(root == null) return result;
    Queue<Pair> queue = new ArrayDeque<Pair>();
    Pair p = new Pair(root, 0);
    queue.add(p);
    int min = 0, max = 0;
    HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    while(!queue.isEmpty()){
      Pair curPair = queue.poll();
      min = Math.min(curPair.order, min);
      max = Math.max(curPair.order, max);
      if(curPair.node.left != null){
        Pair left = new Pair(curPair.node.left, curPair.order - 1);
        queue.offer(left);
      }
      if(curPair.node.right != null){
        Pair left = new Pair(curPair.node.right, curPair.order + 1);
        queue.offer(left);
      }
      List<Integer> list = map.get(curPair.order);
      if(list == null){
        list = new ArrayList<Integer>();
      }
      list.add(curPair.node.val);
      map.put(curPair.order, list);
    }
    for(int i=min;i<=max;i++){
      if(map.containsKey(i)){
        result.add(map.get(i));
      }
    }
    return result;
  }

  class Pair {
    TreeNode node;
    int order;
    public Pair(TreeNode n, int i) {
      node = n;
      order = i;
    }
  }
}
