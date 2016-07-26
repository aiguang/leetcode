import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 15-8-28.
 */
public class problem46 {
  public static void main(String[] args){
    int[] nums = {1, 2, 3};
    List<List<Integer>> result = new problem46().permute(nums);
    for(List<Integer> list : result){
      for(int r : list){
        System.out.print(r + ",");
      }
      System.out.println();
    }
    System.out.println("total result is " + result.size());
  }
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(nums == null || nums.length == 0) return result;
    permute(nums, result, 0);
    return result;
  }
  public void permute(int[] nums, List<List<Integer>> result, int st){
    if(st == nums.length - 1){
      List<Integer> tmp = new ArrayList<Integer>();
      for(int j = 0; j < nums.length;j++){
        tmp.add(nums[j]);
      }
      result.add(tmp);
    }else{
      for (int i = st; i < nums.length; i ++){
        swap(nums, st, i);
        permute(nums,result, st + 1);
        swap(nums, st, i);
      }
    }
  }
  private void swap(int[] nums, int i, int j){
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
