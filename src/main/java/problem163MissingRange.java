import java.util.ArrayList;
import java.util.List;

/**
 Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

 For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class problem163MissingRange {
  public List<String> getRange(int[] nums){
    if(nums == null || nums.length == 0) return null;
    List<String> result = new ArrayList<String>();
    if(nums[0] == 1) result.add("0");
    if(nums[0] > 1) result.add(0 + "->" + (nums[0] - 1));
    int first = 0;
    int second = 1;
    for(int i = 1; i < nums.length;i++){
      if(nums[i] - nums[i - 1] > 1){
        result.add((nums[i - 1] + 1 ) + "->" + (nums[i] - 1));
      }
    }
    if(nums[nums.length - 1] < 99){
      result.add((nums[nums.length - 1] + 1) + "->" + 99);
    }
    return result;
  }
}
