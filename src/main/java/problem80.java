import java.util.Arrays;

/**
 * Created by Administrator on 15-9-9.
 */
public class problem80 {
  public static void main(String[] args){
    int[] nums = {1,1,1,2,3,3};
    System.out.println(new problem80().removeDuplicates(nums));
    for(int i = 0 ; i < nums.length;i++){
      System.out.print(nums[i] + ",");
    }
  }
  public int removeDuplicates(int[] nums) {
     if(nums == null || nums.length == 0){
       return 0;
     }
    Arrays.sort(nums);
    int result = 1;
    int curValue = nums[0];
    int curSum = 1;
    int step = 0;
    for(int i = 1; i < nums.length;i++){
      if(curValue == nums[i]){
        curSum++;
        if(curSum <= 2){
          result++;
        }
        if(curSum > 2){
          step++;
        }
      }else{
        curValue = nums[i];
        curSum = 1;
        result++;
      }
      if(step > 0){
        nums[i - step ] = nums[i];
      }
    }
    return result;
  }
}
