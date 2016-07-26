import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 15-9-8.
 */
public class problem78 {
  public static void main(String[] args){
    int[] nums = {4,1,0};
    List<List<Integer>> result = new problem78().subsets(nums);
    for(List<Integer> list : result){
      for(Integer i : list){
        System.out.print(i + ",");
      }
      System.out.println();
    }
    System.out.println("total size is " + result.size());
  }
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(nums == null || nums.length == 0) return result;
      Arrays.sort(nums);
    calculate(nums, 0, result, new ArrayList<Integer>());
    return result;
  }
  private void calculate(int[] nums, int index, List<List<Integer>> result, List<Integer> tmp){
    List<Integer> list = new ArrayList<Integer>();
    for(int i = 0;i < tmp.size();i++){
      list.add(tmp.get(i));
    }
    result.add(list);
    for(int i = index; i < nums.length;i++){
      tmp.add(nums[i]);
      calculate(nums, i + 1, result, tmp);
      tmp.remove(tmp.size() - 1);
    }
  }
}
