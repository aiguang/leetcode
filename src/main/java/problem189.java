/**
 Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

 [show hint]

 Hint:
 Could you do it in-place with O(1) extra space?
 Related problem: Reverse Words in a String II
 */
public class problem189 {
  public static void main(String[] args){
    int[] array = {1,2};
    int k = 3;
    new problem189().rotate(array, k);
  }
  public void rotate(int[] nums, int k) {
    if(nums == null || nums.length == 0 || k <= 0) return;
//    if(nums.length <= k) return;
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < nums.length;i++){
      sb.append(nums[i]);
    }
    String tmp = sb.toString();
    tmp = tmp.substring(tmp.length() - k, tmp.length()) + tmp.substring(0, tmp.length() - k);
    for(int i = 0; i < tmp.length();i++){
      nums[i] = Integer.parseInt(String.valueOf(tmp.charAt(i)));
      System.out.print(nums[i] + ",");
    }
  }
}
