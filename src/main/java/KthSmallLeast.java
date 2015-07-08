import java.util.Stack;

/**
 * Created by Administrator on 15-7-4.
 *
 *
 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class KthSmallLeast {
    public static void main(String[] args){

    }
    public void test(){
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        treeNode1.left = treeNode;
        kthSmallest(treeNode1, 2);
    }

    public int kthSmallest(TreeNode root, int k) {
        int index = 1;
        if(root == null){
            return 0;
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(p != null || !stack.isEmpty()){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(findK(index, k)){
                return p.val;
            }
            index++;
            p = p.right;
        }
        return 0;
    }
    private boolean findK(int current, int k){
        return current == k;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
