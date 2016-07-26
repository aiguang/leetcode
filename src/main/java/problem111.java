/**
 * Created by Administrator on 16-3-3.
 */
public class problem111 {

  public int minDepth(TreeNode root){
    if(root  == null ) return 0;
    if(root.left == null && root.right == null) return 1;
    int left = 1 + minDepth(root.left);
    int right = 1 + minDepth(root.right);
    return root.left == null ? right: (root.right == null ? left : Math.min(left, right) );
  }

}
