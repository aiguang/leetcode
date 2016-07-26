import java.util.ArrayList;
import java.util.List;

/**
 Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class problem46_1 {
  public static void main(String[] args){
    int[] nums = {1,2,3};
    List<List<Integer>> result = new problem46_1().permute(nums);
    for(List<Integer> list : result){
      for(Integer i : list){
        System.out.print(i + ",");
      }
      System.out.println();
    }
  }
  public List<List<Integer>> permute(int[] nums){
    if(nums == null || nums.length == 0) return new ArrayList<List<Integer>>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    helper(result, new ArrayList<Integer>(), nums, 0);
    return result;
  }
  private void helper(List<List<Integer>> result,  List<Integer> curList, int[] nums, int index){
    if(index == nums.length - 1){
      List<Integer> tmp = new ArrayList<Integer>();
      for(Integer i : nums){
        tmp.add(i);
      }
      result.add(tmp);
      return;
    }
    for(int i = index ; i < nums.length ;i++){
      swap(nums, i, index);
      helper(result, curList, nums, index + 1);
      swap(nums, index, i);
    }
  }
  private void swap(int[] nums, int i, int j){
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
