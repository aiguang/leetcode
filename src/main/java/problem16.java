import java.util.Arrays;

/**
 * Created by Administrator on 16-4-1.
 */
public class problem16 {
  public static void main(String[] args){
    int[] array = {0,2,1,-3};
    int target = 1;
    System.out.println(new problem16().threeSumClosest(array, target));
  }
  public int threeSumClosest(int[] nums, int target) {
    if(nums == null || nums.length == 0) return 0;
    Arrays.sort(nums);
    int min = Integer.MAX_VALUE;
    int result = 0;
    for(int i = 0; i < nums.length;i++){
      int first = i;
      int second = i + 1;
      int  third = nums.length - 1;
      while (second < third){
        int total = nums[first] + nums[second] + nums[third];
        if(total == target) return total;
        if(total < target){
          min = Math.min(min, Math.abs(target - total));
          result = target - min;
          while (second < nums.length - 2 && nums[second] == nums[second + 1]) second++;
          second++;
        }else{
          min = Math.min(min, Math.abs(total - target));
          result = target + min;
          while (third > 1 && nums[third] == nums[third - 1]) third--;
          third--;
        }
      }
    }
    return result;
  }
}
