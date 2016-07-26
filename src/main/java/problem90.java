import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 15-9-25.
 */
public class problem90 {
  public static void main(String[] args){
    int[] nums = {1,2,2};
    List<List<Integer>> result = new problem90().subsetsWithDup(nums);
    for(List<Integer> list : result){
      for(Integer value : list){
        System.out.print(value + ",");
      }
      System.out.println();
    }
  }
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(nums == null || nums.length == 0) return result;
    Arrays.sort(nums);
    calculate(result, new ArrayList<Integer>(), 0, nums);
    return result;
  }

  private void calculate(List<List<Integer>> result, List<Integer> tmp, int index, int[] nums){
    List<Integer> list = new ArrayList<Integer>();
    for(Integer value : tmp){
      list.add(value);
    }
    result.add(list);

    for(int i = index; i < nums.length;i++){
      tmp.add(nums[i]);
      calculate(result, tmp, i + 1, nums);
      tmp.remove(tmp.size() - 1);
      while(i < nums.length - 1 && nums[i] == nums[i + 1])
        i++;
    }
  }
}
