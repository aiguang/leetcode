import java.util.*;

/**
 * Created by Administrator on 15-7-14.
 *
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w
 * as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

             _______3______
             /              \
             ___5__          ___1__
             /      \        /      \
             6      _2       0       8
             /  \
             7   4
 For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
 Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestor {
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(37);
        TreeNode node2 = new TreeNode(-34);
        TreeNode node3 = new TreeNode(-48);
        TreeNode node4 = new TreeNode(-100);
        TreeNode node5 = new TreeNode(-100);
        TreeNode node6 = new TreeNode(48);
        TreeNode node7 = new TreeNode(-54);
        TreeNode node8 = new TreeNode(-71);
        TreeNode node9 = new TreeNode(-22);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;
        node6.left = node8;
        node6.right = node9;


        LowestCommonAncestor test = new LowestCommonAncestor();
        TreeNode node = test.lowestCommonAncestor(node1, node5, node8);
        System.out.println(node.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(p == null && q == null){
            return null;
        }
        List<TreeNode> pPath = new ArrayList<TreeNode>();
        boolean isFindP = findPath(root, p, pPath);
        if(!isFindP) return null;

        List<TreeNode> qPath = new ArrayList<TreeNode>();
        boolean isFindQ = findPath(root, q, qPath);
        if(!isFindQ) return null;

        while(!qPath.isEmpty() && !pPath.isEmpty()){
            if(qPath.size() > pPath.size()){
                TreeNode tmpNode = qPath.remove(qPath.size() - 1);
                if(tmpNode.equals(p)){
                    return p;
                }
            }else if(qPath.size() < pPath.size()){
                TreeNode tmpNode = pPath.remove(pPath.size() - 1);
                if(tmpNode.equals(q)){
                    return q;
                }
            }else{
                TreeNode qNode = qPath.remove(qPath.size() - 1);
                TreeNode pNode = pPath.remove(pPath.size() - 1);
                if(qNode.equals(pNode)){
                    return qNode;
                }
            }
        }
        return null;
    }
    private boolean findPath(TreeNode current, TreeNode target, List<TreeNode> list){
        if(current == null){
            return false;
        }
        list.add(current);
        if(current.equals(target)){
            return true;
        }
        boolean isFind = findPath(current.left, target, list) || findPath(current.right, target, list);
        if(isFind) return true;
        list.remove(list.size() - 1);
        return false;
    }
}
