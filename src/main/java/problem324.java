import java.util.Arrays;

/**
 Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example:
 (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

 Note:
 You may assume all input has valid answer.

 Follow Up:
 Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class problem324 {
  public static void main(String[] args){
    int[] nums = {1,4,1,3,1,5,7};
    new problem324().wiggleSort(nums);
    for(int i = 0; i < nums.length;i++){
      System.out.print(nums[i]);
    }
  }

  public void wiggleSort(int[] nums) {
    if(nums == null || nums.length < 3) return;
    Arrays.sort(nums);
    int[] q = new int[nums.length];
    int start = 0;
    int mid = nums.length / 2;
    for(int i = 0; i < nums.length;i++){
      if(i % 2 == 0) q[i] = nums[start++];
      else  q[i] = nums[mid++];
    }
    for(int i = 0; i < q.length;i++){
      nums[i] = q[i];
    }
  }
}
