import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
 are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class problem1 {
  public static void main(String[] args){
    int[] value = {0,4,3,0};
    int[] result = new problem1().twoSum(value, 0);
    System.out.println(result[0] + "," + result[1]);
  }

  public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    if(numbers == null || numbers.length < 2) return result;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i = 0; i < numbers.length ;i++){
      Integer tmp = map.get(numbers[i]);
      if(tmp == null){
        map.put(numbers[i], i + 1);
      }else {
        if(target == 2 * numbers[i]){
          result[0] = tmp;
          result[1] = i + 1;
          return result;
        }
      }
    }
    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
      if(map.containsKey(target - entry.getKey())){
        result[0] = Math.min(entry.getValue(), map.get(target - entry.getKey()));
        result[1] = Math.max(entry.getValue(), map.get(target - entry.getKey()));
        break;
      }
    }
    return result;
  }
}

