/**
 * Created by Administrator on 16-2-23.
 */
public class problem75_1 {
  public static void main(String[] args){
    int[] nums = {1,2,0,2,1,1,1,2,0,0,0};
    new problem75_1().sortColors(nums);
    for(int i : nums){
      System.out.print(nums[i] + ",");
    }
  }

  public void sortColors(int[] nums) {
    if(nums == null || nums.length == 0) return;
    int zero = 0;
    int one = 0;
    int two = 0;
    for(int i = 0; i < nums.length;i++){
      if(nums[i] == 0) zero++;
      else if(nums[i] == 1) one++;
      else two++;
    }
    for(int i = 0;i < zero;i++) nums[i] = 0;
    for(int i = zero;i < one;i++) nums[i] = 1;
    for(int i = one;i < two;i++) nums[i] = 2;
  }
  public void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
