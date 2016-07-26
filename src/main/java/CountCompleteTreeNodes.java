import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 15-7-15.
 *
 * Given a complete binary tree, count the number of nodes.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last, is completely filled,
 and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * 求满二叉树节点个数
 * 1. 直接递归超时
 * 2. 用层遍历超时
 * 3. 先序超时
 * TODO 正解：先判断是否为满二叉树，注意题干说了最后一层的节点都尽量在左边。所以可以通过左右深度是否一样来判断。
 *
 */
public class CountCompleteTreeNodes {
    public static void main(String[] args){
        System.out.println(1 << 5);
    }

    public int countNodes(TreeNode root) {
        int left = 0;
        TreeNode node = root;
        while(node.left != null){
            left++;
            node = node.left;
        }
        int right = 0;
        node = root;
        while(node != null){
            right++;
            node = node.right;
        }
        if(left == right) return (int)Math.pow(2, left) - 1;
        return countNodes(root.left) + countNodes(root.left) + 1;
    }

}
