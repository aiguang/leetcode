import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-8-19.
 */
public class problem34 {
  public static void main(String[] args){
    int[] nums = {8,8,8,8,8,8,8,8};
    int[] result = new problem34().searchRange(nums, 8);
    for(Integer value :result){
      System.out.print(value + ",");
    }
  }
  public int[] searchRange(int[] nums, int target) {
    int[] result = {-1,-1};
    if(nums == null || nums.length == 0) return result;
    calculate(nums,target, 0, nums.length - 1, result);
    return result;
  }
  public void calculate(int[] nums, int target, int low , int high, int[] result){
    if(low <= high){
      int middle = (low + high)/2;
      if(nums[middle] == target){
        if(middle < result[0] || result[0] == -1) result[0] = middle;
        if(middle > result[1] || result[1] == -1) result[1] = middle;
        int tmpLow = low;
        int tmpHigh = high;
        
      }else if(nums[middle] < target){
        calculate(nums, target, middle + 1, high, result);
      }else{
        calculate(nums, target, low, middle - 1, result);
      }
    }
  }

}
