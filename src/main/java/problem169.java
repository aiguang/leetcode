import java.util.HashMap;
import java.util.Map;

/**
 Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class problem169 {
  public static void main(String[] args){
    int[] a = {2,3,3};
    System.out.println(new problem169().majorityElement(a));
  }
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i = 0; i < nums.length;i++){
      Integer current = map.get(nums[i]);
      if(current == null){
        map.put(nums[i], 1);
      }else {
        map.put(nums[i], ++current);
      }
    }
    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
      if(entry.getValue() >= Math.round((double)nums.length/2)){
        return entry.getKey();
      }
    }
    return 0;
  }
}
