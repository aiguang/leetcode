import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 15-8-17.
 */
public class problem18 {

  public static void main(String[] args) {
    int[] nums = {-1,-5,-5,-3,2,5,0,4};
    int target = -7;
    List<List<Integer>> result = new problem18().fourSum(nums, target);
    for (List<Integer> list : result) {
      for (Integer value : list) {
        System.out.print(value + ",");
      }
      System.out.println();
    }
    System.out.println("length is " + result.size());
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums == null || nums.length < 3) {
      return result;
    }
    Arrays.sort(nums);

    Set<String> set = new HashSet<String>();
    for (int j = 0; j < nums.length; j++) {
      for (int i = j + 1; i < nums.length; i++) {
        int low = i + 1;
        int high = nums.length - 1;
        while (low < high) {
          int tmp = nums[i] + nums[low] + nums[high] + nums[j];
          if (tmp == target) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[j]).append(nums[i]).append(nums[low]).append(nums[high]);
            if(!set.contains(sb.toString())){
              result.add(Arrays.asList(nums[j], nums[i], nums[low], nums[high]));
              set.add(sb.toString());
            }
            while(low < nums.length - 1 && nums[low] == nums[low + 1])low++;
            while(high > 0 && nums[high] == nums[high - 1])high--;
            while(i < nums.length - 1 && nums[i] == nums[i + 1])i++;
            low++;
            high--;
          } else if (tmp < target) {
            low++;
          } else {
            high--;
          }
        }
      }
    }

    return result;
  }
}
