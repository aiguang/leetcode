import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */
public class problem116 {
  public static void  main(String[] args){
    TreeLinkNode node0 = new TreeLinkNode(0);
    TreeLinkNode node1 = new TreeLinkNode(1);
    TreeLinkNode node2 = new TreeLinkNode(2);
    TreeLinkNode node3 = new TreeLinkNode(3);
    TreeLinkNode node4 = new TreeLinkNode(4);
    TreeLinkNode node5 = new TreeLinkNode(5);
    TreeLinkNode node6 = new TreeLinkNode(6);
    TreeLinkNode node7 = new TreeLinkNode(7);
    TreeLinkNode node8 = new TreeLinkNode(8);
    TreeLinkNode node9 = new TreeLinkNode(9);
    TreeLinkNode node10 = new TreeLinkNode(10);
    TreeLinkNode node11 = new TreeLinkNode(11);
    TreeLinkNode node12 = new TreeLinkNode(12);
    TreeLinkNode node13 = new TreeLinkNode(13);
    TreeLinkNode node14 = new TreeLinkNode(14);


    node0.left = node1;
    node0.right = node2;


    node1.left = node3;
    node1.right = node4;

    node2.left = node5;
    node2.right = node6;

    node3.left = node7;
    node3.right = node8;

    node4.left = node9;
    node4.right = node10;

    node5.left = node11;
    node5.right = node12;

    node6.left = node13;
    node6.right = node14;

    new problem116().connect(node0);
    int i = 1;
  }
  public void connect(TreeLinkNode root) {
    if(root == null) return;
    Queue<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();
    queue.add(root);

    int level = 0;
    int count = 1;
    TreeLinkNode node = null;
    while (!queue.isEmpty()){
      TreeLinkNode tmp = queue.poll();

      if(tmp.left != null){
        queue.add(tmp.left);
      }
      if(tmp.right != null){
        queue.add(tmp.right);
      }

      if(count != Math.pow(2, level)){
        if(node == null){
          node = tmp;
          count--;
        }else {
          node.next = tmp;
          node = node.next;
        }
        count++;
      }else {
        if(node != null){
          node.next = null;
          node = tmp;
        }
        count = 1;
        level += 1;
      }
    }
  }
}
