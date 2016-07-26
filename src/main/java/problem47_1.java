import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-2-18.
 */
public class problem47_1 {
  public static void main(String[] args){
    int[] nums = {2,2,1,1};
    List<List<Integer>> result = new problem47_1().permuteUnique(nums);
    for(List<Integer> list : result){
      for(Integer i : list){
        System.out.print(i + ",");
      }
      System.out.println();
    }
  }
  public List<List<Integer>> permuteUnique(int[] nums) {
    if(nums == null || nums.length == 0) return new ArrayList<List<Integer>>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    helper(result, nums, 0);
    return result;
  }
  private void helper(List<List<Integer>> result,  int[] nums, int index){
    if(index == nums.length - 1){
      List<Integer> tmp = new ArrayList<Integer>();
      for(Integer i : nums){
        tmp.add(i);
      }
      result.add(tmp);
      return;
    }
    for(int i = index ; i < nums.length ;i++){
      if(isSwap(index, i, nums)){
        swap(nums, i, index);
        helper(result, nums, index + 1);
        swap(nums, index, i);
      }
    }
  }
  private boolean isSwap(int start, int end, int[] nums){
    for(int i = start;i < end;i++){
      if(nums[i] == nums[end]) return false;
    }
    return true;
  }
  private void swap(int[] nums, int i, int j){
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
