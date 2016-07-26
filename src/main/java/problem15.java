import sun.management.resources.agent_de;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 16-2-3.
 */
public class problem15 {
  public static void main(String[] args){
    int[] array = {-1,0,1,2,-1,-4};
    List<List<Integer>> result = new problem15().threeSum(array);
    for(List<Integer> list : result){
      for(Integer t : list){
        System.out.print(t + ",");
      }
      System.out.println();
    }
  }
  public List<List<Integer>> threeSum(int[] nums) {
    if(nums == null || nums.length == 0) return new ArrayList<List<Integer>>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    for(int i = 0; i < nums.length; i++){
      if(i > 0 && nums[i] == nums[i - 1]) continue;
      int first = i;
      int second = i + 1;
      int third = nums.length - 1;
      while (second < third){
        if(nums[first] + nums[second] + nums[third] > 0) third--;
        else if(nums[first] + nums[second] + nums[third] < 0) second++;
        else{
          List<Integer> tmp = new ArrayList<Integer>();
          tmp.add(nums[first]);
          tmp.add(nums[second]);
          tmp.add(nums[third]);
          result.add(tmp);
          second++;
          third--;
          while (second < nums.length - 2 && nums[second] == nums[second + 1]) second++;
          while (third >= 1 && nums[third] == nums[third - 1]) third--;
          while (i < nums.length - 2 && nums[i] == nums[i + 1])i++;
        }
      }
    }
    return result;
  }
}
