/**
 * Created by Administrator on 16-6-15.
 */
public class problem283MovingZeros {
  public static void main(String[] args){
    int[] nums = {0,1,0,2,3,4,0,0,1};
    new problem283MovingZeros().moveZeroes(nums);
    for(Integer v : nums){
      System.out.print(v + ",");
    }
  }
  public void moveZeroes(int[] nums) {
    if(nums == null || nums.length == 0) return;
    int left = 0, right = nums.length - 1;
    while(left < right){
      while (left < nums.length && nums[left] != 0){
        left++;
      }
      while (right >= 0 && nums[right] == 0){
        right--;
      }
      if(left < nums.length && right >= 0 && left < right){
        swap(nums, left, right);
        left++;
        right--;
      }

    }
  }
  public void moveZeros1(int[] nums){
    if(nums == null || nums.length == 0) return;

  }
  private void swap(int[] nums, int i, int j){
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
