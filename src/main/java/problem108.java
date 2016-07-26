import java.util.ArrayList;
import java.util.List;

/**
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class problem108 {
  public static void main(String[] args){
    int[] nums = {1,3};
    System.out.print(new problem108().sortedArrayToBST(nums));
  }
  public TreeNode sortedArrayToBST(int[] nums) {
    if(nums == null || nums.length == 0) return null;
    return create(0, nums.length, nums);
  }
  private TreeNode create(int start, int end, int[] nums){
    if(start > end) return null;
    int mid = start + (end - start)/2;
    if(mid < 0 || mid >= nums.length) return  null;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = create(start, mid - 1, nums);
    root.right = create(mid + 1, end, nums);
    return root;
  }
}
