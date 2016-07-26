/**
 * Created by Administrator on 15-8-18.
 */
public class problem26 {
  public static void main(String[] args){
    int[] nums = {1,2};
    System.out.println(new problem26().removeDuplicates(nums));
  }
  public int removeDuplicates(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int i = 0;
    int k = 1;
    for(; i < nums.length && k < nums.length;){
      if(nums[i] == nums[k]){
        k++;
      }else{
        nums[i + 1] = nums[k];
        i++;
        k++;
      }
    }
    return i + 1;
  }
}
